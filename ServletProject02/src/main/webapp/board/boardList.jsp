<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>   
 <%@ include file ="../includes/header.jsp" %>   
 <script>
 $(function(){
	 $("#btnWrite").click(function(){
		 if(${empty sessionScope.suser}){
			 alert("로그인하세요")
			 location.href = "/member/login.do"
			 return false;
		 }
		 location.href="/board/write.do"
	 })
 })
 </script>
<div class="container mt-5">
	<h2>Board LIST</h2>
	<div class="mt-5 mb-3">
		<button class="btn btn-secondary" id="btnWrite">글쓰기</button>
	</div>
	
	<table class="table table-hover">
		  <thead>
		        <tr>
		        <th>번호</th>
		        <th>제목</th>
		        <th>작성자</th>
		         <th>작성일</th>
		         <th>조회수</th>
		      </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${barr }" var="board">
		  	<tr>
		  			<td>${board.num }</td>
		  			<td>${board.subject }</td>
		  			<td>${board.userid }</td>
		  			<td>${board.regdate }</td>
		  			<td>${board.readcount }</td>
		  	</tr>
		</c:forEach>
  </tbody>
  </table>
</div>


</body>
</html>