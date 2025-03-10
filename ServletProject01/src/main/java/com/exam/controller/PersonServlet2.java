package com.exam.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PersonServlet2
 */
@WebServlet("/exam/person2.go")
public class PersonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		Person p = new Person();
        p.setAddress(req.getParameter("address"));
        p.setId(req.getParameter("id"));
        p.setName(req.getParameter("name"));
        p.setPhone(req.getParameter("phone"));
        p.setPwd(req.getParameter("pwd"));

        req.setAttribute("person", p);
        RequestDispatcher rd = req.getRequestDispatcher("personResult2.jsp");
        rd.forward(req, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
