package com.board.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.comm.DBConnPool;

public class BoardDAOImpl  extends DBConnPool 
                                                implements BoardDAO{

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
	public ArrayList<BoardDTO> boardList(int startRow,int endRow) {
		ArrayList<BoardDTO > blist = new ArrayList<BoardDTO>();
	  //String sql = "select * from boards order by num desc";
		String sql = "select * from (select rownum rNum,tb.*"
							+ " from(select * from boards order by num desc) tb) "
							+ " where rNum between? and?";
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1,startRow);
			ps.setInt(2, endRow);
			rs=ps.executeQuery();
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
			//close();
		}
		return blist;
	}

	//상세보기
	@Override
	public BoardDTO findByNum(int num) {

		BoardDTO board = new BoardDTO();
		try {
			st = con.createStatement();
			String sql = "select * from boards where num="+num;
			rs = st.executeQuery(sql);
			if(rs.next()) {
				board.setContent(rs.getString("content"));
				board.setEmail(rs.getString("email"));
				board.setNum(rs.getInt("num"));
				board.setReadcount(rs.getInt("readcount"));
				board.setRegdate(rs.getString("regdate"));
				board.setSubject(rs.getString("subject"));
				board.setUserid(rs.getString("userid"));
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return board;
	}

	@Override
	public int boardUpdate(BoardDTO board) {
		int result=0;
		try {
			String sql="update boards set subject =?,content=?,regdate = sysdate where num=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, board.getSubject());
			ps.setString(2, board.getContent());
			ps.setInt(3, board.getNum());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	
	//삭제
	@Override
	public int boardDelete(int num) {
		int result=0;
			try {
				st=con.createStatement();
				String sql = "delete from boards where num=" + num;
				result=st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close();
			}
		return result;
	}

	//게시글 수
	@Override
	public int boardCount() {
		int count=0;
		try {
			st=con.createStatement();
			String sql = "select count(*) from boards";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void updateReadCount(int num) {
		String sql = "update boards set readcount = readcount+1 where num="+num;
		try {
			st=con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
	}

	@Override
	public int selectCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> selectListPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
