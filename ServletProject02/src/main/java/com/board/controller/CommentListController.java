package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.board.model.BoardDAO;
import com.board.model.BoardDAOImpl;
import com.board.model.CommentDTO;
import com.google.gson.Gson;

/**
 * Servlet implementation class CommentListController
 */
@WebServlet("/board/cList.do")
public class CommentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		BoardDAO dao = new BoardDAOImpl();
		ArrayList<CommentDTO> clist = dao.commentList(bnum);
		int count = dao.commentCount(bnum);
		dao.close();
		
		Gson gson = new Gson();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("jarr", clist);
		map.put("count", count);
		String jsonStr = gson.toJson(map);
		//화면에 출력
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jsonStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
