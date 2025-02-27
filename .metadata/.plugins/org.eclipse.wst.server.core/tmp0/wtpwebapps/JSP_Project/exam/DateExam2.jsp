<%@page import="com.exea.DateBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
     DateBean bean = new DateBean();
    %>
    <%=bean.getToday()%>