package com.StudentManageSystem.AddCourse.Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManageSystem.bean.DatabaseConnection;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;

/**
 * Servlet implementation class AddCourse
 */
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//通过Cookie找到用户名和密码
		Cookie[] cookies = request.getCookies();
		int userNo, pwNo;
		for(userNo = 0; userNo < cookies.length && !cookies[userNo].getName().equals("userId") ; ++userNo);
		for(pwNo = 0; pwNo < cookies.length && !cookies[pwNo].getName().equals("password"); ++pwNo);
		
		String courseId = request.getParameter("courseId");
		String courseName = request.getParameter("courseName");
		String deleteFlag = request.getParameter("deleteFlag");
		String sql;
		if(deleteFlag != null)
		{
			sql = "DELETE FROM Courses WHERE Cno = '" + courseId + "'";
		}
		else
		{
			sql = "INSERT INTO Courses VALUES ('" + courseId + "', '" + courseName + "')";
		}
		int result = 0;
		try {
			if(courseId == "")
			{
				throw new SQLException();
			}
			DatabaseConnection dbConnectionInfo = new DatabaseConnection(cookies[userNo].getValue(), cookies[pwNo].getValue(), "XEON-DELL7460", "StudentsManagement");
			Connection con = dbConnectionInfo.getCon();
			Statement stat = con.createStatement();
			result = stat.executeUpdate(sql);
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(deleteFlag != "true")
		{
			response.getWriter().append(String.valueOf(result));
		}
		else
		{
			response.getWriter().append(String.valueOf(-1 * result));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
