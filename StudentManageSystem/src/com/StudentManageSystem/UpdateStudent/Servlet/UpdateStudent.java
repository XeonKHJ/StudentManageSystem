package com.StudentManageSystem.UpdateStudent.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManageSystem.bean.DatabaseConnection;
import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		String id = request.getParameter("Sno");
		String name = request.getParameter("Sname");
		//String password = request.getParameter("password");
		String birthday = request.getParameter("Sbirthday");
		String sex = request.getParameter("Ssex");
		String enterYear = request.getParameter("SenterYear");
		String major = request.getParameter("Smajor");
		String school = request.getParameter("Sschool");
		String btn = request.getParameter("deletebtn");


		try {
			DatabaseConnection dbConnectionInfo = new DatabaseConnection("StudentManagementAdmin", "admin", "XEON-DELL7460", "StudentsManagement");
			Connection dbConnection = dbConnectionInfo.getCon();
			Statement stat = dbConnection.createStatement();
			String sql;
			if(!btn.equals("删除"))
			{
				sql = "UPDATE Students SET Sname = '" + name + "',"
						+ " Ssex = '" + sex + "', Sbirthday = '" + birthday + "', "
						+ "SenterYear = '" + enterYear + "', Sschool = '" + school
						+ "', Smajor = '" + major + "' WHERE Sno = '" + id + "'";
			}
			else
			{
				sql = "Delete From Students Where Sno = '" + id + "'";
			}
			int result = stat.executeUpdate(sql);
			out.println(String.valueOf(result));
		} catch (SQLServerException e) {
			out.println("<p style=\"color:red\">" + e.getMessage() + "</p>");
		} catch (SQLException e) {
			out.println("<p>登陆失败</p>");
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
