<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
AddressDAO dao = new AddressDAO();
int num = Integer.parseInt(request.getParameter("num"));
dao.delete(num);
response.sendRedirect("list.jsp");
%>