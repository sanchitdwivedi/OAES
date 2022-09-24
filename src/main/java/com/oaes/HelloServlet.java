package com.oaes;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "")
public class HelloServlet extends HttpServlet {
    private String message;
    private AuthenticationManager authenticationManager;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            if(request.getParameter("userIDCheck").equals("1")){
                if(authenticationManager.authenticateByEmail(request.getParameter("email"), request.getParameter("password"))){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
                    dispatcher.forward(request, response);
                }
                else throw new Exception("Login not successful..");
            }
            else{
                if(authenticationManager.authenticateByUserID(Long.parseLong(request.getParameter("userID")), request.getParameter("password"))){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
                    dispatcher.forward(request, response);
                }
                else throw new Exception("Login not successful..");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}