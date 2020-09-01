package com.jy.pjt.center;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.pjt.Const; // 주석 해제하면 임포트 사용
import com.jy.pjt.MyUtils;
import com.jy.pjt.ViewResolver;
import com.jy.pjt.vo.UserVO; // 주석 해제하면 임포트 사용


@WebServlet("/center")
public class Center_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 유무 판단 (로그인 안됬을시 login 창으로 돌림) 
		// MyUtils 클래스에 getLoginUser(), isLogout() 메소드 참고 
		if(MyUtils.isLogout(request)) {
			request.setAttribute("msg", "로그인을 해주세요");
			ViewResolver.forward("center/centerMain", request, response);
			return;
		}		
		ViewResolver.forward("center/centerMain", request, response);
				
				
		
		
		
		
		 	//남겨두기 (굳이 메소드를 안쓰고 할경우 이렇게 로그인 유무를 확인할수 있다) 
			
//			UserVO param = (UserVO)request.getAttribute(Const.LOGIN_USER);		 
//			if(param == null) {
//				request.setAttribute("msg", "로그인을 하여주세요");
//				ViewResolver.forward("center/centerMain", request, response);
//				return;
//			} 		
//			ViewResolver.forward("center/centerMain", request, response);			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
	}

}
