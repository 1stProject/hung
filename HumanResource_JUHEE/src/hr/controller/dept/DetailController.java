package hr.controller.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Department;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/dept/detail.do")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HumanResourceService service;
	
	public DetailController(){
		service = HumanResourceServiceLogic.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Department dept = service.findDepartment(request.getParameter("deptNo"));
		
		request.setAttribute("department", dept);
		request.getRequestDispatcher("/views/deptDetail.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Department dept = service.findDepartment(request.getParameter("deptNo"));
		
		request.setAttribute("department", dept);
		request.getRequestDispatcher("/views/deptDetail.jsp").forward(request, response);
	}

}
