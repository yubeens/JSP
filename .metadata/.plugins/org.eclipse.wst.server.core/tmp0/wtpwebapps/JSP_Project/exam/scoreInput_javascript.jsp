<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function check(){
		/*if(document.frm.name.value==""){ //값 없이 버튼을 누르면 alert 출력
			alert("이름을 입력하세요")		
		}*/
		
		if(document.getElementById("name").value==""){ //id지정 후 설정(이름)
			alert("이름을 입력하세요!!")
			return;
		}
		if(document.getElementById("kor").value==""){ //id지정 후 설정(국어)
			alert("국어 점수를 입력하세요!!")
			return;
		}
		if(document.getElementById("eng").value==""){ //id지정 후 설정(국어)
			alert("영어 점수를 입력하세요!!")
			return;
		}
		if(document.getElementById("math").value==""){ //id지정 후 설정(국어)
			alert("수학 점수를 입력하세요!!")
			return;
		}
		document.getElementById("frm").submit();
		
	}
</script>
</head>
<body>
<form action="scoreResult.jsp" id="frm">
	이름:<input type="text" name="name" id="name"><br/>
	국어:<input type="text" name="kor" id="kor"><br/>
	영어:<input type="text" name="eng" id="eng"><br/>
	수학:<input type="text" name="math" id="math"><br/>
	<input type="button" value="button전송" onclick="check()"/>
</form>
</body>
</html>