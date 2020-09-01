package com.jy.pjt.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.pjt.MyUtils;
import com.jy.pjt.ViewResolver;
import com.jy.pjt.db.UserDAO;
import com.jy.pjt.vo.UserVO;


@WebServlet("/loginInsert")
public class LoginInsert_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ViewResolver.forward("user/loginInsert", request, response);	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int result = 0;
		UserVO param = new UserVO();
		param.setUser_id(request.getParameter("user_id"));
		param.setUser_pw(MyUtils.encryptString(request.getParameter("user_pw"))); // 암호화해서 setUser_pw 에 저장  
		param.setNm(request.getParameter("nm"));
		param.setPhone(Integer.parseInt(request.getParameter("phone")));
		param.setEmail(request.getParameter("email"));
		param.setGender(request.getParameter("gender"));
		
		result = UserDAO.intUser(param);
		
		if(result == 0) {
			request.setAttribute("msg", "회원가입오류 / 관리자에게 문의하십시오");
			doGet(request, response);	
						
		} else {
			request.setAttribute("msg", "회원가입완료");
			doGet(request, response);
		}
	}
}