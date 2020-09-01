<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Serif:ital,wght@1,200&display=swap" rel="stylesheet">
<style>
	.container {width: 500px; margin-top: 20px; margin: 0 auto;}
	#btn1 {width: 100px; margin-top: 20px; margin-left: 200px;}
	#frm {margin-top:30px;}
	h2 {color: grey; margin-top: 40px; margin-left: 140px;}
	#mainFont {font-family: 'IBM Plex Serif', serif;}
</style>
</head>
<body>
	<div class="container">
		<h2 id="mainFont">Find Password</h2>
		<form id="frm" action="loginFind" method="post" onsubmit="return chk()">
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="inputGroup-sizing-default">Enter_ID</span>
			  </div>
		        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"
		         name="user_id" placeholder="ID">		        
			</div>
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="inputGroup-sizing-default">Enter_Name</span>
			  </div>
		        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"
		        name="nm" placeholder="Name">		        
			</div>
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="inputGroup-sizing-default">Enter_PhoneNumber</span>
			  </div>
		        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"
		        name="phone" placeholder="onlyNumbers">		        
			</div>
				<button id="btn1" type="submit" class="btn btn-success">Send</button>
		</form>
	</div>
		
	<script>
	/*
		느낌이 하드코딩 같은 느낌  코드를 간소화 할수있음 간소화 해보자 (숙제)
	*/
		function chk() {
			if(frm.user_id.value.length == 0) {
				alert("아이디를 입력해주세요");
				frm.user_id.focus();
				return false;
				
			} else if (frm.nm.value.length == 0) {
				alert("비밀번호를 입력해주세요");
				frm.nm.focus();
				return false;
			} else if (frm.phone.value.length == 0) {
				alert("휴대폰 번호를 입력해 주세요");
				frm.phone.focus();
				return false;
			}
			
			if (frm.nm.value.length > 0) {
    			const korean = /[^가-힣]/;
    			    			
    			if(korean.test(frm.nm.value)) {
    				alert("이름은 한글로 입력해주세요");
    				frm.nm.focus();
    				return false;
    			}
			}
    		
    		if (frm.phone.value.length > 0) {
	  			const phone = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
		   		 
		   		if(!phone.test(frm.phone.value)) {            
		   		    alert("휴대폰번호를 제대로 입력해주세요");   
		   		    frm.phone.focus()
		   			return false;
		   		}
    		}    
		}

		if(${msg != null}) {
			alert("${msg}");
			
		}
			
	</script>
</body>
</html>