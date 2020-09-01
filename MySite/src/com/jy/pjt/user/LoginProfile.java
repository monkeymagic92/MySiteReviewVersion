package com.jy.pjt.user;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.pjt.MyUtils;
import com.jy.pjt.ViewResolver;
import com.jy.pjt.db.UserDAO;
import com.jy.pjt.vo.UserVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/profile")
public class LoginProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO loginUser = MyUtils.getLoginUser(request);
		if (loginUser == null) {
			response.sendRedirect("loginMain");
			return;			
		}
		UserVO param = new UserVO();
		param.setI_user(loginUser.getI_user());
		
		System.out.println("========테스트=========");
		System.out.println("번호 : " + loginUser.getPhone());
		System.out.println("아이유저 : " + loginUser.getI_user());
		System.out.println("이름 : " + loginUser.getNm());
		 
		request.setAttribute("data", UserDAO.detailUser(param));
		
		ViewResolver.forward("user/loginProfile", request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO loginUser = MyUtils.getLoginUser(request);
		
		String savaPath = getServletContext().getRealPath("img") + "/user/" + loginUser.getI_user();
		System.out.println("savePath : " + savaPath);
		
		File driectory = new File(savaPath);
		
		if (!driectory.exists()) {
			driectory.mkdirs();
		}
		
		int maxFileSize = 10_485_760;
		
		String fileNm = "";
		String savaFileNm = "";
		
		try {
			MultipartRequest mr = new MultipartRequest(request, savaPath
					, maxFileSize, "UTF-8", new DefaultFileRenamePolicy());
			
			System.out.println("mr : " + mr);
			
			Enumeration files = mr.getFileNames();
			
			while(files.hasMoreElements()) {
				String key = (String)files.nextElement();
				fileNm = mr.getFilesystemName(key);
				
				String fileExt = fileNm.substring(fileNm.lastIndexOf("."));
				savaFileNm = UUID.randomUUID() + fileExt;
				
				File oldFile = new File(savaPath + "/" + fileNm);
				File newFile = new File(savaPath + "/" + savaFileNm);
				
				oldFile.renameTo(newFile);
				
				System.out.println("key : " + key);
				System.out.println("fileNm : " + fileNm);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(savaFileNm != null ) {
			UserVO param = new UserVO();
			param.setProfile_img(savaFileNm);
			param.setI_user(loginUser.getI_user());
			
			UserDAO.updUser(param);
		}
		
		response.sendRedirect("/profile");
		
		
		
		
		
		
		
		
		//doGet(request, response);
	}

}
