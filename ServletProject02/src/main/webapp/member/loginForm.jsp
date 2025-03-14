<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file ="../includes/header.jsp" %>   
<div class="container mt-5">

	<h2>로그인</h2>
     <div class="mb-3">
      <label for="userid">UserID:</label>
      <input type="text" class="form-control" id="userid" placeholder="Enter userid" name="userid">
    </div>
     <div class="mb-3">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <button type="button" class="btn btn-primary" id="btnLogin">로그인</button>
</div>
<script>
$("#btnLogin").click(function(){
	if($("#userid").val() == ""){
		alert("아이디를 입력하세요");
		$("#userid").focus();
		return false;
	} //userid
	if($("#pwd").val() ==""){
		alert("비밀번호를 입력하세요");
		$("#pwd").focus();
		return false;
	} //pwd
	$.ajax({
		type : "post",
		url : "login.do",
		data : {
			userid : $("#userid").val(),
			pwd : $("#pwd").val()
		},
		
		success:function(resp){
			if(resp.trim()==0){
				alert("일반회원 로그인성공")
				location.href="/board/list.do";
			}else if(resp.trim()==1){
				alert("관리자 로그인성공")
				$(location).attr("href", "/board/list.do");
			}else if(resp==-1){
				alert("회원이 아닙니다. 회원가입 하세요")
			}else if(resp ==2){
				alert("비밀번호가 틀립니다. 비번을 확인하세요")
			}
		},
		error : function(e){
			alert(e +" : error")
		}
	})  //ajax
}) // btnLogin

</script>

</body>
</html>