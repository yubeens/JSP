<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
    // 스크립트릿: 데이터를 받기 전에 문자 인코딩을 설정합니다.
    request.setCharacterEncoding("utf-8");

    // 사용자로부터 입력된 데이터를 받아 처리
    String name = request.getParameter("name");
    int kor = Integer.parseInt(request.getParameter("kor"));
    int eng = Integer.parseInt(request.getParameter("eng"));
    int math = Integer.parseInt(request.getParameter("math"));

    // 총점과 평균 계산
    int total = kor + eng + math;
    float avg = total / 3.0f;

    // 학점 계산
    String grade;
    if (avg >= 90) {
        grade = "A";
    } else if (avg >= 80) {
        grade = "B";
    } else if (avg >= 70) {
        grade = "C";
    } else {
        grade = "F";
    }
    
    //switch문
    /*switch((int)avg/10){
    case 10:
    case 9:grade="A";break;
    case 8:grade="B";break;
    case 7:grade="C";break;
    default:grade="F";
    }*/
%>

<!-- 표현식으로 출력하기 -->
이름: <%= name %><br>
국어: <%= kor %><br>
영어: <%= eng %><br>
수학: <%= math %><br>
총점: <%= total %><br>
평균: <%= avg %><br>
학점: <%= grade %><br>

</body>
</html>
