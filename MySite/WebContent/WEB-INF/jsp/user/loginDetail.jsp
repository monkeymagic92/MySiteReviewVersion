<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<head>
<style>
	.container { width:400px; margin: 0 auto;}
	#btn1 { margin-top: 20px;}
</style>
</head>
<body>
	<div class="container">
		${data.i_user } 번 고객님
		<fieldset>
			<ul>
				<li>ID : ${data.user_id }</li>
				<li>Name : ${data.nm }</li>
				<li>Tel : ${data.phone }</li>
				<li>Email : ${data.email }</li>
				<li>Gender : ${data.gender }</li>
			</ul>
		</fieldset>
		<button id="btn1" onclick="moveToDel(${data.i_user})">삭제</button> <!--  삭제기능 추가하기  -->
	</div>	
	
	<script>
		function moveToDel(i_user) {
			if(confirm('삭제하시겠습니까?')) {
				location.href="loginDel?i_user="+i_user;	
			}
		}
	</script>
</body>
</html>