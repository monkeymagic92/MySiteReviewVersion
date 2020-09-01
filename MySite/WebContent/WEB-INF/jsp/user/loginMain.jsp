<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Serif:ital,wght@1,200&display=swap" rel="stylesheet">
<style>
	.container {width:440px; margin: 0 auto; margin-top: 200px;}
	#errorMsg {color: red; margin-bottom: 40px; text-align: center;}
	#login {text-align: center; color: grey; font-family: 'IBM Plex Serif', serif;
			margin-bottom: 30px;}
	#btn1 { width: 110px; margin-left: 150px; }
	#btn2 { width: 120px; margin-left: 5px; background-color: grey;}
	#btn3 { width: 120px; margin-left: 10px; background-color: grey;}
	#btn4 { width: 120px; margin-left: 10px; background-color: grey;}
</style>
</head>
<body>	
	<div class="container">		
		<%-- 서버에러 발생했을시 --%>
		<div id="errorMsg">${loginMsg2}</div>
        <h2 id="login">Login Page</h2>
		<fieldset>
            <form action="loginMain" method="post">
                <div class="input-field col s6">                																	<%-- 아디/비번 value값 지우기 (로그인 빨리하려고 일부로 해놓은것) --%>
                   <input id="icon_prefix" type="text" class="validate" name="user_id" value="${test123}" placeholder="ID" autofocus>
                   <label class="active" for="icon_prefix">ID</label>
                </div>                
                <%-- 아이디 틀렸을시 --%>
      			<div id="errorMsg">${loginMsg2}</div>      			    
                <div class="input-field col s6">  
                   <input id="icon_prefix" type="password" class="validate" name="user_pw" value="${pstest123 }" placeholder="Password">
                   <label class="active" for="icon_prefix">Password</label>
                   <input type="hidden" name="i_user" value="">
                </div>
                <%-- 비번 틀렸을시 --%>
                <div id="errorMsg">${loginMsg1}</div>                
                <div>
                    <button id="btn1" type="submit" class="btn btn-outline-success">Login</button>
                </div>
            </form>
        </fieldset>
        <br><br><br><br>        
	    <button id="btn2" type="button" class="btn btn-secondary" onclick="moveToInsert()" >회원가입</button>    
	    <button id="btn3" type="button" class="btn btn-secondary" onclick="moveToFind()">비밀번호찾기</button>   
	    <button id="btn4" type="button" class="btn btn-secondary" onclick="moveToMembers()">회원리스트</button>        
    </div>
    
    <script>    	
        if(${msg != null}) {
			alert('${msg}');
			location.href="loginInsert";			
		}         
    
        function moveToInsert() {
            location.href="loginInsert"
        }       
        function moveToFind() {
            location.href="loginFind"
        }        
        function moveToMembers() {
            location.href="loginMembers"
        }        
    </script>
</body>
</html>