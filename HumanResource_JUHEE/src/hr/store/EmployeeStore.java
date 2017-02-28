package hr.store;

import java.util.List;

import hr.domain.Employee;

public interface EmployeeStore {
	//
	List<Employee> retrieveAll();
	void create(Employee employee);
	List<Employee> retrieveByDeptNo(String deptNo);
	void update(Employee employee);
	Employee retrieve(String empNo);
}
