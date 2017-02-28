package hr.service.logic;

import java.util.List;

import hr.domain.Department;
import hr.domain.Employee;
import hr.service.HumanResourceService;
import hr.store.DepartmentStore;
import hr.store.EmployeeStore;
import hr.store.logic.DepartmentStoreLogic;
import hr.store.logic.EmployeeStoreLogic;

public class HumanResourceServiceLogic implements HumanResourceService{
	
	private DepartmentStore deptStore;
	private EmployeeStore empStore;
	private static HumanResourceService instance;
	
	private HumanResourceServiceLogic() {
		deptStore = new DepartmentStoreLogic();
		empStore = new EmployeeStoreLogic();
	}

	@Override
	public List<Department> findAllDepartment() {
		return deptStore.retrieveAll();
	}

	@Override
	public void registeDepartment(Department department) {
		deptStore.create(department);
	}

	@Override
	public Department findDepartment(String deptNo) {
		Department dept = null;

		if(deptNo == null || deptNo.equals("") || deptNo.equals("null")){
			dept = new Department("null", "null");
		} else {
			dept = deptStore.retrieve(deptNo);
		}
		dept.setEmployees(empStore.retrieveByDeptNo(deptNo));
		
		return dept;
		
	}

	@Override
	public List<Employee> findAllEmployee() {
		return empStore.retrieveAll();
	}

	@Override
	public void registerEmployee(Employee employee) {
		empStore.create(employee);
	}

	@Override
	public void removeDepartment(String deptNo) {
		deptStore.delete(deptNo);
		for(Employee employee : empStore.retrieveByDeptNo(deptNo)){
			employee.setDeptNo("null");
			empStore.update(employee);
		}
	}

	@Override
	public Employee findEmployee(String empNo) {
		return empStore.retrieve(empNo);
	}

	@Override
	public void modify(Employee employee) {
		empStore.update(employee);
	}
	
	public static HumanResourceService getInstance(){
		if(instance == null){
			instance = new HumanResourceServiceLogic();
		}
		return instance;
	}

	@Override
	public List<Department> findAllDepartmentEmployee() {
		List<Department> deptList = findAllDepartment();
		
		for(Department dept :deptList){
			dept.setEmployees(findDepartment(dept.getNo()).getEmployees());
		}
		Department dept = new Department("null", "null");
		dept.setEmployees(findDepartment("null").getEmployees());
		deptList.add(dept);
		
		return deptList;
	}

}
