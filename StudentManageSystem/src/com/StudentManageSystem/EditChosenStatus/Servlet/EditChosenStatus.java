package com.StudentManageSystem.EditChosenStatus.Servlet;

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
 * Servlet implementation class EditChosenStatus
 */
@WebServlet("/EditChosenStatus")
public class EditChosenStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditChosenStatus() {
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
		String cNo = request.getParameter("Cno");
		String action = request.getParameter("action");
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
			if(action.equals("Cancel"))
			{
				String cancelSql = "DELETE FROM Study WHERE Cno = '" + cNo + "' AND Sno = '" + userId + "'";
				int result = stat.executeUpdate(cancelSql);
				response.getWriter().println(String.valueOf(result));
			}
			else if(action.equals("Choose"))
			{
				String chooseSql = "INSERT INTO Study (Sno, Cno) VALUES ('" + userId + "', '" + cNo + "')";
				int result = stat.executeUpdate(chooseSql);
				response.getWriter().println(String.valueOf(result));
			}
			
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
