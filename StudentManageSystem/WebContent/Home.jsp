<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script>
function WelcomePage()
{
	document.getElementById("maininfo").src = "welcome.jsp";
}
function PersonalInformationPage()
{
	document.getElementById("maininfo").src = "PersonalInfomation.jsp";
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
		<h1>学生信息管理系统</h1>
	</div>

	<div id="nav">
		<a href="javascript:WelcomePage();">主页</a><br> <a href="javascript:PersonalInformationPage();">学籍信息</a><br><a>课程列表</a><br>
	</div>

	<div id="section">
		<iframe id="maininfo" src="welcome.jsp"></iframe>
	</div>

	<div id="footer">康宏嘉作品</div>

</body>
</html>