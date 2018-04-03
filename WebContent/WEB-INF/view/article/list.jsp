<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container{
		width:700px;
		margin:0 auto;
	}
	#container p{
		text-align: right;
	}
	table{
		width:700px;
		border:1px solid black;
		border-collapse: collapse;
	}
	td, th{
		padding:5px;
		border:1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
	.title{
		width:300px;
		text-align: left;
	}
</style>
</head>
<body>
	<div id="container">
		<p>
			<a href="write.do">[글 쓰기]</a>
			<a href="${pageContext.request.contextPath}/index.jsp">[main]</a>
		</p>
		
		<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="item" items="${list }" >
			<tr>
				<td>${item.number }</td>
				<td class="title"><a href="read.do?no=${item.number}">${item.title }</a></td>
				<td>${item.name }</td>
				<td><fmt:formatDate value="${item.regDate }" pattern="yyyy.MM.dd h:mm" /></td>
				<td>${item.readCount }</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>





