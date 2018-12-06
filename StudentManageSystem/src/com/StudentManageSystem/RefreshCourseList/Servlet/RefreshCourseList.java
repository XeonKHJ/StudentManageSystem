package com.StudentManageSystem.RefreshCourseList.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManageSystem.bean.DatabaseConnection;

/**
 * Servlet implementation class RefreshCourseList
 */
@WebServlet("/RefreshCourseList")
public class RefreshCourseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshCourseList() {
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
		String name = "";
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
		
			//打印表头
			response.getWriter().println("		<table border=\"1\"><tr>\r\n" + 
					"			<th>课程编号</th>\r\n" + 
					"			<th>课程名</th>\r\n" + 
					"			<th>分数</th>\r\n" + 
					"		</tr>");
		
			String queryCourses = "SELECT * FROM Study WHERE Sno = '" + userId + "'";
			ResultSet rs;
			for(rs = stat.executeQuery(queryCourses); rs.next(); )
			{
				String courseId = rs.getString(2);
				String score = rs.getString(3);
				ResultSet rs1 = stat.executeQuery("SELECT Cname FROM Courses WHERE Cno = '" + courseId + "'");
				rs1.next();
				String Cname = rs1.getString(1);
				response.getWriter().println("<tr><td>"+courseId+"</td><td>"+Cname+"</td><td>" + score + "</td></tr>");
			}
			response.getWriter().println("</table>");
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
