<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORM EXAM</title>
</head>
<body>
<form action="formResult.jsp" method="post">
이름:<input type="text" name="name"><br>
나이:<input type="number" name="age"><br>
성별:
<label for="man">남자</label>
	<input type="radio" name="gender" id="man" value="남자" checked>
<label for="woman">여자</label>
	<input type="radio" name="gender" id="woman" value="여자"><br>
관심분야:
<label for ="h1">운동</label>
	<input type="checkbox" name="hobby" id="h1" value="운동">
<label for ="h2">게임</label>
	<input type="checkbox" name="hobby" id="h2" value="게임">
<label for ="h3">등산</label>
	<label><input type="checkbox" name="hobby" id="h3" value="등산">
<label for ="h4">영화</label>
<label><input type="checkbox" name="hobby" id="h4" value="영화"><br>
<label for ="job">직업:</label>
<select name = job id="job">
	<option value="사무직">사무직</option>
	<option value="전문직">전문직</option>
	<option value="서비스직">서비스직</option>
	<option value="예체능">예체능</option>
	<option value="기타">기타</option>
</select>
<button id="button" value="전송">전송</button>
</form>

</body>
</html>