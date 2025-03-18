<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="com.member.dto.Member"></jsp:useBean>
<jsp:setProperty    property="*" name="member" ></jsp:setProperty>
<%
 MemberDAO dao = MemberDAOImpl.getInstance();
String sid =(String) session.getAttribute("sUserid");
member.setUserid(sid);
dao.memberUpdate(member);
session.invalidate();
response.sendRedirect("loginForm.jsp");
%>





