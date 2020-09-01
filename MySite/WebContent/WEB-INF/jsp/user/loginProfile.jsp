<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<c:choose>
				<c:when test="${data.profile_img != null }">
					<img src="/img/user/${loginUser.i_user }/${data.profile_img}">
				</c:when>
				<c:otherwise>
					<img src="/img/default_profile.jpg">
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<div>
		<form action="/profile" method="post" enctype="multipart/form-data">
			<div>
				<label>프로필 이미지 : <input type="file" name="profile_img" accept="image/*"></label>
				<input type="submit" value="업로드">
			</div>
		</form>
	</div>
	<h2> 값 정상적으로 뜸 프로필 이미지 값 추가하는거랑 그런거 다 추가하기 </h2>
	${loginUser.i_user }
	${loginUser.nm }
	${loginUser.user_id }
</body>
</html>