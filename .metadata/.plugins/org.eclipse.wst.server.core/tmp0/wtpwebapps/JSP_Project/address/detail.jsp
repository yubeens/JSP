<%@page import="com.address.Address"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
AddressDAO dao = new AddressDAO();
int num = Integer.parseInt(request.getParameter("num"));
Address address = dao.detail(num);
%>

<script>
function zipfinder(){
	window.open("zipCheck.jsp","","width=700 height=400")
	
}

function del(){
	if(confirm("정말 삭제 할까요?")){
		location.href="deleteProcess.jsp?num=<%=num%>";
	}
}
</script>
</head>
<body>
<h3>상세보기</h3>
<form action = "updateProcess.jsp">
<input type="hidden" name="num" value="<%=address.getNum()%>">
 <table>
 	<tr>
 	 <th>번호</th>
 	 <!--<td><%=address.getNum()%>"></td>-->
 	 <!--<td><input type="text" name="num" value="<%=address.getNum()%>" disabled="disabled"></td> input type hidden을 만들어야 값이 넘어감--> 
 	 <td><input type="text" name="num" value="<%=address.getNum()%>" readonly="readonly"></td>  <!--hidden없이 값을 넘길 수 잇음 -->
 	 </tr>
 	<tr>
 	 	<th>이름</th>
 	 	<td><input type="text" name="name" value="<%=address.getName()%>"></td>
 	</tr>
 	<tr>
 	 	<th>우편번호</th>
 	 	<td><input type="text" name="zipcode" id="zipcode" value="<%=address.getZipcode()%>" size=7 readonly="readonly">
 	 	<button type="button" onclick="zipfinder()">검색</button></td>
 	</tr>
 	<tr>
 	 	<th>주소</th>
 	 	<td><input type="text" name="address" id="addr" value="<%=address.getAddress()%>" size=50></td>
 	</tr>
 	<tr>
 	 	<th>전화번호</th>
 	 	<td><input type="text" name="tel" value="<%=address.getTel()%>"></td>
 	</tr>
 	<tr>
 	  <td colspan="2">
 	  		<button>수정</button>
 	  		<button type ="reset">수정취소</button>
 	  		<button type="button" onclick="del()">삭제</button>
 	  		<button type="button" onclick="location.href='list.jsp'">전체보기</button>
 	  </td>
 	 </tr>
 </table>
</form>
</body>
</html>