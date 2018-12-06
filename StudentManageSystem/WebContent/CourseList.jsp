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
	String countCoursesSql = "SELECT COUNT(*) as CourseCount FROM COURSES";
	String queryCourses = "SELECT * FROM COURSES";
%>
<script>
function AddCourse()
{
	var xmlhttp;
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			result = xmlhttp.responseText;
			//document.getElementById("registerInfo").innerHTML=xmlhttp.responseText;
			if(result == 1){
				document.getElementById("addCourseResult").innerHTML = "添加课程成功";
			}
			else{
				document.getElementById("addCourseResult").innerHTML = "添加失败！"
			}
			RefreshTheCoursesTable();
		}
	}
	var courseId = document.getElementById("courseId").value;
	var courseName = document.getElementById("courseName").value;
	
	var addCourseString = "AddCourse?courseId=" + courseId + 
						 "&courseName=" + courseName;
	
	xmlhttp.open("GET", addCourseString ,true);
	xmlhttp.send();
}

function RefreshTheCoursesTable()
{
	var xmlhttp;
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			//document.getElementById("registerInfo").innerHTML=xmlhttp.responseText;
			document.getElementById("courses").innerHTML = xmlhttp.responseText;
		}
	}
	
	xmlhttp.open("GET", "RefreshCourseList" ,true);
	xmlhttp.send();
}
</script>

</head>
<body>
	<script>RefreshTheCoursesTable();</script>
	<table border="1" id="courses"></table>
</body>
</html>