<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="com.StudentManageSystem.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加课程</title>
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
	String allCoursesSql = "SELECT * FROM COURSES";
	Connection con = dbCon.getCon();
	Statement chosenCoursesStat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);;
	Statement allCoursesStat = con.createStatement();
	ResultSet chosenCoursesRs = chosenCoursesStat.executeQuery(chosenCoursesSql);
	ResultSet allCoursesRs = allCoursesStat.executeQuery(allCoursesSql);
%>

<script>
function CancelCourse()
{
	
}
</script>
</head>
<body>
	<script>RefreshTheCoursesTable();</script>
	<table border="1" id="notChosenCourses">
	<tr><th>课程</th><th>状态</th><th>操作</th>
	<%
	while(allCoursesRs.next())
	{
		String cNo = allCoursesRs.getString("Cno");
		String cChosen = "<p id=\"status" + cNo + "\">未选</p>";
		String cEdit = "<a href=javascript:ChooseCourse() id=\"cancel"+cNo+ "\">选课</a>";
		String cName = allCoursesRs.getString("Cname");
		while(chosenCoursesRs.next())
		{
			if(cNo.equals(chosenCoursesRs.getString("Cno")))
			{
				cChosen = "<p id=\"status" + cNo + "\">已选</p>";
				cEdit = "<a href=javascript:CancelCourse() id=\"cancel"+cNo+ "\">不选课</a>";
			}
		}
		chosenCoursesRs.beforeFirst();
	%>
	<tr><td><%=cName %></td><td><%=cChosen %></td><td><%=cEdit %></td>
	<%
	}
	%>
	</table>
</body>
</html>