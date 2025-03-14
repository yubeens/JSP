package com.board.model;

import java.sql.SQLException;
import java.util.ArrayList;

import com.comm.DBConnPool;

public class BoardDAOImpl  extends DBConnPool implements BoardDAO{

	@Override
	public int boardInsert(BoardDTO board) {
		int result = 0;
		String sql = "insert into boards(num, userid, subject, email, content) "
				+ " values(boards_seq.nextval,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getUserid());
			ps.setString(2, board.getSubject());
			ps.setString(3, board.getEmail());
			ps.setString(4, board.getContent());
		    result 	=ps.executeUpdate();  // 추가 성공 이면    result=1 /  실패  result=0
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}

	@Override
	public ArrayList<BoardDTO> boardList() {
		ArrayList<BoardDTO > blist = new ArrayList<BoardDTO>();
		String sql = "select * from boards order by num desc";
		try {
			st= con.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setContent(rs.getString("content"));
				board.setEmail(rs.getString("email"));
				board.setNum(rs.getInt("num"));
				board.setReadcount(rs.getInt("readcount"));
				board.setRegdate(rs.getString("regdate"));
				board.setSubject(rs.getString("subject"));
				board.setUserid(rs.getString("userid"));
				blist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return blist;
	}

	@Override
	public BoardDTO findByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardUpdate(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
