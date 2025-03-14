package com.member.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.comm.DBConnPool;

public class MemberDAOImpl  extends DBConnPool implements MemberDAO{

	//생성자
	public MemberDAOImpl() {
		super();
	}
	@Override
	public void memberJoin(MemberDTO member) {
			String sql = "insert into member values(?,?,?,?,?,?)";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, member.getName());
				ps.setString(2, member.getUserid());
				ps.setString(3, member.getPwd());
				ps.setString(4, member.getPhone());
				ps.setString(5, member.getEmail());
				ps.setInt(6, member.getAdmin());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
	}

	@Override
	public ArrayList<MemberDTO> getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void memberUpdate(MemberDTO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberDelete(String userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDTO findById(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String memberIdCheck(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO memberLoginCheck(String userid, String pwd) {
		//비회원 , 성공, 비번 오류 
		MemberDTO member = new MemberDTO();
		member.setAdmin(-1); //회원아님(비회원)
		String sql = "select * from member where userid ='"+userid+"'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) { //id는 맞음(회원은 맞음)
				if(rs.getString("pwd").equals(pwd)) { //비번맞음(로그인성공)
					member.setAdmin(rs.getInt("admin"));  //0 일반회원 ,1 관리자
					member.setEmail(rs.getString("email"));
					member.setName(rs.getString("name"));
					member.setPhone(rs.getString("phone"));
					member.setPwd(rs.getString("pwd"));
					member.setUserid(rs.getString("userid"));
				}else { //비번 틀림
					member.setAdmin(2); 
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return member;
	}

}
