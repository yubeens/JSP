<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>테스트:서버</h3>
<form action="testResult.jsp" method="post">
<!--get:주소창에 정보를 담아 전송, post:주소창에 출력되지않고 head에 정보를 담아 전송-->
이름:<input type="text" name="name"><br/>
주소:<input type="text" name="addr"><br/>
<input type="button" value="button전송"/>  <%--단순 버튼 모양--%>
<input type="submit" value="submit전송"/> <%--폼태그에 전달--%> 
</form>
</body>
</html>