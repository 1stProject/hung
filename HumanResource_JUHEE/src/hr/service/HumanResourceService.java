package hr.service;

import java.util.List;

import hr.domain.Department;
import hr.domain.Employee;

public interface HumanResourceService {
	//
	/**
	 * 전체 부서목록 조회
	 * @return
	 */
	List<Department> findAllDepartment();
	
	/**
	 * 부서 등록
	 * @param department
	 */
	void registeDepartment(Department department);
	
	/**
	 * <pre>
	 * 부서 조회
	 * 부서정보 + 소속직원 목록
	 * </pre>
	 * @param deptNo 부서 번호
	 * @return
	 */
	Department findDepartment(String deptNo);
	
	/**
	 * 전체 직원목록 조회
	 * @return
	 */
	List<Employee> findAllEmployee();
	/**
	 * 전체 부서 및 직원목록 조회
	 * @return
	 */
	List<Department> findAllDepartmentEmployee();	
	/**
	 * 직원등록
	 * @param employee
	 */
	void registerEmployee(Employee employee);
	
	/**
	 * 부서 삭제
	 * @param deptNo
	 */
	void removeDepartment(String deptNo);
	
	/**
	 * 직원 조회
	 * @param empNo
	 * @return
	 */
	Employee findEmployee(String empNo);
	
	/**
	 * 직원정보 수정
	 * @param employee
	 */
	void modify(Employee employee);
}








