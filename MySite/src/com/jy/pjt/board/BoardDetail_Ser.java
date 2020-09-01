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


@WebServlet("/boardDetail")
public class BoardDetail_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.isLogout(request)) {
			request.setAttribute("msg", "로그인 해주세요");
			ViewResolver.forward("board/boardDetail", request, response);
			return;
		}
		
		// 화면뿌리기 위해 boardMain.jsp 에서 받아온 값 
		
		String strI_board = request.getParameter("i_board");		
		int i_board = Integer.parseInt(strI_board);		
		// @@
		int page = Integer.parseInt(request.getParameter("nowPage"));
		
		// 디테일 화면 뿌리기
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		request.setAttribute("data", BoardDAO.detailBoard(param));
		
		// @@
		request.setAttribute("nowPage",page);		
		ViewResolver.forward("board/boardDetail", request, response);
		
		request.setAttribute("data", BoardDAO.selBoardList(param));
		request.setAttribute("cmtList", BoardCmtDAO.);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);	
	}

}
