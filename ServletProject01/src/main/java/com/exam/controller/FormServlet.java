package com.exam.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String job = req.getParameter("job");
        String[]hobby = req.getParameterValues("hobby");
        Form f = new Form();
        f.setAge(age);
        f.setGender(gender);
        f.setHobby(hobby);
        f.setJob(job);
        f.setName(name);
        
        req.setAttribute("form", f);
        
        RequestDispatcher rd = req.getRequestDispatcher("formResult.jsp");
        rd.forward(req, resp);
        
    }

}