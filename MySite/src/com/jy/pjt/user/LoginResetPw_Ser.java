package com.jy.pjt.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jy.pjt.MyUtils;
import com.jy.pjt.ViewResolver;
import com.jy.pjt.db.UserDAO;
import com.jy.pjt.vo.UserVO;


@WebServlet("/loginResetPw")
public class LoginResetPw_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ViewResolver.forward("user/loginResetPw", request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO param = new UserVO();
		
		param.setUser_id((String)hs.getAttribute("user_id"));
		String user_pw = request.getParameter("user_pw");
		param.setUser_pw(MyUtils.encryptString(user_pw));		
		
		hs.invalidate();
		
		UserDAO.changePw(param);
		
		request.setAttribute("msg", "비밀번호 변경 완료");
		
		doGet(request, response);
	}

}
