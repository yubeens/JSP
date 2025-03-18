package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		//검색 관련
		Map<String, Object> map = new HashMap<>();
		String searchWord = request.getParameter("searchWord")==null?"":request.getParameter("searchWord");
		String searchField = request.getParameter("searchField");
		if(!(searchWord.equals(""))) {
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
		}
		
//  	p.506내용
//		String searchField = request.getParameter("searchField");
//		String searchWord = request.getParameter("searchWord");
//
//		if(searchWord != null) {
//			map.put("searchField", searchField);
//			map.put("searchWord", searchWord);
//		}

		BoardDAO dao = new BoardDAOImpl();
		
		//검색 포함 게시글 갯수
		int count =dao.selectCount(map);
		//페이징 관련
		String pageNum = request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 5; //한 화면에 보여지는 수
		int startRow = (currentPage-1)*pageSize +1;
		int endRow = currentPage*pageSize;
		
		map.put("start",startRow);
		map.put("end",endRow);
		
		List<BoardDTO> blist = dao.selectListPage(map);
		int rowNo = count - (currentPage-1)*pageSize; //페이지 카운트 수
		
		//ArrayList<BoardDTO> blist =  dao.boardList(startRow,endRow); //예)100
		//int count = dao.boardCount(); //3
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
		page.setSearchField(searchField);
		page.setSearchWord(searchWord);
		request.setAttribute("p", page);
		
		dao.close();
		request.setAttribute("rowNo", rowNo);
		request.setAttribute("barr", blist);
		request.setAttribute("count", count);
		request.setAttribute("page", page);
		
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
