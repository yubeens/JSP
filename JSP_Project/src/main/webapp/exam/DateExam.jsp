<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
Calendar ca = Calendar.getInstance();
String[] arr = {"일","월","화","수","목","금","토"};

String day="";
switch(ca.get(Calendar.DAY_OF_WEEK)){
	case 1:day="일";break;
	case 2:day="월";break;
	case 3:day="화";break;
	case 4:day="수";break;
	case 5:day="목";break;
	case 6:day="금";break;
	case 7:day="토";break;
}
%>
<body>
오늘은 <%=ca.get(Calendar.YEAR) %> 년
 	 <%=ca.get(Calendar.MONTH)+1 %>월
 	 <%=ca.get(Calendar.DATE) %>일
 	 <%=ca.get(Calendar.DAY_OF_WEEK) %> 요일
<hr>
배열을 이용하여 요일 구하기: <%=arr[4] %> 요일<br>
배열을 이용하여 요일 구하기: <%=arr[ca.get(Calendar.DAY_OF_WEEK)-1] %><br> <!-- 캘린더에 맞춰 요일변경 됨 -->
<hr>
switch 요일: <%=day %>
 	 
</body>
</html>