package com.jy.pjt.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.pjt.Const;
import com.jy.pjt.MyUtils;
import com.jy.pjt.ViewResolver;
import com.jy.pjt.db.BoardDAO;
import com.jy.pjt.vo.BoardVO;
import com.jy.pjt.vo.UserVO;



@WebServlet("/boardMain")
public class BoardMain_Ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MyUtils.isLogout(request)) {
			request.setAttribute("msg", "로그인을 해주세요");
			ViewResolver.forward("board/boardMain", request, response);
			return;
		}
		
		
		UserVO loginUser = MyUtils.getLoginUser(request);
		loginUser = (UserVO) request.getAttribute(Const.LOGIN_USER);
		
		int page = MyUtils.getIntParameter(request, "page");		
				
		if(page == 0) {
			page = 1;
		}
		
		
				
		BoardVO param = new BoardVO();
				
		param.setRecord_cnt(Const.RECORD_CNT);
		request.setAttribute("paginCnt", BoardDAO.selPagingCnt(param));
		request.setAttribute("nowPage", page);
		request.setAttribute("loginUser", loginUser);
		param.setPage(page);
		
		request.setAttribute("list", BoardDAO.selBoardList(param));
		ViewResolver.forward("board/boardMain", request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
	}

}
