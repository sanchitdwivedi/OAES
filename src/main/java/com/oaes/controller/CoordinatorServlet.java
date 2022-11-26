package com.oaes.controller;

import com.oaes.service.TestService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CoordinatorServlet", value = "/coordinator")
public class CoordinatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestService.getInstance().startTest();
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("document.getElementById('submit').disabled = true;");
        out.println("location='coordinator.jsp';");
        out.println("</script>");
    }
}
