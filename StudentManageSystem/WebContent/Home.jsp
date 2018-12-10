<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%
Cookie[] cookies = request.getCookies();
String occupation = "";
for(Cookie cookie : cookies)
{
	if(cookie.getName().equals("occupation"))
	{
		occupation = cookie.getValue();
		break;
	}
}
%>

<script>
function WelcomePage()
{
	document.getElementById("maininfo").src = "welcome.jsp";
}
function PersonalInformationPage()
{
	document.getElementById("maininfo").src = "PersonalInformation.jsp";
}
function AddCoursePage()
{
	document.getElementById("maininfo").src = "AddCourse.jsp";
}
function AddStudentPage()
{
	document.getElementById("maininfo").src = "AddStudent.jsp";
}
function ListStudentsPage()
{
	document.getElementById("maininfo").src = "ListStudents";
}
function ListCoursesPage()
{
	document.getElementById("maininfo").src = "ChooseCourses.jsp";
}
</script>
<style>
#header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: 900px;
	width: 15%;
	float: left;
	padding: 5px;
}

#section {
	width: 80%;
	float: left;
	padding: 10px;
}

#footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}

#maininfo{
	width: 100%;
	height: 900px;
	float: left;
	padding: 10px;
}
</style>

</head>
<body>

	<div id="header">
		<a href="Logout" style="float: right; font: 5px" >退出登录</a>
		<a href="ChangePassword.jsp" style="float:right; font:5px">修改密码</a>
		<h1>学生信息管理系统</h1>
	</div>

	<div id="nav">
		<a href="javascript:WelcomePage();">主页</a><br>
		<%if (occupation.equals("student")) {%> 
		<a href="javascript:PersonalInformationPage();" id="personalInformation">学籍信息</a><br>
		<a href="javascript:ListCoursesPage();">课程列表</a><br>
		<%}else if(occupation.equals("admin")) {%>
		<a href="javascript:AddStudentPage();">添加学生</a><br>
		<a href="javascript:AddCoursePage();">添加课程</a><br>
		<a href="javascript:ListStudentsPage();">学生列表</a><br>
		<%} %>
	</div>

	<div id="section">
		<iframe id="maininfo" src="welcome.jsp"></iframe>
	</div>

	<div id="footer">康宏嘉作品</div>
</body>
</html>