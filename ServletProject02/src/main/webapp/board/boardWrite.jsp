<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file ="../includes/header.jsp" %>   
 <script>
 function validateForm(form){
	 //subject, content 
	 if(form.subject.value==""){
		 alert("제목을 입력하세요")
		 form.subject.focus();
		 return false
	 }
	 if(form.content.value==""){
		 alert("내용을 입력하세요")
		 form.content.focus();
		 return false
	 }
 }
 </script>

<div class="container mt-5">
	<h2>Board Write</h2>
	 <form action="write.do" method="post" name="frm" onsubmit="return validateForm(this)">
	     <div class="mb-3 mt-3">
	      <label for="userid">Userid:</label>
	      <input type="text" class="form-control" id="userid" placeholder="Enter userid" 
	      name="userid" value="${sessionScope.suser.userid}" readonly="readonly">
	    </div>
	    
	   <div class="mb-3 mt-3">
	      <label for="subject">Subject:</label>
	      <input type="text" class="form-control" id="subject" placeholder="Enter subject" name="subject">
	    </div>
    
	    <div class="mb-3">
	      <label for="email">Email:</label>
	      <input type="email" class="form-control" id="email" placeholder="Enter email" 
	      name="email"  value="${sessionScope.suser.email}" readonly="readonly">
	    </div>
	    <div class="mb-3">
	     <label for="content">content:</label>
			  <textarea class="form-control" id="content" name="content" 
			   placeholder="Content goes here" rows=5></textarea>
	   </div>   
	    
     <div  class="mt-3">
    	<button type="submit" class="btn btn-primary" id="btnSend">글쓰기</button>
    </div>
  </form>
</div>

</body>
</html>