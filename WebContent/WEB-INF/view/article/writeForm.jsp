<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<style>
	form{
		width:500px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
<script src="../js/common.js"></script>
<script>


$(function(){
	$("form[name='f1']").submit(function(){
		$(".error").css("display","none");
			
		if( checkInputEmpty( $(this).find("input[name]")  ) == false){
			return false;
		}
		
	});
})
</script>
</head>
<body>
	<form name="f1" action="write.do" method="post">
		<p>
			<label>제목</label>
			<input type="text" name="title">
			<span class="error">제목을 입력하세요.</span>
		</p>
		<p>
			<label>내용</label>
			<textarea rows="10" cols="50" name="content"></textarea>
		</p>
		<p>
			<input type="submit" value="새 글 등록">
		</p>
	</form>

</body>
</html>










