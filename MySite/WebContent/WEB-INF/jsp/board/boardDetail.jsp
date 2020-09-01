<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<style>
	.container { width: 500px; margin:0 auto;}
	#boardNum { margin:0 auto; margin-top:20px; margin-left: 200px; margin-bottom: 20px;}	
	.form-group {width: 500px; height: 300px;}
	.form-control {text-align: center;}
	table {
        border: 1px solid black;
        border-collapse: collapse;
    }
    th,td {
        border: 1px solid black; 
        padding: 8px;
    }
    .ctnt {
        border-right: 1px solid #58585a;
        border-left: 1px solid #58585a;
        border-bottom: 1px solid #58585a;
        height: 200px;
        width:500px;
        padding: 10px;
    }
    .mainTable {width: 500px;}
	
	.btnSet{ margin-top: 20px; margin-left: 170px;}    
</style>
</head>
<body>
	<div class="container">
	<div id="boardNum">${data.i_board }번 상세 페이지</div>		
		 <table class="mainTable">
            <tr id="title">
                <th>제목</th>
                <th colspan="6">${data.title}</th>
            </tr>
            <tr class="boardInfo">
                <th id="nm">작성자</th>
                <td id="nm-1">${data.nm }</td>
                <th id="date">작성일시</th>
                <td id="date-1"> ${data.r_dt } <small>${data == null ? '' : '수정' }</small> </td>
                <th id="hits">조회수</th>
                <td id="hits-1">${data.hits }</td>
            </tr>
        </table>    	
        <div class="ctnt">
            ${data.ctnt } 
        </div>       
        
       	<%-- 댓글관련 @@@@@@@@@@@@@@@@@@@@@@@@ --%>
        <div class="marginTop30">
        	<form id="cmtFrm" action="boardCmt" method="post">
        		<input type="hidden" name="i_cmt" value="0">
        		<input type="hidden" name="i_board" value="${data.i_board }">
        		<div>
        			<input type="text" id="cmt" name="cmt" placeholder="Enter comment">
        			<input type="submit" id="cmtSubmit" value="Send">
        			<input type="button" value="cancel" onclick="clkCmtCancel()">
        		</div> 
        	</form>
        </div>
        <div class="marginTop30">
        	<table>
        		<tr>
        			<th>내용</th>
        			<th>글쓴이</th>
        			<th> </th>
        			<th>등록일</th>
        			<th>비고</th>
        		</tr>
        		<tr>
        			<c:forEach items="${cmtList }">
        			</c:forEach>
        		</tr>
        	</table>
        </div>
        
        
        
        <div class="btnSet"> 
        	<button id="page_Button2" type="submit" class="btn btn-outline-success" onclick="moveToDel(${data.i_board})">삭제</button>
        	<button id="page_Button3" type="submit" class="btn btn-outline-success" onclick="moveToUpd(${data.i_board})">수정</button>
        	<button id="page_Button4" type="submit" class="btn btn-outline-success" onclick="moveToList(${nowPage})">목록</button>        	
        </div>
  	</div>
  	
	<script>
		function moveToDel(i_board) {
			if(confirm("삭제하시겠습니까 ?")) {
				location.href="boardDel?i_board="+i_board+"&nowPage=${nowPage}";	
			} 	
		}
		
		function moveToList(nowPage) {
			location.href="boardMain?page="+nowPage;
		}
		
		function moveToUpd(i_board) {
			location.href="boardUpd?i_board="+i_board+"&nowPage=${nowPage}"+"&i_user=${loginUser.i_user}";
		}
		
		// 댓글 관련 메소드
		function clkCmtCancel() {
			cmtFrm.i_cmt.value = 0;
			cmtFrm.cmt.value = '';
			cmtSubmit.value = 'Send';
		}
	
		if(${msg != null}) {
			alert('${msg}');
			location.href="loginMain?page=${page}";
		}
	</script>
</body>
</html>