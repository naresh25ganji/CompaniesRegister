package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LOGIN = "/login.jsp";
	private static String INDEX = "/index.jsp";
	
	private UserDao dao;
       
    public LoginController() {
        super();
        dao = new UserDao();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUserName(request.getParameter("username").trim());
		user.setPassword(request.getParameter("password").trim());
        if(dao.authenticateUser(user))
        {
            RequestDispatcher view = request.getRequestDispatcher(INDEX);
            request.setAttribute("successMessage", "Login Successful");
            view.forward(request, response);
        }
        else
        {
            RequestDispatcher view = request.getRequestDispatcher(LOGIN);
            request.setAttribute("errorMessage", "Username and/or Password is incorrect. Please try again.");
            view.forward(request, response);
        }
	}

}
