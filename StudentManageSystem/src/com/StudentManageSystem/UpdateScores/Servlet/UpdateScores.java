package com.StudentManageSystem.UpdateScores.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManageSystem.bean.DatabaseConnection;
import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 * Servlet implementation class UpdateScores
 */
@WebServlet("/UpdateScores")
public class UpdateScores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateScores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
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
		
		PrintWriter out = response.getWriter();
		String cNo = request.getParameter("Cno");

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
			Statement statUpdated = con.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM Study WHERE Cno = '" + cNo + "'" );
			while(rs.next())
			{
				String sNo = rs.getString("Sno");
				String score = request.getParameter(sNo);
				String updateSQL = "UPDATE Study SET Score = " + score + " WHERE Cno = '" + cNo + "' AND Sno = '" + sNo + "'";
				statUpdated.executeUpdate(updateSQL);
			}
		} catch (SQLServerException e) {
			out.println("<p style=\"color:red\">" + e.getMessage() + "</p>");
		} catch (SQLException e) {
			out.println("<p>登陆失败</p>");
			e.printStackTrace();
		}
		response.sendRedirect("InputScores.jsp?Cno=" + cNo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
