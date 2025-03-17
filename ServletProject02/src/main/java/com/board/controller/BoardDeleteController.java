package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.board.model.BoardDAO;
import com.board.model.BoardDAOImpl;
import com.utils.JSFunction;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/board/delete.do")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDAO dao = new BoardDAOImpl();
		int result = dao.boardDelete(num);
		System.out.println("result : " + result);
//		response.sendRedirect("list.do");		
		
		if(result==1) { //삭제성공
			JSFunction.alertLocation("삭제 성공", "list.do",response);
		}else { //삭제실패
			JSFunction.alertBack(response,"삭제 실패");
		}
		
//		자바스크립트 코드추가
//		response.setContentType("text/gtml;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		if(result==1) {
//			String str = "<script>";
//				str +="alert('게시글이 삭제되었습니다.');";
//				str +="location.href='list.do'";
//				str +="</script>";
//			out.println(str);
//		}else {
//			String str = "<script>";
//				str +="alert('게시글 삭제 중 오류발생!');";
//				str +="</script>";
//			out.println(str);
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
