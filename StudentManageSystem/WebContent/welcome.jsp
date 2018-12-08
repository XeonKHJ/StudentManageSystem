<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="javax.servlet.*"
	import="com.StudentManageSystem.bean.*" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎</title>
</head>
<body>
	<%
	Cookie[] cookies = request.getCookies();
	boolean userExist = false;
	DatabaseConnection dbCon = null;
	String userId = "";
	String password = "";
	String occupation = "";
	String name = "管理员";
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
	try{
	if(userExist)
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
		if(occupation.equals("student"))
		{
			ResultSet result = stat.executeQuery("SELECT Sname FROM Students WHERE Sno = '" + userId + "'");
			result.next();
			name = result.getString("Sname"); 
		}%><p><%=name %>，欢迎来到教务系统。
	</p>
	<% 
	}
	else{throw new Exception("没有登陆");}
	}
	catch(Exception e)
	{
		out.println("没有用户登陆！");
	}
	%>
</body>
</html>