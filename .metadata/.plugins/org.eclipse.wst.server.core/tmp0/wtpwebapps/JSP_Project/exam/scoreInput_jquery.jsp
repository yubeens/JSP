<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#btn").click(function(){
		if($("#name").val()==""){
			alert("이름을 입력하세요!!")
			return;
		}
		if($("#kor").val()==""){
			alert("국어점수를 입력하세요!!")
			return;
		}
		if($("#eng").val()==""){
			alert("영어점수를 입력하세요!!")
			return;
		}
		if($("#math").val()==""){
			alert("수학점수를 입력하세요!!")
			return;
		}
		$("#frm").submit()
		
	});
	
})
</script>
</head>
<body>
<form action="scoreResult2.jsp" id="frm">
이름:<input type="text" name="name" id="name"><br/>
국어:<input type="text" name="kor" id="kor"><br/>
영어:<input type="text" name="eng" id="eng"><br/>
수학:<input type="text" name="math" id="math"><br/>
<button type="button" id="btn">jquery전송</button>
</form>
</body>
</html>