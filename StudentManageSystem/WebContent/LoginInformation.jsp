<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.*" import="com.StudentManageSystem.bean.*"%>
<%
	Cookie[] cookies = request.getCookies();
	boolean userExist = false;
	DatabaseConnection dbCon = null;
	String userId = "";
	String password = "";
	String occupation = "";
	Student student = new Student("");
	for(Cookie cookie : cookies)
	{
		if(cookie.getName().equals("userId"))
		{
			userId = cookie.getValue();
			userExist = true;
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
	if(userExist)
	{
		if(occupation.equals("student"))
		{
			dbCon = new DatabaseConnection("StudentManagementStudent", "1234", "XEON-DELL7460", "StudentsManagement");
			student = new Student(userId);
		}
		else if(occupation.equals("admin"))
		{
			dbCon = new DatabaseConnection(userId, password, "XEON-DELL7460", "StudentsManagement");
		}
	}
%>