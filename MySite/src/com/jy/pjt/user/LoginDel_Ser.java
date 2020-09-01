package com.jy.pjt.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.pjt.ViewResolver;
import com.jy.pjt.db.UserDAO;
import com.jy.pjt.vo.UserVO;


@WebServlet("/loginDel")
public class LoginDel_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		UserVO param = new UserVO();
		param.setI_user(Integer.parseInt(request.getParameter("i_user")));
		result = UserDAO.delUser(param);
		
		if(result != 1) {
			request.setAttribute("msg", "데이터베이스 에러! 관리자에게 문의해주세요");
			ViewResolver.forward("user/loginDel", request, response);
		}
		
		response.sendRedirect("loginMembers");
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
	}

}
