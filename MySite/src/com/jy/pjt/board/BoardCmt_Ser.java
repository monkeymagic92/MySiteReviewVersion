package com.jy.pjt.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.pjt.MyUtils;
import com.jy.pjt.db.BoardCmtDAO;
import com.jy.pjt.vo.BoardCmtVO;
import com.jy.pjt.vo.UserVO;

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@WebServlet("/boardCmt")
public class BoardCmt_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Integer.parseInt(request.getParameter("i_board"));
		int i_cmt = Integer.parseInt(request.getParameter("i_cmt"));
		String cmt = request.getParameter("cmt");
		
		UserVO loginUser = MyUtils.getLoginUser(request);
		
		BoardCmtVO param = new BoardCmtVO();
		param.setCmt(cmt);
		param.setI_cmt(i_cmt);
		param.setI_user(loginUser.getI_user());
		
		switch(i_cmt) {
		// i_cmt = 0   :   등록
		case 0:
			param.setI_board(i_board);
			BoardCmtDAO.insCmt(param);
			break;			
		// i_cmt = 0    :    수정
		default:
			BoardCmtDAO.updCmt(param);
			break;
		}		
		response.sendRedirect("/boardDetail?i_board="+i_board);
		
				
		//doGet(request, response);
	}

}
