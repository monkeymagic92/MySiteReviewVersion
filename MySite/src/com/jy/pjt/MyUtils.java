package com.jy.pjt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jy.pjt.vo.UserVO;

public class MyUtils {
	
	public static int getIntParameter(HttpServletRequest request, String keyNm) {
		return parseStrToInt(request.getParameter(keyNm));
	}
	
	public static int parseStrToInt(String str) {
		return parseStrToInt(str, 0);
	}
	
	public static int parseStrToInt(String str, int defNo) {
		try {
			return Integer.parseInt(str);
		} catch(Exception e) {
			return defNo;
		}
	}
	
	
	// true : 로그인 안되어있다   //  false : 로그인 되어있다
	// 해석하면 로그인유저가 == null이면 당연히 로그인이 안되어있으므로 return true를 하여 if안에 내용을 작동 하는것
	// 코드 그대로 getLoginUser() 와 isLogout() 을 같이 합쳐서 보면 됨 
	public static boolean isLogout(HttpServletRequest request) throws ServletException {
		if(getLoginUser(request) == null) {
			return true;
		} 
		return false;
	}
	
	
	// 세션을 부여하고 키값을 Const.LOGIN_USER ("loginUser") 값을 담은 기능
	// UserVO 로 형변환하여 키값을 반환 함 
	// isLogout 메소드를 사용하기 위해 만들어준 메소드 
	public static UserVO getLoginUser(HttpServletRequest request) throws ServletException {
		HttpSession hs = request.getSession();			
		return (UserVO)hs.getAttribute(Const.LOGIN_USER);
	}
	
		
	// 비밀번호 암호화 하는 메소드
	// 사용법 : 매개변수 str 부분에 '변수' 를 넣으면 알아서 알수없는 특수문자로 변환해줌  
	public static String encryptString(String str) {
		String sha = "";

	       try{
	          MessageDigest sh = MessageDigest.getInstance("SHA-256");
	          sh.update(str.getBytes());
	          byte byteData[] = sh.digest();
	          
	          
	          StringBuffer sb = new StringBuffer();
	          for(int i = 0 ; i < byteData.length ; i++){
	              sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
	          }

	          sha = sb.toString();

	      }catch(NoSuchAlgorithmException e){
	          //e.printStackTrace();
	          System.out.println("Encrypt Error - NoSuchAlgorithmException");
	          sha = null;
	      }

	      return sha;
	}
}
