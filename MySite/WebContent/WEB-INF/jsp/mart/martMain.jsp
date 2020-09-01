<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	마트메인페이지
	
	<script>
		if(${msg != null}) {
			alert('${msg }');
			location.href="loginMain";
		} 
	</script>
</body>
</html>