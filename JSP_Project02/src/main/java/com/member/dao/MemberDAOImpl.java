package com.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.member.dto.Member;

public class MemberDAOImpl implements MemberDAO{
	//db셋팅
	private static MemberDAO  instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {
		return instance;
	}
	//p200
	private Connection getConnection() throws Exception {
		Context initCtx =  new InitialContext();
		Context envCtx =(Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	//추가
	@Override
	public void memberInsert(Member member) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql = "insert into member values(?,?,?,?,?,?)";
			ps= con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getUserid());
			ps.setString(3, member.getPwd());
			ps.setString(4, member.getPhone());
			ps.setString(5, member.getEmail());
			ps.setInt(6, member.getAdmin());
			ps.executeUpdate();
			
		} catch (Exception e) {
					e.printStackTrace();
		}finally {
			
		}
	}

	@Override
	public ArrayList<Member> memberList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Member> arr = new ArrayList<Member>();
		
		try {
			con = getConnection();
			st = con.createStatement();
			String sql ="select * from member";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Member m = new Member();
				m.setAdmin(rs.getInt("admin"));
				m.setEmail(rs.getString("email"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setPwd(rs.getString("pwd"));
				m.setUserid(rs.getString("userid"));
				arr.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
			return arr;
	}

	@Override
	public void memberUpdate(Member member) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			String sql="update  member set name=?, pwd=?, phone=?, email=?, admin=? where userid=? ";
		   ps= con.prepareStatement(sql);
		   ps.setString(1, member.getName());
		   ps.setString(2, member.getPwd());
		   ps.setString(3, member.getPhone());
		   ps.setString(4, member.getEmail());
		   ps.setInt(5, member.getAdmin());
		   ps.setString(6, member.getUserid());
		   ps.executeUpdate();
		} catch (Exception e) {
	 		e.printStackTrace();
		}finally {
			closeConnection(con, ps, null, null);
		}
	}

	@Override
	public void memberDelete(String userid) {
		Connection con = null;
		Statement st = null;
		
		try {
			con =getConnection();
			String sql="delete from member where userid ='"+userid+"'";
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, null);
		}
	}

	@Override
	public Member findById(String userid) {
		Connection con= null;
		Statement st = null;
		ResultSet rs = null;
		Member m = null;
		
		try {
			con = getConnection();
			String sql = "select * from member where userid='"+userid+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				m = new Member();
				m.setAdmin(rs.getInt("admin"));
				m.setEmail(rs.getString("email"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setPwd(rs.getString("pwd"));
				m.setUserid(rs.getString("userid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return m;
	}

	@Override
	public String idCheck(String userid) {
	    Connection con = null;
	    Statement st = null;
	    ResultSet rs = null;
	    String flag = "yes"; // 아이디 없음(사용가능)
	    try {
			con = getConnection();
			String sql = "select * from member where userid = '"+userid+"'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) { //아이디 존재(사용불가능)
				flag ="no";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int loginCheck(String userid, String pwd) {
		//회원아님 : -1, 회원(admin):1   회원(일반회원):0 , 비번오류 :2
		int flag = -1 ; //회원아님
		String sql = "select pwd, admin from member where userid='"+userid+"'"; 
		try(Connection con = getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)	)
		{
    		if(rs.next()) {  //userid  맞음(회원은 맞지만 비번 검사는 안함)
    			if(rs.getString("pwd").equals(pwd)) { // 비번맞음  rs.getString("pwd"): 진짜 비번  /// pwd:  입력한 비번
    				flag = rs.getInt("admin"); //0, 1
    			}else { //비번오류
    				flag =2;
    			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int getCount() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select count(*) from member";
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return count;
	}
	
	private void closeConnection(Connection con, PreparedStatement ps, 
			Statement st, ResultSet rs) {
	    	try {
				if(con!=null)  con.close();
				if(ps!=null)   ps.close();
				if(st!=null)   st.close();
				if(rs!=null)  rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

}
