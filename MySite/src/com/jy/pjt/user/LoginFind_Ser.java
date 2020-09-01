package com.jy.pjt.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jy.pjt.ViewResolver;
import com.jy.pjt.db.UserDAO;
import com.jy.pjt.vo.UserVO;



@WebServlet("/loginFind")
public class LoginFind_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	ViewResolver.forward("user/loginFind", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserVO param = new UserVO();
		param.setUser_id(request.getParameter("user_id"));
		param.setNm(request.getParameter("nm"));
		param.setPhone(Integer.parseInt(request.getParameter("phone")));
		
		String firstChk = "ok";
		String secondChk = "";
		secondChk = UserDAO.chkUser(param);
		
		if(firstChk.equals(secondChk)) {
			HttpSession hs = request.getSession();
			hs.setAttribute("user_id", param.getUser_id());
			response.sendRedirect("loginResetPw");
			
		} else {
			request.setAttribute("msg", "회원정보를 다시 확인해 주세요");
			doGet(request, response);
		}
	}
}
