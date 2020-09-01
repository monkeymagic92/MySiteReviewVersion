package com.jy.pjt.martMain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.pjt.MyUtils;
import com.jy.pjt.ViewResolver;


@WebServlet("/martMain")
public class MartMain_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.isLogout(request)) {
			request.setAttribute("msg", "로그인을 해주세요");
			ViewResolver.forward("mart/martMain", request, response);
	
		} else {
			ViewResolver.forward("mart/martMain", request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//doGet(request, response);
	}

}
