package com.StudentManageSystem.Logout.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String path = request.getContextPath();
		Cookie userId= new Cookie("userId", "");
		userId.setMaxAge(0);
		Cookie password = new Cookie("password", "");
		password.setMaxAge(0);
		Cookie occupation = new Cookie("occupation", "");
		occupation.setMaxAge(0);
		response.addCookie(userId);
		response.addCookie(password);
		response.addCookie(occupation);
		/*
		for(Cookie cookie : cookies)
		{
			if(cookie.getName().equals("userId") || cookie.getName().equals("password") || cookie.getName().equals("occupation"))
			{
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}*/
		//cookies = request.getCookies();
		
		/*
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp"); 
		dispatcher.forward(request, response); */
		response.sendRedirect("Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
