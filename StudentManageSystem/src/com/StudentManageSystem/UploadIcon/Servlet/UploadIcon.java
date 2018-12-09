package com.StudentManageSystem.UploadIcon.Servlet;

import java.io.File;
import java.util.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.StudentManageSystem.bean.DatabaseConnection;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadIcon
 */
@WebServlet("/UploadIcon")
public class UploadIcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext sc;
	private String savePath;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadIcon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		Cookie[] cookies = request.getCookies();
		DatabaseConnection dbCon = null;
		String userId = "";
		String password = "";
		String occupation = "";
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
			String changeIconFileSql = "UPDATE Students SET SiconPath = 'StudentIcons\\" + userId + ".jpg' WHERE Sno = '" + userId + "'";
			int result = stat.executeUpdate(changeIconFileSql);
			
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Configure a repository (to ensure a secure temp location is used)
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			String folderPath = getServletContext().getRealPath("/StudentIcons");
			File folder = new File(folderPath);
			if(!folder.exists())
			{
				folder.mkdir();
			}
			while(iter.hasNext())
			{
				FileItem item = iter.next();
			    if (!item.isFormField())
			    {    	
			    	String filepath = getServletContext().getRealPath("/StudentIcons");
					File uploadedFile = new File(filepath + "\\" + userId + ".jpg");
			    	uploadedFile.createNewFile();
			    	item.write(uploadedFile);
			    }    	
			}
		} catch (SQLServerException e) {
			out.println("<p style=\"color:red\">" + e.getMessage() + "</p>");
		} catch (SQLException e) {
			out.println("<p>登陆失败</p>");
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
