<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/css2?family=Krona+One&display=swap" rel="stylesheet">

<style>
	.container {width: 600px; margin: 0 auto;}
	
	#mainLoop {margin-top: 20px; width: 220px;}
	
	#loginUserNm {color: brown; font-size: 1.5em;}
	
	#title_th {width: 350px;}
	
	.itemRow:hover {background-color: grey; cursor: pointer; }
	
	#btn1 { margin-top: 60px; margin-bottom: 20px; }
	
	#UserProfile {font-family: 'Krona One', sans-serif; }
	
	#nowPage { color : red;}
		
	.table {width:700px; height: 100px; }
	
	#page_Button {width: 5px; color: red; text-align: center;}
	
	#page_Button2 {width:5px; text-align: center;}
	
	.page {margin-top: 20px; text-align: center;}
	
	#tr_1 {color: brown;}	
	
	.pImg {
		width: 30px;
		height: 30px;
		border-radius: 50%;
	}
	
	
	
</style>
</head>
<body>	
	<div class="container">
		<fieldset id="mainLoop">
			<div id="UserProfile"><span id="loginUserNm">${loginUser.nm }</span> 님 반갑습니다</div>		
			<div><a href="logout">로그아웃</a></div>
			<a href="profile?i_user=${loginUser.i_user }">프로필 보기</a>
		</fieldset>		
		<button id="btn1" type="submit" class="btn btn-outline-success" onclick="moveToRegmod()">글쓰기</button>
		<table class="table table-striped table-dark">
		  <thead>
		    <tr id="tr_1">
		      <th scope="col">#</th>
		      <th scope="col">Writer</th>
		      <th> </th>	      
		      <th id="title_th"scope="col">Title</th>
		      <th scope="col">Views</th>
		      <th scope="col">Date Created</th>
		      <th scope="col">Good</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${list }" var="item">
			    <tr class="itemRow" onclick="moveToDetail(${item.i_board})">
			      <th scope="row">${item.i_board }</th>
			      <th>${item.nm }</th>
			      <%-- 프로파일 이미지 나타내는 구간 --%>
			      <th>
			      	<div class="containerPImg">
			      		<c:choose>
			      			<c:when test="${item.profile_img != null }">
			      				<img class="pImg" src="/img/user/${item.i_user }/${item.profile_img}">
			      			</c:when>
			      			<c:otherwise>
			      				<img class="pImg" src="img/default_profile.jsp">
			      			</c:otherwise>
			      		</c:choose>
			      	</div>
			      </th>
			      <%--이미지 나타내게 하는 구간 --%>
			      <th>${item.title }</th>
			      <th>${item.hits} </th>
			      <th>${item.r_dt}</th>
			      <th>${item.i_like}</th>			    
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		
		<%-- 검색 관련 --%>
		<div class="searchBar">
			<form action="boardMain" >
				<input type="search" name="searchText" value="${param.searchText }">
				<input type="hidden" name="record_cnt" value="${param.record_cnt }">
				<input type="submit" value="검색">
			</form>
		</div>
		
		<%-- 밑에 페이지 쪽수 나타내는 부분 --%>
		<div class="page">
		<c:forEach begin="1" end="${paginCnt }" var="item">
			<c:choose>
				<c:when test="${item == nowPage }">
					<button id="page_Button" type="submit" class="btn btn-outline-success" name="record_cnt" onclick="moveToList(${item})">${item }</button>
				</c:when>
				<c:otherwise>
					<button id="page_Button2" type="submit" class="btn btn-outline-success" onclick="moveToList(${item})">${item }</button>
				</c:otherwise>	
				</c:choose>
		</c:forEach>
		</div>
	</div>   
	
	<script>
		function moveToRegmod() {
			location.href="boardWrite";
		}
	
		function moveToDetail(i_board) {
			location.href="boardDetail?i_board="+i_board+"&nowPage=${nowPage}";
		}
		
		function moveToList(i) {
			location.href="boardMain?page="+i;
		}
		
		if(${msg != null}) {
			alert('${msg}');
			location.href="loginMain";
		}
	</script>
</body>
</html>