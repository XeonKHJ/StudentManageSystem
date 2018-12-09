package com.StudentManageSystem.ChangePassword.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManageSystem.bean.DatabaseConnection;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置该Servlet页面编码
		response.setContentType("text/html;charset=UTF-8");

		//通过Cookie登陆数据库
		Cookie[] cookies = request.getCookies();
		DatabaseConnection dbCon = null;
		String userId = "";
		String password = "";
		String occupation = "";
		String orignalPw = request.getParameter("orignalPw");
		String newPw = request.getParameter("newPw");
		String repeatNewPw = request.getParameter("repeatNewPw");
		for(Cookie cookie : cookies)
		{
			if(cookie.getName().equals("userId"))
			{
				userId = cookie.getValue();
			}
			else if(cookie.getName().equals("password"))
			{
				password = cookie.getValue();
			}
			else if(cookie.getName().equals("occupation"))
			{
				occupation = cookie.getValue();
			}
		}
		try 
		{
			if(!orignalPw.equals(password))
			{
				response.getWriter().println("密码错误！");
				throw new Exception("密码错误！");
			}
			else if(!newPw.equals(repeatNewPw))
			{
				response.getWriter().println("新密码不一样！");
				throw new Exception("新密码不一样！");
			}
			if(occupation.equals("student"))
			{
				dbCon = new DatabaseConnection("StudentManagementStudent", "1234", "XEON-DELL7460", "StudentsManagement");
			}
			else if(occupation.equals("admin"))
			{
				dbCon = new DatabaseConnection(userId, password, "XEON-DELL7460", "StudentsManagement");
			}
			Connection con = dbCon.getCon();
			Statement stat = con.createStatement();
			String changePwSql = "UPDATE Students SET Spassword = '" + newPw + "' WHERE Sno = '" + userId + "'" ;
			stat.executeUpdate(changePwSql);
			response.getWriter().println("修改成功，请重新登录");
			response.sendRedirect("Logout");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
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
