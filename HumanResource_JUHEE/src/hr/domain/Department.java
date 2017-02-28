package hr.domain;

import java.util.ArrayList;
import java.util.List;

public class Department {
	//
	private String no;
	private String name;
	private List<Employee> employees;
	
	public Department(String no, String name) {
		//
		this.no = no;
		this.name = name;
		this.employees = new ArrayList<>();
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
