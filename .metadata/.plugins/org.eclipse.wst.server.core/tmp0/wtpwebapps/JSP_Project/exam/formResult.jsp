<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORM RESULT</title>
</head>
<%
String name = request.getParameter("name");
String age = request.getParameter("age");
String gender = request.getParameter("gender");
String[] hobby = request.getParameterValues("hobby");

String tmp="";
//if(hobby!=null){
for(int i=0; i<hobby.length; i++){
	tmp += hobby[i]+" ";
	}
//}

String job = request.getParameter("job");
%>
<body>
이름:<%= request.getParameter("name") %> <br>
직업:<%= request.getParameter("job") %><br>
<hr>
이름:<%=name %><br>
나이:<%=age %><br>
성별:<%=gender %><br>
관심분야:<%=tmp %><br>
직업:<%=job %><br>
</body>
</html>