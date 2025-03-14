package com.comm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnPool {
	public Connection con;
	public Statement st;
	public PreparedStatement ps;
	public ResultSet rs;
	
	//기본생성자
	public DBConnPool() {
		   // 커넥션 풀(DataSource) 얻기
			try {
				Context initCtx = new InitialContext();
				Context envCtx =(Context)initCtx.lookup("java:comp/env");
				DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
				con =  ds.getConnection();
				System.out.println(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	//연결해제(자원반납)
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
