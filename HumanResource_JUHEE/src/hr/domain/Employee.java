package hr.domain;

public class Employee {
	//
	private String no;
	private String name;
	private String deptNo;
	
	public Employee() {
		//
	}
	
	public Employee(String no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public Employee(String no, String name, String deptNo) {
		this(no, name);
		this.deptNo = deptNo;
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

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	
}

