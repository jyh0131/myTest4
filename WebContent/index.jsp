<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${auth != null }">
		${auth.id}[${auth.name}]님. 반갑습니다.<br>
		<a href="logout.do">[로그아웃]</a>
		<a href="#">[비밀번호 변경]</a>
		<br>
		<a href="article/write.do">[게시글 글쓰기]</a>
		<a href="article/list.do">[게시글 목록 보기]</a>
	</c:if>
	<c:if test="${auth == null}">
		<a href="join.do">[회원가입하기]</a>
		<a href="login.do">[로그인하기]</a>
	</c:if>
	<a href="#">[회원리스트보기]</a>

</body>
</html>





