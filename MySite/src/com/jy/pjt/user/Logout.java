package com.jy.pjt.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jy.pjt.ViewResolver;


@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setAttribute("logout_msg", "logout");    	
    	ViewResolver.forward("msg/msgPage", request, response);
    	
    	
    	System.out.println("로그아웃 부분(Browser 정상출력됨 밑에 null에러 무시");
    	
    	
    	// msgPage.jsp 에서 로그아웃 할시 값이 1이 넘어오고 1이 맞으면 로그아웃 	
    	int logout = Integer.parseInt(request.getParameter("logout"));
    	if(logout == 1) {
    		HttpSession session = request.getSession();
        	session.invalidate();
        	response.sendRedirect("loginMain");
    	}
    	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//doGet(request, response);
	}

}
