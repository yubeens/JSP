package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.board.model.BoardDAO;
import com.board.model.BoardDAOImpl;
import com.board.model.CommentDTO;
import com.member.model.MemberDTO;

/**
 * Servlet implementation class CommentInsertController
 */
@WebServlet("/board/cInsert.do")
public class CommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String msg = request.getParameter("msg");
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		//session 에서 userid 구하기
		HttpSession session = request.getSession();
		MemberDTO suser = (MemberDTO)session.getAttribute("suser");
		if(suser==null) {
			PrintWriter out = response.getWriter();
			out.println("1");
			return;
		}
		
		CommentDTO comment = new CommentDTO();
		comment.setBnum(bnum);
		comment.setMsg(msg);
		comment.setUserid(suser.getUserid());
		
		BoardDAO dao = new BoardDAOImpl();
		dao.commentInsert(comment);
		dao.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
