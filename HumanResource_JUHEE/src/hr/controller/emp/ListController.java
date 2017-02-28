package hr.controller.emp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Department;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/employee/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HumanResourceService service = HumanResourceServiceLogic.getInstance();
		List<Department> deptList = service.findAllDepartmentEmployee();
		
		request.setAttribute("deptList", deptList);
		
		request.getRequestDispatcher("/views/employeeList.jsp").forward(request, response);
		
	}

}
