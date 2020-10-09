/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 758688
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        
      // HttpSession session = request.getSession();
       //session.setAttribute("username", username);
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountService account = new AccountService();
        User user = account.login(username,password);
        if (user == null)
        {
         String message = "Login credentials invalid";
         request.setAttribute("message", message);
         
         getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);   
        }
        else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                .forward(request, response); 
        }
      
        return;
    }
}

