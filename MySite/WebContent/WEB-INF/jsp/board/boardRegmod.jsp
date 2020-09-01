<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data != null ? '글등록' : '글수정'}</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Italianno&display=swap" rel="stylesheet">
<style>
	.container {width:500px; margin: 0 auto;}
	.font {font-size: 2.5em;  font-family: 'Italianno', cursive;}
	#btn1 {margin:0 auto; margin-left: 160px;}
	#btn2 {margin:0 auto; margin-left: 20px;}
	#title1 { margin-top: 20px;}
</style>
</head>
<body>
	<div class="container">
		<form id="frm" action="${data == null ? 'boardWrite': 'boardUpd'}" method="post">			
			<div id="title1" class="form-group">
		    	<span class="font">Enter Title</span>
		    	<label for="exampleFormControlTextarea1"></label>
		    	<textarea class="form-control" id="exampleFormControlTextarea1" rows="1" name="title">${data != null ? data.title:'' }</textarea>
	  		</div>
			<div class="form-group">
		    	<span class="font">write content</span>
		    	<label for="exampleFormControlTextarea1"></label>
		    	<textarea class="form-control" id="exampleFormControlTextarea1" rows="17" name="ctnt">${data != null ? data.ctnt:'' }</textarea>
	  		</div>
	  		
		    <input type="hidden" name="i_user" value="${loginUser.i_user }">
		    <input type="hidden" name="i_board" value="${data.i_board }">	
		    <input type="hidden" name="page" value="${nowPage}"> <%-- 페이지값 안되면 다시 name값 수정하기 --%>	    
		    <button id="btn1" type="submit" class="btn btn-outline-success">${data != null ? '수정' : '글쓰기' }</button>
		    <button id="btn2" type="button" onclick="moveToList()" class="btn btn-outline-success">취소</button>			
		</form>	
	</div>
	
	<script>
		function moveToList() {
			location.href="boardMain";
		}
	</script>	
	
</body>
</html>