<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<style>
	.container {width: 500px; margin-top: 20px; margin: 0 auto;}
	#btn1 {width: 100px; margin-top: 20px; margin-left: 200px;}
	#frm {margin-top:30px;}
	h2 {color: grey; margin-top: 40px; margin-left: 140px;}
</style>
</head>
<body>
	<div class="container">
		<h2>Change Password</h2>
		<form id="frm" action="loginResetPw" method="post" onsubmit="return chk()">
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="inputGroup-sizing-default">Enter_PW</span>
			  </div>
		        <input type="password" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"
		         name="user_pw" placeholder="Password">		        
			</div>
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="inputGroup-sizing-default">Enter_RPW</span>
			  </div>
		        <input type="password" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"
		        name="user_rpw" placeholder="RePassword">		        
			</div>			
				<button id="btn1" type="submit" class="btn btn-success">Send</button>
		</form>
	</div>
	
	<script>	
		function chk() {
			if (frm.user_pw.value.length == 0) {
				alert("비밀번호를 입력해주세요");
				frm.user_pw.focus();
				return false;
			} else if (frm.user_rpw.value != frm.user_pw.value) {
				alert("두 비밀번호를 확인해 주세요");
				frm.user_rpw.focus();
				return false;
			}
		}
		
		if(${msg != null}) {
			alert('${msg}');
			location.href="loginMain";
		}
	</script>
</body>
</html>