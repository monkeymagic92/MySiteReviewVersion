<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Aclonica&display=swap" rel="stylesheet">
<style>
	.body { background-color: grey;}
	.container {width:600px; margin: 0 auto;}
	.itemRow { cursor: pointer;}
	#h2_1 {margin-top: 30px; margin-left: 170px; font-family: 'Aclonica', sans-serif;}
	.table { margin-top: 30px;}
	
</style>
</head>
<body>
<div class="container">
	<h2 id="h2_1"> Member List </h2>
	<hr>
	<table class="table table-hover table-dark">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">ID</th>
	      <th scope="col">Name</th>      
	      <th scope="col">성별</th>
	      <th scope="col">가입시간</th>
	    </tr>
	  </thead>
	  <tbody>
	   	<c:forEach items="${list}" var="item">
	    <tr class="itemRow" onclick="moveToDetail(${item.i_user})">
	      <td>${item.i_user }</td>
	      <td>${item.user_id }</td>
	      <td>${item.nm }</td>
	      <td>${item.gender }</td>
	      <td>${item.m_dt }</td>
	    </tr>
	    </c:forEach>    
	  </tbody>
	</table>
</div>

<script>
	function moveToDetail(i_user) {
		location.href="loginDetail?i_user="+i_user;
	}
</script>