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
		try {
			Connection dbConnection;
			DatabaseConnection dbConnectionInfo = new DatabaseConnection("StudentManageAdmin", "admin", "XEON-DELL7460", "StudentsManagement");
			String createUserSql = "USE [master]\r\n" + 
					"GO\r\n" + 
					"CREATE LOGIN [20162430307] WITH PASSWORD=N'0978286092', DEFAULT_DATABASE=[StudentsManagement], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF\r\n" + 
					"GO\r\n" + 
					"use [StudentsManagement]\r\n" + 
					"\r\n" + 
					"GO\r\n" + 
					"use [master]\r\n" + 
					"\r\n" + 
					"GO\r\n" + 
					"USE [StudentsManagement]\r\n" + 
					"GO\r\n" + 
					"CREATE USER [20162430307] FOR LOGIN [20162430307]\r\n" + 
					"GO\r\n" + 
					"USE [StudentsManagement]\r\n" + 
					"GO\r\n" + 
					"ALTER ROLE [Student] ADD MEMBER [20162430307]\r\n" + 
					"GO\r\n";
			dbConnection = dbConnectionInfo.getCon();
			Statement stat = dbConnection.createStatement();
			stat.executeQuery(createUserSql);
		} catch (SQLServerException e) {
			out.println("<p>账号密码错误</p>");
		} catch (SQLException e) {
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
