<%@page import="com.address.Address"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.address.AddressDAO"%>
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
String field="";
String word="";
if(request.getParameter("word")!=null){
	field=request.getParameter("field");
	word=request.getParameter("word");
}
AddressDAO dao = new AddressDAO();
//검색
ArrayList<Address>alist=dao.list(field,word);
int count=dao.getCount(field,word);
/* ArrayList<Address>alist= dao.list();
int count = dao.getCount(); */
%>
<body>
<div align="right">
<a href="insert.jsp">추가하기</a>
</div>
<h3>ADDRESS LIST(<%=count %>)</h3>
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>주소</th>
		<th>전화번호</th>
	</tr>
<%
	for(Address ad:alist){
%>
<tr> 
	<td><%=ad.getNum() %></td>
	<td><a href="detail.jsp?num=<%=ad.getNum()%>"><%=ad.getName() %></a></td>
	<!-- 주소 뒤에 ?를 붙이면 벨류를 갖고간다. -->
	<td><%=ad.getAddress() %></td>
	<td><%=ad.getTel() %></td>
</tr>
<%
	}
%>
</table>
<form action="list.jsp">
 <select name="field">
  <option value="name">이름</option>
  <option value="address">주소</option>
 </select>
 <input type="text" name="word">
 <input type="submit" value="검색">
 
 </form>
</body>
</html>