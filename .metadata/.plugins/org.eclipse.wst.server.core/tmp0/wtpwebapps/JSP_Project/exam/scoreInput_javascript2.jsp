<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function check(){
		if(document.querySelector("#name").value==""){  //querySelector id 적용
			alert("이름을 입력하세요!!")
			return false;
		}
		if(document.getElementById("kor").value==""){ 
			alert("국어 점수를 입력하세요!!")
			return false;
		}
		if(document.getElementById("eng").value==""){
			alert("영어 점수를 입력하세요!!")
			return false;
		}
		if(document.getElementById("math").value==""){ 
			alert("수학 점수를 입력하세요!!")
			return false;
		}
		return true;
		
	}
</script>
</head>
<body>
<form action="scoreResult.jsp" id="frm" onsubmit="return check()"> <!--return값이 false면 action으로 넘어가지 않음.  -->
	이름:<input type="text" name="name" id="name"><br/>
	국어:<input type="number" name="kor" id="kor"><br/>
	영어:<input type="number" name="eng" id="eng"><br/>
	수학:<input type="number" name="math" id="math"><br/>
	<input type="submit" value="submit전송"/>
	
</form>
</body>
</html>