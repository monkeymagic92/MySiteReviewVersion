<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택장소</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style>
	.container {width:500px; margin: 0 auto; margin-top: 100px;}
	#btn1 {width: 150px; height: 100px; margin-right: 80px; }
	#btn2 {width: 150px; height: 100px; }
	.second {margin-bottom: 200px;}
	
</style>
</head>
<body>
	<nav class="nav-extended">
    <div class="nav-wrapper">
      <a href="#" class="brand-logo">JY company</a>
      <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="sass.html">미지정1</a></li>
        <li><a href="badges.html">미지정2</a></li>
        <li><a href="collapsible.html">미지정3</a></li>
      </ul>
    </div>
    <div class="nav-content">
      <ul class="tabs tabs-transparent">
        <li class="tab"><a href="#test1">미지정4</a></li>
        <li class="tab"><a class="active" href="#test2">미지정5</a></li>
        <li class="tab disabled"><a href="#test3">미지정6</a></li>
        <li class="tab"><a href="#test4">미지정7</a></li>
      </ul>
    </div>
    <ul class="sidenav" id="mobile-demo">
    <li><a href="#">Sass</a></li>
    <li><a href="#">Components</a></li>
    <li><a href="#">JavaScript</a></li>
  </ul>
  </nav>
	<div class="container">
		<div class="second">
			<button id="btn1" type="submit" class="btn btn-outline-success" onclick="moveToBoard(${loginUser.i_user})">게시판</button>
			<button id="btn2" type="submit" class="btn btn-outline-success" onclick="moveToMart(${loginUser.i_user})">물건구매</button>
		</div>					
	</div>	
	
	<script>
		function moveToBoard(i_user) {
			location.href="boardMain?i_user="+i_user;
		}
		
		function moveToMart(i_user) {
			location.href="martMain?i_user="+i_user;
		}
	
		if(${msg != null}) {
			alert('${msg}');
			location.href="loginMain";
		}
	</script>	
</body>
</html>