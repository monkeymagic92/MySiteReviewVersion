package com.jy.pjt.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jy.pjt.Const;
import com.jy.pjt.MyUtils;
import com.jy.pjt.ViewResolver;
import com.jy.pjt.db.UserDAO;

import com.jy.pjt.vo.UserVO;


@WebServlet("/loginMain")
public class LoginMain_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 테스트 용으로 loginMain.jsp value값으로 보냄 ( 다 하고난후에 삭제하기 ) 빨리 입력하려고 만든것임 삭제하면됨 
		request.setAttribute("test123", "test123");
		request.setAttribute("pstest123", "test123");
		ViewResolver.forward("user/loginMain", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO param = new UserVO();
		param.setUser_id(request.getParameter("user_id"));
		param.setUser_pw(MyUtils.encryptString(request.getParameter("user_pw")));
		
		int result = UserDAO.loginUser(param);		
		System.out.println("로그인 시 result 값 : " + result);
				
		String msg1 = "";
		String msg2 = "";
		String msg3 = "";				
		if(result != 1) {
			switch(result) {
			case 2:
				msg1 = "비밀번호를 다시 확인하세요";
				break;
			case 3:
				msg2 = "아이디를 다시 확인하세요";
				break;
			default:
				msg3 ="서버에러가 발생하였습니다";
			}
			request.setAttribute("loginMsg1", msg1);
			request.setAttribute("loginMsg2", msg2);
			request.setAttribute("loginMsg3", msg3);
			request.setAttribute("user_id", param.getUser_id());
			doGet(request, response);
			return;
		}
		
		
		
		// 세션은 한번 이렇게 setAttribute로 키값을 지정해주면
		// 언제어디서든지 이 키값을 굳이 request.getSession() 안해줘도 사용할수 있음
		HttpSession hs = request.getSession();
		hs.setAttribute(Const.LOGIN_USER, param);
		
		
		ViewResolver.forward("center/centerMain", request, response);		
		
		
		//doGet(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
