<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORM EXAM</title>
<script>
function check() {
   if(document.querySelector("#name").value==""){
	   alert("이름입력")
	   return;
   }
   if(document.querySelector("#age").value==""){
	   alert("나이입력")
	   return;
   }
   var chk_ob=document.getElementsByName("hobby");
   var chk_flag=false; //선택이 하나라도 안됨
 /*for(i=0; i<chk_ob.length; i++){
	   if(chk_ob[i].checked){
		   chk_flag=true; //chk_flag가 true면 선택된 게 있음
	   }
   }*/
   chk_ob.forEach(f=>{
	   if(f.checked){
		   chk_flag=true
	   }
   });
   
   if(chk_flag==false){
	   alert("관심분야 선택")
	   return;
   }
   
   document.getElementById("frm").submit()
}
</script>
</head>
<body>
<form action="formResult.jsp" method="post" id="frm">
이름:<input type="text" name="name" id="name"><br>
나이:<input type="number" name="age" id="age"><br>
성별:
<label for="man">남자</label>
	<input type="radio" name="gender" id="man" value="남자" checked>
<label for="woman">여자</label>
	<input type="radio" name="gender" id="woman" value="여자"><br>
관심분야:
<label for ="h1">운동</label>
	<input type="checkbox" name="hobby" id="h1" value="운동">
<label for ="h2">게임</label>
	<input type="checkbox" name="hobby" id="h2" value="게임">
<label for ="h3">등산</label>
	<label><input type="checkbox" name="hobby" id="h3" value="등산">
<label for ="h4">영화</label>
<label><input type="checkbox" name="hobby" id="h4" value="영화"><br>
<label for ="job">직업:</label>
<select name = job id="job">
	<option value="사무직">사무직</option>
	<option value="전문직">전문직</option>
	<option value="서비스직">서비스직</option>
	<option value="예체능">예체능</option>
	<option value="기타">기타</option>
</select><br>
<input type=button value="button전송" onclick="check()">
</form>

</body>
</html>