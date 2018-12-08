package com.StudentManageSystem.RefreshCourses;

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
 * Servlet implementation class RefreshCourses
 */
@WebServlet("/RefreshCourses")
public class RefreshCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置该Servlet页面编码
		response.setContentType("text/html;charset=UTF-8");

		Cookie[] cookies = request.getCookies();
		
		//登陆数据库
		int userNo, pwNo;
		for(userNo = 0; userNo < cookies.length && !cookies[userNo].getName().equals("userId") ; ++userNo);
		for(pwNo = 0; pwNo < cookies.length && !cookies[pwNo].getName().equals("password"); ++pwNo);
		DatabaseConnection databaseConnection;
		
		//打印表头
		response.getWriter().println("		<tr>\r\n" + 
				"			<th>课程编号</th>\r\n" + 
				"			<th>课程名</th>\r\n" + 
				"		</tr>");
		try {
			databaseConnection = new DatabaseConnection(cookies[userNo].getValue(), cookies[pwNo].getValue(), "XEON-DELL7460", "StudentsManagement");
			String queryCourses = "SELECT * FROM COURSES";
			Connection con = databaseConnection.getCon();
			Statement stat = con.createStatement();
			ResultSet rs;
			for(rs = stat.executeQuery(queryCourses); rs.next(); )
			{
				response.getWriter().println("<tr><td><a href=\"inputScores.jsp?Cno=" + rs.getString("Cno") + "\"/>"+rs.getString("Cno")+"</td><td>"+rs.getString("Cname")+"</td></tr>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
