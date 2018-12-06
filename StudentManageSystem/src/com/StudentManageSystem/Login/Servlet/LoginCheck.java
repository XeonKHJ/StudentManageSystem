package com.StudentManageSystem.Login.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		//String docType = "<!DOCTYPE html> \n";
        /*out.println(docType +
        "<html>\n" +
        "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"+
        "<body bgcolor=\"#f0f0f0\">\n" +
        "<h1 align=\"center\">" + title + "</h1>\n" +
        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
        "<tr bgcolor=\"#949494\">\n" +
        "<th>Header 名称n</th><th>Header 值</th>\n"+
        "</tr>\n");*/
        //out.println("正在登录……");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String occupation = request.getParameter("occupation");
		try {
			if(occupation.equals("admin"))
			{
				new DatabaseConnection(userId, password, "XEON-DELL7460", "StudentsManagement");
				//Connection dbConnection = dbConnectionInfo.getCon();
				Cookie occuCookie = new Cookie("occupation", occupation);
				Cookie idCookie = new Cookie("userId", userId);
				Cookie pwCookie = new Cookie("password", password);
				response.addCookie(idCookie);
				response.addCookie(pwCookie);
				response.addCookie(occuCookie);
			}
			else if(occupation.equals("student"))
			{
				DatabaseConnection dbConnectionInfo = new DatabaseConnection("StudentManagementStudent", "1234", "XEON-DELL7460", "StudentsManagement");
				Connection con = dbConnectionInfo.getCon();
				Statement stat = con.createStatement();
				ResultSet result = stat.executeQuery("SELECT SPassword FROM Students WHERE Sno = '" + userId + "' AND SPassword = '" + password+"'");
				if(!result.next())
				{
					throw new Exception("账号错误！");
				}
			}
			Cookie occuCookie = new Cookie("occupation", occupation);
			Cookie idCookie = new Cookie("userId", userId);
			Cookie pwCookie = new Cookie("password", password);
			response.addCookie(idCookie);
			response.addCookie(pwCookie);
			response.addCookie(occuCookie);
			out.println("1");
		} catch (Exception e) {
			out.println("登陆失败！请检查你的用户名和密码！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
