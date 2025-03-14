$(document).ready(function(){
	var exp = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/
	$("#btnSend").click(function(){
		if($("#name").val()==""){
			alert("이름을 입력하세요")
			$("#name").focus();
			return false;
		}
		if($("#userid").val()==""){
				alert("아이디를 입력하세요")
				$("#userid").focus();
				return false;
		}
		if($("#pwd").val()==""){
					alert("비밀번호를 입력하세요")
					$("#pwd").focus();
					return false;
		}
		if($("#pwd").val() !=  $("#pwd_check").val()){
			alert("비밀번호가 일치하지 않습니다.")
			$("#pwd_check").focus()
			return false;
		}
		if($("#email").val()==""){
			alert("이메일을 입력하세요")
			$("#email").focus();
			return false;
		}
/*		if(!$("#phone").val().match(exp)){
					alert("전화번호 형식이 아닙니다.")
					$("#phone").focus();
					return false;
		}*/
		if(!exp.test($("#phone").val())){
							alert("전화번호 형식이 아닙니다.")
							$("#phone").focus();
							return false;
		}
		$("#frm").submit()
		
	}) //btnSend

	$("#btnIdCheck").click(function(){
		window.open("idCheck.jsp","","width=500 height=300")
	})
	
	$("#btnUse").click(function(){
		if($("#userid").val()==""){
			alert("userid 입력하세요")
			return
		}
		$.ajax({
			type: "get",
			url : "idCheckProc.jsp",
			data : { userid : $("#userid").val()},
			success:function(resp){
				if(resp.trim()=="yes"){
					alert("사용가능한 아이디 입니다.")
					$(opener.document).find("#userid").val($("#userid").val())
					self.close()
				}else{
					alert("사용 불가능한 아이디 입니다.");
					$("#userid").val("")
					$("#userid").focus()
				}
			},
			error:function(e){
				alert(e + " : error");
			}
		})
	})  //btnUse
}) //document

function del(userid,mode){
	if(mode =='관리자'){
	    alert('관리자는 삭제할 수 없습니다.')
		return
	}
	if(confirm('정말 삭제할까요?')){
		$.getJSON("memberDeleteProc.jsp",
			{userid : userid},
			function(resp){
				let str =""
				$.each(resp.jarr, function(key, val){
					let mode = val.admin==0? "일반회원":"관리자"
					str+="<tr>"
					str+="<td>"+val.name +"</td>"
					str+="<td>"+val.userid +"</td>"
					str+="<td>"+val.phone +"</td>"
					str+="<td>"+val.email +"</td>"
					str+="<td>"+mode +"</td>"
					str+="<td><a href=javascript:del('"+val.userid+"','"+mode+"')>삭제</a></td>"
					str+="</tr>"
				})  //each
				$("table tbody").html(str)
				$("#scount").text(resp.jcount);
			}  //function
		); //getJSON
		
	}
	
}




