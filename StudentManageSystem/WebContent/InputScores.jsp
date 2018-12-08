<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="javax.servlet.*"
	import="com.StudentManageSystem.bean.*" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link id="jquery_theme_link" href="jquery-ui.css?s2j=3.6.1"
	rel="stylesheet" type="text/css">
<link id="beangle_theme_link" href="beangle-ui,colorbox,chosen.css"
	rel="stylesheet" type="text/css">
<title>个人信息</title>
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
	
	String cNo = request.getParameter("Cno");	
	Connection con = dbCon.getCon();
	Statement stat = con.createStatement();
	String studySQL = "SELECT * FROM Study WHERE Cno = '" + cNo + "'";
	ResultSet studyRs = stat.executeQuery(studySQL);
	Statement statStudent = con.createStatement();
	String sNo = "";
	%>
</head>
<body>
	<form action="UpdateScores">
		<table border="1">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>分数</th>
			</tr>
			<%while (studyRs.next()) {%>
			<tr>
				<%
				sNo = studyRs.getString("Sno");
				int score = studyRs.getInt("score");
				String scoreS = String.valueOf(score);
				String studentsSql = "SELECT Sname FROM Students WHERE Sno = '" + sNo + "'";
				ResultSet studentsRs = statStudent.executeQuery(studentsSql);
				studentsRs.next();
				String sName = studentsRs.getString("Sname");
			%>
				<td><%=sNo %></td>
				<td><%=sName %></td>
				<td><input name="<%= sNo %>" type="text" value=<%=scoreS %> /></td>
			</tr>
			<%} %>
		</table>
		<input name="Cno" type="hidden" value=<%= cNo %> /> <input
			name="inputScore" type="submit" value="提交" />
	</form>
</body>
</html>