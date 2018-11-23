package com.StudentManageSystem.Register.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentManageSystem.bean.DatabaseConnection;
import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 * Servlet implementation class RegisterCheck
 */
@WebServlet("/RegisterCheck")
public class RegisterCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String occupation = request.getParameter("occupation");
		String id = request.getParameter("userId");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		try {
			Connection dbConnection;
			DatabaseConnection dbConnectionInfo = new DatabaseConnection("StudentManagementAdmin", "admin", "XEON-DELL7460", "StudentsManagement");
			/*String createUserSql = "USE [master]\r\n" + 
					"GO\r\n" + 
					"CREATE LOGIN [" + id + "] WITH PASSWORD=N'" + password + "', DEFAULT_DATABASE=[StudentsManagement], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF\r\n" + 
					"GO\r\n" + 
					"use [StudentsManagement]\r\n" + 
					"\r\n" + 
					"GO\r\n" + 
					"use [master]\r\n" + 
					"\r\n" + 
					"GO\r\n" + 
					"USE [StudentsManagement]\r\n" + 
					"GO\r\n" + 
					"CREATE USER ["+ id + "] FOR LOGIN [" + id +"]\r\n" + 
					"GO\r\n" + 
					"USE [StudentsManagement]\r\n" + 
					"GO\r\n" + 
					"ALTER ROLE [" + occupation + "] ADD MEMBER [" + id + "]\r\n" + 
					"GO\r\n";*/
			String createPerson = "INSERT INTO " + occupation + "s VALUES ('" + id + "', '" + name + "')";
			dbConnection = dbConnectionInfo.getCon();
			Statement stat = dbConnection.createStatement();
			int result = stat.executeUpdate(createPerson);
		} catch (SQLServerException e) {
			out.println("<p>网站错误</p>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("<p>注册失败</p>");
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
