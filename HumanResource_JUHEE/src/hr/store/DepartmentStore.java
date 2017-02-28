package hr.store;

import java.util.List;

import hr.domain.Department;

public interface DepartmentStore {
	//
	/**
	 * 부서 전체목록 조회
	 * @return
	 */
	List<Department> retrieveAll();
	
	/**
	 * 부서 등록
	 * @param department
	 */
	void create(Department department);
	
	/**
	 * 부서 조회
	 * @param deptNo 부서번호
	 * @return
	 */
	Department retrieve(String deptNo);
	
	/**
	 * 부서 삭제
	 * @param deptNo
	 */
	void delete(String deptNo);
}














