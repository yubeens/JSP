<%@page import="com.exem.ScoreBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
int kor = Integer.parseInt(request.getParameter("kor"));
int eng = Integer.parseInt(request.getParameter("eng"));
int math = Integer.parseInt(request.getParameter("math"));

ScoreBean sb= new ScoreBean();
sb.setName(name);
sb.setKor(kor);
sb.setEng(eng);
sb.setMath(math);

%>
<body>
이름:<%=name %><br>
국어:<%=kor %><br>
영어:<%=eng %><br>
수학:<%=math %><br>
총점:<%=sb.getTotal() %><br>
평균:<%=sb.getAvg() %><br>
학점:<%=sb.getGrade() %>
<hr>
이름:<%=sb.getName() %><br>
국어:<%=sb.getKor()%><br>
영어:<%=sb.getEng()%><br>
수학:<%=sb.getMath()%><br>
총점:<%=sb.getTotal() %><br>
평균:<%=sb.getAvg() %><br>
학점:<%=sb.getGrade() %>

</body>
</html>