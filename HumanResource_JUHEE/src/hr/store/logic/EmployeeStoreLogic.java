package hr.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hr.domain.Employee;
import hr.store.EmployeeStore;
import hr.store.factory.ConnectionFactory;
import hr.store.utils.JdbcUtils;

public class EmployeeStoreLogic implements EmployeeStore {
	private ConnectionFactory factory;

	public EmployeeStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public List<Employee> retrieveAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<>();
		
		try {
			conn=factory.createConnection();
			stmt = conn.createStatement();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("select empNo, name, deptNo from employee_tb order by deptNo , empNo asc");
			
			rs = stmt.executeQuery(stringBuilder.toString());

			while(rs.next()){	
				list.add(mapping(rs));
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQL 오류 : 전체목록을 불러오는 도중 문제가 발생했습니다.");
		} finally {
			JdbcUtils.close(conn, stmt, rs);
		}
		return list;
	}

	@Override
	public void create(Employee employee) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn=factory.createConnection();
			pstmt = conn.prepareStatement("insert into employee_tb(empNo, name, deptNo) values(?,?,?)");
			
			pstmt.setString(1, employee.getNo());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getDeptNo());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL 오류 : 신규 사원 등록에 실패했습니다.");
		} finally {
			JdbcUtils.close(conn, pstmt);
		}
	}

	@Override
	public List<Employee> retrieveByDeptNo(String deptNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<Employee> list = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select empno, name, deptNo from employee_tb where deptNo = ? order by deptNo, empno asc");
			pstmt.setString(1, deptNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){				
				list.add(mapping(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL 오류 : 사원 검색에 실패했습니다.");
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}
		return list;
	}
	
	@Override
	public void update(Employee employee) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("update employee_tb set name = ?, deptNo = ? where empNo = ?");
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getDeptNo());
			pstmt.setString(3, employee.getNo());
						
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL 오류 : 사원정보 수정에 실패했습니다.");
		} finally {
			JdbcUtils.close(conn, pstmt);
		} 
	}

	@Override
	public Employee retrieve(String empNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select empNo, name, deptNo from employee_tb where empNo =?");
			pstmt.setString(1, empNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				emp = mapping(rs);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL 오류 : 사원을 찾는 데 실패하였습니다.");
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}
		return emp;
	}
	
	private Employee mapping(ResultSet rs){
		Employee emp = new Employee();

		try {
			emp.setNo(rs.getString("empNo"));
			emp.setName(rs.getString("name"));
			emp.setDeptNo(rs.getString("deptNo"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL 오류 : mapping 도중 문제가 발생하였습니다.");
		} 
		return emp;
	}

}
