package hr.controller.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hr.domain.Department;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/dept/create.do")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		if(!("admin".equals(loginId))){
			throw new RuntimeException("부서 등록 권한이 없습니다.");
		}
		
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		
		Department dept = new Department(deptNo, deptName);
		HumanResourceService service =HumanResourceServiceLogic.getInstance();
		
		service.registeDepartment(dept);
		
		response.sendRedirect(request.getContextPath()+"/dept/list.do");
	}

}
