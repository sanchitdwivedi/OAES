package com.oaes.controller;

import com.oaes.AuthenticationManager;
import com.oaes.entity.Student;
import com.oaes.entity.User;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private String message;
    private AuthenticationManager authenticationManager;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Here 1");
        authenticationManager = AuthenticationManager.getInstance();
        PrintWriter out = response.getWriter();
        try {
            if(request.getParameter("yesno").equals("1")){
                Object obj = authenticationManager.authenticateByUserID(Long.parseLong(request.getParameter("userID")), request.getParameter("password"));
                if(!(obj instanceof User)){
                    out.print(obj.toString());
                    throw new Exception("Login not successful..");
                }
                else if(obj instanceof Student){
                    request.getSession().setAttribute("student", obj);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                }
                else{
                    RequestDispatcher dispatcher = request.getRequestDispatcher("coordinator.jsp");
                    dispatcher.forward(request, response);
                }
            }
            else{
                System.out.println("Here");
                Object obj = authenticationManager.authenticateByEmail(request.getParameter("email"), request.getParameter("password"));
                if(!(obj instanceof User)) {
                    out.print(obj.toString());
                    throw new Exception("Login not successful..");
                }
                else if(obj instanceof Student){
                    request.getSession().setAttribute("student", obj);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
                    dispatcher.forward(request, response);
                }
                else{
                    RequestDispatcher dispatcher = request.getRequestDispatcher("coordinator.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            RequestDispatcher rd=request.getRequestDispatcher("login.html");
            rd.include(request,response);
        }
    }

    public void destroy() {
    }
}