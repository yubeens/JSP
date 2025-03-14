<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file ="../includes/header.jsp" %>   
<script src="../js/member.js"></script>
<div class="container mt-5">
	<h2>회원가입</h2>
	 <form action="join.do" method="post" id="frm">
     <div class="mb-3 mt-3">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    <div class="row">
	      <div class="col mb-3">
		      <label for="userid">Userid:</label>
		      <input type="text" class="form-control" id="userid" placeholder="Enter Userid" name="userid">
	    </div>
	    <div class="col mb-3 align-self-end">
	    	<button type="button"  class="btn btn-secondary" id="btnIdCheck">중복확인</button>
	    </div>
    </div>
     <div class="mb-3">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    
       <div class="mb-3">
      <label for="pwd_check">Password_Check:</label>
      <input type="password" class="form-control" id="pwd_check" placeholder="Enter pwd_check" name="pwd_check">
    </div>
    
    <div class="mb-3">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
     <div class="mb-3">
      <label for="phone">Phone:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone">
    </div>
     <div class="form-check-inline">
      <input type="radio" class="form-check-input" id="radio1" name="admin" value="0" checked>
      <label class="form-check-label" for="radio1">일반회원</label>
    </div>
    <div class="form-check-inline">
      <input type="radio" class="form-check-input" id="radio2" name="admin" value="1">
      <label class="form-check-label" for="radio2">관리자</label>
    </div>
     <div  class="mt-3">
    <button type="button" class="btn btn-primary" id="btnSend">Submit</button>
    </div>
  </form>
</div>

</body>
</html>