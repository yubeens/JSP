<%@page import="com.address.ZipCode"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
$(function(){ //검색버튼 클릭
	$("#send").click(function(){
		sendIt()
	})
	
	$("#dong").keydown(function(e){ //동이름 입력하고 엔터키
		if(e.keyCode==13){ //엔터키의 유니코드는 13
			sendIt()
		}
	})
	
	
	
	$("#result").on("click","tr",function(){
	const address= $("td:eq(1)",this).text()+""+
				   $("td:eq(2)",this).text()+""+
				   $("td:eq(3)",this).text()+""+
				   $("td:eq(4)",this).text()
	$(opener.document).find("#zipcode").val($("td:eq(0)",this).text())
	$(opener.document).find("#addr").val(address);
	self.close()
	})

}) //document

var sendIt=function(){
	if($("#dong").val()==""){
		alert("동 이름을 입력하세요");
		return false;
	}
	$.getJSON("zipProc.jsp",
			{"dong":$("#dong").val()}, //두번째는 가지고 가는 값 , 세번째는 콜백
			function(resp){
				
				var str="<table>"
				$.each(resp,function(key,val){
					str+="<tr>"
					str+="<td>"+val.zipcode+"</td>"
					str+="<td>"+val.sido+"</td>"
					str+="<td>"+val.gugun+"</td>"
					str+="<td>"+val.dong+"</td>"
					str+="<td>"+val.bunji+"</td>"
					str+="</tr>"
				})
					str+="</table>"
					$("#result").html(str)
		}//콜백함수 function
	)//getJSON
}//sendit

</script>
</head>
<body>
<h3>우편번호 찾기</h3>
<form action="zipCheck.jsp" id="frm">
  <table>
      <tr>
          <td>동이름 입력
          <input type = text id="dong" name="dong">
           <button type ="button" id="send">검색</button> </td>
      </tr>
      <tr>
    </table>
    <div id="result"></div>
</form>
</body>
</html>