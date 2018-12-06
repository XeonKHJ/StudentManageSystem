package com.StudentManagementSystem.Logout.Servlet;

import java.io.IOException;
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
		int userNo, pwNo;
		for(userNo = 0; userNo < cookies.length && !cookies[userNo].getName().equals("userId") ; ++userNo);
		for(pwNo = 0; pwNo < cookies.length && !cookies[pwNo].getName().equals("password"); ++pwNo);
		if(userNo != cookies.length + 1)
		{
			cookies[userNo].setPath("/");//立即删除型
			cookies[pwNo].setPath("/");
			
			cookies[userNo].setMaxAge(0);//立即删除型
			cookies[pwNo].setMaxAge(0);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
