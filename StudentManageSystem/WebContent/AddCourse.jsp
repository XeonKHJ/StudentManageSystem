<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="com.StudentManageSystem.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加课程</title>
<%
	Cookie[] cookies = request.getCookies();
	int userNo, pwNo;
	for(userNo = 0; userNo < cookies.length && !cookies[userNo].getName().equals("userId") ; ++userNo);
	for(pwNo = 0; pwNo < cookies.length && !cookies[pwNo].getName().equals("password"); ++pwNo);
	DatabaseConnection databaseConnection = new DatabaseConnection(cookies[userNo].getValue(), cookies[pwNo].getValue(), "XEON-DELL7460", "StudentsManagement");
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
	<%
	Connection con = databaseConnection.getCon();
	Statement stat = con.createStatement();
	ResultSet rs = stat.executeQuery(countCoursesSql);
	int courseCount = rs.getInt("courseCount");
	rs = stat.executeQuery(queryCourses);
	
	%>
	var courseCount = <%=courseCount%>;
	for(var i = 0; i < courseCount; ++i){
        var newTr=tab.insertRow(i + 1);            
        var idTd=newTr.insertCell(0);           
        var nameTd=newTr.insertCell(1);            
        var genderTd=newTr.insertCell(2);            
        idTd.innerHTML = <%=rs.getString("Cno")%>;           
        nameTd.innerHTML = <%=rs.getString("Cname")%>;             
        <%rs.next();%>
	}
	var tab=$("#courses");
}
</script>

</head>
<body>
	<table border="1" id="courses">
		<tr>
			<th>课程编号</th>
			<th>课程名</th>
		</tr>
	</table>
	<form name="addCourseForm" method="get">
		<table>
			<tr>
				<td><label for="courseId">ID:&nbsp;</label></td>
				<td><input name="courseId" tabindex="1" title="请输入课程ID"
					id="courseId" style="width: 105px;" type="text" maxlength="40"
					value=""></td>
			</tr>
			<tr>
				<td><label for="courseName">课程名：&nbsp;</label></td>
				<td><input name="courseName" tabindex="2" id="courseName"
					style="width: 105px;" type="text" maxlength="40" /></td>
			</tr>
			<tr>
				<td colspan="2"><input name="submitBtn" tabindex="9"
					class="blue-button" type="button" onclick="AddCourse()"
					style="margin-left: 7px; margin-right: 7px" value="添加"></td>
			</tr>
			<tr>
				<td><p id="addCourseResult" style="color: red"></p></td>
			</tr>
		</table>
	</form>
</body>
</html>