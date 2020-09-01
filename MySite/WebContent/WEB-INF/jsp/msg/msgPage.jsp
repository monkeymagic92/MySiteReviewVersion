<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		// 로그아웃시 넘어오는 메세지 창	
		// boardMain.jsp 에서 간단하게 처리할수 있었지만 일부로 이렇게 한번 꼬여서 해봤음
		// 값이 넘어가는걸 이해해보기위해
		// boardMain 서블릿과 loginOut 서블릿 같이 msgPage.jsp 번갈아 보기 
		if (${logout_msg != null }) {
			if (confirm("로그아웃 하시겠습니까?")) {				
				location.href="loginMain?logout=1";	
			} else {
				location.href="boardMain";
			}			
		}		
	</script>
</body>
</html>