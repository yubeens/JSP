<%@page import="com.address.AddressDAO"%>
<%@page import="com.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

Address address = new Address();
address.setAddress(request.getParameter("addr"));
address.setName(request.getParameter("name"));
address.setTel(request.getParameter("tel"));
address.setZipcode(request.getParameter("zipcode"));

AddressDAO jdao = new AddressDAO();
jdao.insert(address);
response.sendRedirect("list.jsp");
%>