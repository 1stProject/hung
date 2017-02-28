package hr.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hr.domain.Department;
import hr.store.DepartmentStore;
import hr.store.factory.ConnectionFactory;
import hr.store.utils.JdbcUtils;

public class DepartmentStoreLogic implements DepartmentStore {

	private ConnectionFactory factory;

	public DepartmentStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public List<Department> retrieveAll() {		
		return DBSelect("select deptNo, deptName from department_tb order by deptno asc");
	}

	@Override
	public void create(Department department) {
		StringBuilder builder = new StringBuilder();
		builder.append("insert into department_tb(deptNo, deptName) values('");
		builder.append(department.getNo() + "', '");
		builder.append(department.getName() + "' )");
		
		DBUpdate(builder.toString());
	}

	@Override
	public Department retrieve(String deptNo) {
		StringBuilder builder = new StringBuilder();
		builder.append("select deptNo, deptName from department_tb where deptNo = ");
		builder.append(deptNo);		
		return DBSelect(builder.toString()).get(0);
	}

	@Override
	public void delete(String deptNo) {
		DBUpdate("delete from department_tb where deptNo = "+deptNo);
	}
	
	private List<Department> DBSelect(String sql){
		StackTraceElement[] ste = new Throwable().getStackTrace();
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		List<Department> deptList = new ArrayList<>();
		
		try {
			conn = factory.createConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Department dept = new Department(rs.getString("deptNo"), rs.getString("deptName"));
				deptList.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			for(int i = ste.length-1; i>0; i--){
				System.out.println("클래스 이름 '"+ste[i].getClassName()+"'의 ");
				System.out.println("'"+ste[i].getLineNumber()+"'째 줄, ");
				System.out.println("'"+ste[i].getMethodName()+"' 메소드에서 오류 발생 ");
			}
			throw new RuntimeException("SQL 오류 : Query 실행 도중 오류가 발생했습니다. ");
		} finally {
			JdbcUtils.close(rs, conn, stmt);
		}
		return deptList;
	}
	
	private void DBUpdate(String sql){
		StackTraceElement[] ste = new Throwable().getStackTrace();
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = factory.createConnection();
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			for(int i = ste.length-1; i>0; i--){
				System.out.println("클래스 이름 '"+ste[i].getClassName()+"'의 ");
				System.out.println("'"+ste[i].getLineNumber()+"'째 줄, ");
				System.out.println("'"+ste[i].getMethodName()+"' 메소드에서 오류 발생 ");
			}
		} finally {
			JdbcUtils.close(conn, stmt);
		}
	}
	
	private Department mapping(ResultSet rs){
		Department dept = null;
		try {
			dept = new Department(rs.getString("deptNo"), rs.getString("deptName"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL 오류 : mapping을 실패하였습니다. ");
		} 
		return dept;
	}
	
}
