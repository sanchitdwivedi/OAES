package com.oaes.controller;

import com.oaes.entity.Student;
import com.oaes.service.TestService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    TestService testService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("tandc")==null || request.getParameter("mic")==null) {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please give appropriate permissions');");
            out.println("location='home.jsp';");
            out.println("</script>");
        }
        else {
            Student student = (Student) request.getSession().getAttribute("student");
            testService = TestService.getInstance();
            testService.subscribe(student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("exam.jsp");
            dispatcher.forward(request, response);
        }
    }
}
