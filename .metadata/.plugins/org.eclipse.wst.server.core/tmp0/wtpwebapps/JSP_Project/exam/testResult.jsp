<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
//스크립트릿
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String addr = request.getParameter("addr");

%>
<body>
이름: <% out.println(name); %> <br/>
주소: <% out.println(addr); %> <br/>
<hr/>
<!-- 표현식 -->
이름: <%=name%><br/>
주소: <%=addr%>


</body>
</html>