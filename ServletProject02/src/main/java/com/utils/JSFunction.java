package com.utils;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspWriter;

public class JSFunction {
	public static void alertLocation(String msg, String url,HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset=utf8");
			PrintWriter out = response.getWriter();
			String script="<script>"
					+" alert('"+msg+"'); "
					+"location.href='"+url+"'; "
					+"</script>";
			out.println(script);
		}catch(Exception e) {
			
		}
	}
	//
	public static void alertBack(HttpServletResponse response, String msg) {
		try {
			response.setContentType("text/html;charset=utf8");
			PrintWriter out = response.getWriter();
			String script="<script>"
					+" alert('"+msg+"'); "
					+" history.back(); "
					+"</script>";
			out.println(script);
		}catch(Exception e) {
			
		}
	}
}
