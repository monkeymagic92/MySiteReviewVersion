<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/css2?family=Finger+Paint&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Serif:ital,wght@1,200&display=swap" rel="stylesheet">
<style>
	.container {width: 500px; height: 800px; margin: 0 auto; margin-top:50px;}
    #SignUp {text-align: center; color: black; margin-bottom: 50px; font-family: 'IBM Plex Serif', serif; }
    #btn1 { width: 110px; margin-left: 180px; margin-top: 30px;}
    .validate { color: grey;}
    
</style>
<body>
	<div class="container">
        <h2 id="SignUp">Sign Up Page</h2>
          <form id="frm" action="loginInsert" method="post" onsubmit="return chk()">
              <div id="abc" class="input-field col s6">
                 <input id="icon_prefix" type="text" class="validate" name="user_id" placeholder="ID" autofocus >
                 <label class="active" for="icon_prefix">ID</label>
              </div>
              <div class="input-field col s6">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
                 <input id="icon_prefix" type="password" class="validate" name="user_pw" placeholder="Password">
                 <label class="active" for="icon_prefix">Password</label>
              </div>
              <div class="input-field col s6">
                  <input id="icon_prefix" type="password" class="validate" name="user_rpw" placeholder="Password2">
                  <label class="active" for="icon_prefix">Password2</label>
               </div>
               <div class="input-field col s6">  
                  <input id="icon_prefix" type="text" class="validate" name="nm" placeholder="Name">
                  <label class="active" for="icon_prefix">name</label>
               </div>
               <div class="input-field col s6">
                  <input id="icon_prefix" type="text" class="validate" name="phone" placeholder="Only number">
                  <label class="active" for="icon_prefix">PhoneNumber</label>
               </div>               
               <div class="input-field col s6">
                  <input id="icon_prefix" type="email" class="validate" name="email" placeholder="Email">
                  <label class="active" for="icon_prefix">email</label>
               </div>	                                
		       <label>
		          <input type="radio" name="gender" value="남자" checked />
		          <span>Gentleman</span>
		       </label>
		       <label>
		          <input type="radio" name="gender" value="여자" />
		          <span>Lady</span>
		       </label>	          
               <div>
                  <button id="btn1" type="submit" class="btn btn-outline-success">Sign Up</button>
               </div>
          </form>
    </div>
    
    <script>
    	/*  아이디 영어정규화검사 추가하기
    	   	이메일 빈값 체크하기
    	   	휴대폰번호 빈값 체크하기
			모든구문 else if 로 다묶기( 0 || 0보다 클경우) 로 해서    	   	
    	*/
    	    	
    	function chk() {
    		if (frm.user_id.value.length < 3) {
    			alert("ID를 3글자 이상 입력해주세요");
    			frm.user_id.focus();
    			return false;
    			
    		} else if (frm.user_pw.value.length < 3) {
    			alert("비밀번호를 3글자 이상 입력해주세요");
    			frm.user_pw.focus();
    			return false;
    			
    		} else if (frm.user_pw.value != frm.user_rpw.value) {
    			alert("두 비밀번호를 다시 확인해주세요");
    			frm.user_pw.focus();
    			return false;
    			
    		// 이름 정규화 검사 
    		} else if (frm.nm.value.length > 0 || frm.nm.value.length == 0) {
    			const korean = /[^가-힣]/;
    			
    			if(korean.test(frm.nm.value)) {
    				alert("이름은 한글로 입력해주세요");
    				frm.nm.focus();
    				return false;
    			}
    		} 
    		
    		// 휴대폰 정규화 검사 (ex 010-333-4444 / 010-5555-6666) 중간 숫자 3자리 or 중간 숫자 4자리
    		if(frm.phone.value.length > 0 ) {
    			const phone = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
	    		 
	    		if(!phone.test(frm.phone.value)) {            
	    		    alert("휴대폰잘못입력");   
	    		    frm.phone.focus()
	    			return false;
	    		}
    		}    			
    		
    		// 이메일 정규화 검사
    		if (frm.email.value.length > 0 || frm.email.value.length == 0) {
    			const email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
    			
    			if(!email.test(frm.email.value)) {
    				alert("이메일을 정확히 입력해주세요");
    				frm.email.focus();
    				return false;
    			}
    		}    		
    	}
			
		// loginInsert 서블릿에서 회원가입했을시 오류 / 정상 을 판별하고 알림창 띄워주는 부분 
		if(${msg != null}) {
			alert('${msg}');
			location.href="loginMain";
		}
		
    </script>

</body>
</html>