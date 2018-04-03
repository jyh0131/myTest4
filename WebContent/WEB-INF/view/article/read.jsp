<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		width:500px;
		border:1px solid black;
		border-collapse: collapse;
	}
	td{
		border:1px solid black;
		border-collapse: collapse;
		padding:5px;
	}
	
</style>
</head>
<body>
	<table>
		<tr>
			<td>번호</td>
			<td>${article.number }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${article.name }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${article.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${content.content }</td>
		</tr>
	</table>












</body>
</html>