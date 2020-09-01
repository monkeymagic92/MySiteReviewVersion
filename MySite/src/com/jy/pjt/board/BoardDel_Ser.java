package com.jy.pjt.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.pjt.ViewResolver;
import com.jy.pjt.db.BoardDAO;
import com.jy.pjt.vo.BoardVO;


@WebServlet("/boardDel")
public class BoardDel_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int i_board = Integer.parseInt(request.getParameter("i_board"));
		
		// BoardMain 에서 페이징 페이지 page 값을 받아와서 그대로 boardMain에 돌려줌
		// 고로, 내가 삭제해도 그 페이지 수에 머물게 해줌		
		int page = Integer.parseInt(request.getParameter("nowPage"));
		
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		BoardDAO.delBoard(param);		
		
		response.sendRedirect("boardMain?page="+page);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
	}

}
