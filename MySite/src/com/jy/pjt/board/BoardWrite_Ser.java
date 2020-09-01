package com.jy.pjt.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.pjt.MyUtils;
import com.jy.pjt.ViewResolver;
import com.jy.pjt.db.BoardDAO;
import com.jy.pjt.vo.BoardVO;
import com.jy.pjt.vo.UserVO;


@WebServlet("/boardWrite")
public class BoardWrite_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO loginUser = MyUtils.getLoginUser(request);	
		if(loginUser == null) {
			request.setAttribute("errMsg", "로그인을 해주세요");
			ViewResolver.forward("error/errorPage", request, response);
			return;
		}
		
		System.out.println("boardWrite 서블릿");
		
		ViewResolver.forward("board/boardRegmod", request, response);			
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		BoardVO param = new BoardVO();
		param.setI_user(Integer.parseInt(request.getParameter("i_user")));
		param.setTitle(request.getParameter("title"));
		param.setCtnt(request.getParameter("ctnt"));				
		BoardDAO.insBoard(param);		
		response.sendRedirect("boardMain");
		
		
		
		// doGet(request, response);
	}

}
