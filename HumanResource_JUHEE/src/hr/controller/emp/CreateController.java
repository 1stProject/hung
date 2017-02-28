package hr.controller.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Department;
import hr.domain.Employee;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/employee/create.do")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HumanResourceService service;
	
	public CreateController(){
		service = HumanResourceServiceLogic.getInstance();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Department dept = service.findDepartment(request.getParameter("deptNo"));
		request.setAttribute("department", dept);

		request.getRequestDispatcher("/views/employeeCreate.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = new Employee();
		emp.setNo(request.getParameter("empNo"));
		emp.setName(request.getParameter("empName"));
		
		emp.setDeptNo(request.getParameter("deptNo"));
		service.registerEmployee(emp);
		if(emp.getDeptNo().equals("null")|| emp.getDeptNo().equals("") || emp.getDeptNo()== null){
			request.getRequestDispatcher("/employee/list.do").forward(request, response);
		} 
		request.getRequestDispatcher("/dept/detail.do").forward(request, response);
	

	}

}
