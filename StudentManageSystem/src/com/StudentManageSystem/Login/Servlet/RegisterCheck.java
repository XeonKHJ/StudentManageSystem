package com.StudentManageSystem.Login.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManageSystem.bean.*;
import com.microsoft.sqlserver.jdbc.SQLServerException;
/**
 * Servlet implementation class Login
 */
@WebServlet(description = "Deal with login action", urlPatterns = { "/Login" })
public class LoginCheck extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String title = "正在登陆……";
		String docType = "<!DOCTYPE html> \n";
        out.println(docType +
        "<html>\n" +
        "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"+
        "<body bgcolor=\"#f0f0f0\">\n" +
        "<h1 align=\"center\">" + title + "</h1>\n" +
        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
        "<tr bgcolor=\"#949494\">\n" +
        "<th>Header 名称n</th><th>Header 值</th>\n"+
        "</tr>\n");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String password = 
		try {
			//运用SQL代码建立
		} catch (SQLServerException e) {
			out.println("<p>账号密码错误</p>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
	{
		System.out.println("systemFilterfuck");
	}
	
	public void init(FilterConfig filterConfig)
	{
		System.out.println("this is really suck");
	}
	
}
