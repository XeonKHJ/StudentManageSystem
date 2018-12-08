package com.StudentManageSystem.ListStudents.Servlet;

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
 * Servlet implementation class ListStudents
 */
@WebServlet("/ListStudents")
public class ListStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudents() {
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
					"			<th>姓名</th>\r\n" + 
					"			<th>学号</th>\r\n" + 
					"			<th>性别</th>\r\n" + 
					"		</tr>");
		
			String queryCourses = "SELECT * FROM Students";
			ResultSet rs = stat.executeQuery(queryCourses);
			while(rs.next())
			{
				response.getWriter().println("<tr><td><a href=\"EditStudent.jsp?Sno=" + rs.getString(1) + "\">"+rs.getString(1)+"</a></td><td>"+rs.getString(2)+"</td><td>" + rs.getString(3) + "</td></tr>");
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
