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


@WebServlet("/loginDetail")
public class LoginDetail_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	UserVO param = new UserVO();
    	param.setI_user(Integer.parseInt(request.getParameter("i_user")));
    	
    	UserDAO.detailUser(param);
    	
    	request.setAttribute("data", param);
    	ViewResolver.forward("user/loginDetail", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//doGet(request, response);
	}

}
