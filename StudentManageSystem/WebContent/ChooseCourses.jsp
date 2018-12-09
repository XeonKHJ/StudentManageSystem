<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"
	import="com.StudentManageSystem.bean.*"%>
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
	function CancelCourse(cId)
	{
		var xmlhttp;
		xmlhttp=new XMLHttpRequest();
		
		xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				result = xmlhttp.responseText;
				if(result == 1)
				{
					document.getElementById("cancel" + cId).innerHTML = "选课";
					document.getElementById("cancel" + cId).href = "javascript:ChooseCourse(" + cId + ")";
					document.getElementById("status" + cId).innerHTML = "未选";
					document.getElementById("result").innerHTML = "成功取消选课";
				}
			}
		}
		var inputParameter = "EditChosenStatus?Cno=" + cId + "&action=Cancel";
		xmlhttp.open("GET",inputParameter,true);
		xmlhttp.send();
	}
	
	function ChooseCourse(cId)
	{
		var xmlhttp;
		xmlhttp=new XMLHttpRequest();
		
		xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				result = xmlhttp.responseText;
				if(result == 1)
				{
					document.getElementById("cancel" + cId).href = "javascript:CancelCourse(" + cId + ")";
					document.getElementById("cancel" + cId).innerHTML = "不选课";
					document.getElementById("status" + cId).innerHTML = "已选";
					document.getElementById("result").innerHTML = "成功选课";
				}
			}
		}
		var inputParameter = "EditChosenStatus?Cno=" + cId + "&action=Choose";
		xmlhttp.open("GET",inputParameter,true);
		xmlhttp.send();
	}
</script>
</head>
<body>
	<script></script>
	<table border="1" id="notChosenCourses">
		<tr>
			<th>课程</th>
			<th>状态</th>
			<th>操作</th>
			<th>分数</th></tr>
	<%
	String cNo = "";
	while(allCoursesRs.next())
	{
		cNo = allCoursesRs.getString("Cno");
		String cChosen = "<p id=\"status" + cNo + "\">未选</p>";
		String operation = "ChooseCourse";
		String cEdit="选课";
		String cName = allCoursesRs.getString("Cname");
		String score = "";
		while(chosenCoursesRs.next())
		{
			if(cNo.equals(chosenCoursesRs.getString("Cno")))
			{
				cChosen = "<p id=\"status" + cNo + "\">已选</p>";
				cEdit = "不选课";
				operation="CancelCourse";
				score = chosenCoursesRs.getString("Score");
			}
		}
		chosenCoursesRs.beforeFirst();
	%>
		<tr>
			<td><%=cName %></td>
			<td><%=cChosen %></td>
			<td><a href="javascript:<%=operation %>(&quot;<%=cNo%>&quot;)" id="cancel<%=cNo %>"><%=cEdit %></a></td>
			<td><%=score %></td>
		</tr>
	<%
	}
	%>
	</table>
	<p style="font-color: red" id="result">
	<p>
</body>
</html>