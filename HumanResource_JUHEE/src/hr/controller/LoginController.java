package hr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginId = request.getParameter("loginId");
		String passwd = request.getParameter("passwd");
		
		if("1234".equals(passwd)){
			//로그인에 성공하면 세션에 로그인 아이디 저장.
			HttpSession session = request.getSession();
			session.setAttribute("loginId", loginId);
			
			//메뉴 페이지로 이동
			response.sendRedirect(request.getContextPath()+"/views/menu.jsp");
		}else {
//			로그인에 실패하면 로그인 페이지로 이동.
			response.sendRedirect(request.getContextPath()+"/views/login.jsp");
//			redirect에서는 views/login.jsp 로 적어도 contextpath가 붙는다.
//			앞에 /를 붙이면 contextpath가 사라짐.
//			차후의 이벤트에 대비하여 contextpath를 적어주는 방향으로 사용한다.
			
		}
	}

}
