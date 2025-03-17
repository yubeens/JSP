package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.board.model.BoardDAO;
import com.board.model.BoardDAOImpl;
import com.board.model.BoardDTO;
import com.comm.PageUtil;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/board/list.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDAO dao = new BoardDAOImpl();
		//페이징 관련
		String pageNum = request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 5; //한 화면에 보여지는 수
		int startRow = (currentPage-1)*pageSize +1;
		int endRow = currentPage*pageSize;
		
		ArrayList<BoardDTO> blist =  dao.boardList(startRow,endRow); //예)100
		int count = dao.boardCount(); //3
		//총 페이지 수
		int totPage = count/pageSize+(count%pageSize==0?0:1); //1
		int blockPage = 3;
		int startPage = ((currentPage-1)/blockPage)*blockPage+1;  //1
		int endPage = startPage+blockPage-1; //3(계산상)
		if(endPage > totPage) endPage=totPage;
			
		PageUtil page = new PageUtil();
		page.setBlockPage(blockPage);
		page.setStartPage(startPage);
		page.setEndPage(endPage);
		page.setCurrentPage(currentPage);
		page.setTotPage(totPage);
		request.setAttribute("p", page);
		
		
		dao.close();
		request.setAttribute("barr", blist);
		request.setAttribute("count", count);
		request.getRequestDispatcher("boardList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
