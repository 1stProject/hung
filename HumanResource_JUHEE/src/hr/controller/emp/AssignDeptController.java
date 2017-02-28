package hr.controller.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Department;
import hr.domain.Employee;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/employee/assignDept.do")
public class AssignDeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HumanResourceService service;
	
	public AssignDeptController(){
		service = HumanResourceServiceLogic.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = service.findEmployee(request.getParameter("empNo"));
		List<Department> deptList = service.findAllDepartment();
		
		request.setAttribute("employee", employee);
		request.setAttribute("deptList", deptList);
		
		request.getRequestDispatcher("/views/assignDept.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = service.findEmployee(request.getParameter("empNo"));
		
		employee.setDeptNo(request.getParameter("deptNo"));
		service.modify(employee);
		
		response.sendRedirect(request.getContextPath()+"/employee/list.do");
	}

}
