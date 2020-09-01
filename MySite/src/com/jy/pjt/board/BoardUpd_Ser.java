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


@WebServlet("/boardUpd")
public class BoardUpd_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO loginUser = MyUtils.getLoginUser(request);	
		if(loginUser == null) {
			request.setAttribute("errMsg", "로그인을 해주세요");
			ViewResolver.forward("error/errorPage", request, response);
			return;
		}
		
		System.out.println("boardUPD 서블릿");
		
		
		int i_board = Integer.parseInt(request.getParameter("i_board"));
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		int i_user = Integer.parseInt(request.getParameter("i_user"));
		
		BoardVO param = new BoardVO();		
		param.setI_board(i_board);
		
		
		request.setAttribute("data", BoardDAO.detailBoard(param));		
		request.setAttribute("nowPage", nowPage);
		
		// 보드 디테일 알려주는 메소드 작성하고 값  regmod.jsp로 넘기기
		ViewResolver.forward("board/boardRegmod", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int i_board = Integer.parseInt(request.getParameter("i_board"));
		int i_user = Integer.parseInt(request.getParameter("i_user"));
		int page = Integer.parseInt(request.getParameter("page"));
		String ctnt = request.getParameter("ctnt");
		String title = request.getParameter("title");
		
		
		
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		param.setI_user(i_user);
		param.setCtnt(ctnt);
		param.setTitle(title);		
		BoardDAO.updBoard(param);
		response.sendRedirect("boardMain?page="+page);
		
		
		
		
		//doGet(request, response);
	}

}
