<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--사용자한테 보여주는 기능 없음-->
<%
 request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="addr" class="com.address.Address"></jsp:useBean>
<jsp:setProperty property="*" name="addr"/>
<%
AddressDAO dao = new AddressDAO();
dao.insert(addr);
response.sendRedirect("list.jsp"); //11번을 수행하고나면 실행됨 (해당 경로로 가라)
%>
