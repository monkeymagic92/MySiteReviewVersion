package com.jy.pjt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	public static void forward(String FielNm, HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		String jsp = String.format("WEB-INF/jsp/%s.jsp", FielNm);
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
		
}
