<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
<script src="js/common.js"></script>
<script>
$(function(){
	$("form[name='f1']").submit(function(){
		$(".error, .error3").css("display","none");
			
		if( checkInputEmpty( $(this).find("input[name]")  ) == false){
			return false;
		}	
	});
})
</script>
</head>
<body>
	<form name="f1" action="login.do" method="post">
		<p>
			<label>아이디</label>
			<input type="text" name="id">	
			<span class="error">아이디를 입력하세요</span>		
		</p>
		<p>
			<label>비밀번호</label>
			<input type="password" name="password">	
			<span class="error">비밀번호를 입력하세요</span>			
		</p>
		<p>
			<input type="submit" value="로그인">		
		</p>		
	</form>
	
	<script>
	<c:if test="${notJoin != null }">
		alert("${notJoin }");		
	</c:if>
	
	<c:if test="${passNotMatch != null }">
		alert("${passNotMatch }");
	</c:if>
	</script>
</body>
</html>








