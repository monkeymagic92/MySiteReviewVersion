package com.jy.pjt.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.pjt.ViewResolver;
import com.jy.pjt.db.UserDAO;
import com.jy.pjt.vo.UserVO;


@WebServlet("/loginMembers")
public class LoginMembers_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<UserVO> list = new ArrayList();    	    	
    	list = UserDAO.selUser(); 
    	request.setAttribute("list", list);
    	    	
    	ViewResolver.forward("user/loginMembers", request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//doGet(request, response);
	}

	
	
	
	
	
	
	
	
	
	
}
