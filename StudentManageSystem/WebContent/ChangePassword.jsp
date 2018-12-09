<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.StudentManageSystem.bean.*" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<%
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
	if(occupation.equals("student"))
	{
		dbCon = new DatabaseConnection("StudentManagementStudent", "1234", "XEON-DELL7460", "StudentsManagement");
	}
	else if(occupation.equals("admin"))
	{
		dbCon = new DatabaseConnection(userId, password, "XEON-DELL7460", "StudentsManagement");
	}
	String chosenCoursesSql = "SELECT * FROM Study WHERE Sno = '" + userId + "'";
	Connection con = dbCon.getCon();
	Statement stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
%>
</head>
<body>
	<form id="changePassword" action="ChangePassword">
		<p>原密码：</p><input type="password" name="orignalPw"/>
		<br/>
		<p>新密码：</p><input type="password" name="newPw"/>
		<br/>
		<p>重复新密码：</p><input type="password" name="repeatNewPw"/>
		<br/>
		<input type="submit" value="修改"/>
	</form>
</body>
</html>