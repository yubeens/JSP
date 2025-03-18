<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.member.dto.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	MemberDAO dao = MemberDAOImpl.getInstance();
	dao.memberDelete(userid);
	ArrayList<Member> arr = dao.memberList();
	int count = dao.getCount();
	
	//gson.jar
	Gson gson = new Gson();
	Map<String, Object> hm= new HashMap<>();
	hm.put("jarr",arr);
	hm.put("jcount",count);
	String jsonStr = gson.toJson(hm);
	out.println(jsonStr);
%>


