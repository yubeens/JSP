<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:${form.name} ////<c:out value="${form.name}"/><br/>
나이:${form.age}<br/>
성별:${form.gender}<br/>
직업:${form.job}<br/>
취미:${form.hobby}
<hr/>
<c:forEach items="${form.hobby}" var="h">
${h }
</c:forEach>


</body>
</html>