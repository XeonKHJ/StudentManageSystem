<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"
	import="com.microsoft.sqlserver.jdbc.SQLServerDataSource"
	import="com.StudentManageSystem.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert tditle here</title>
<style>
body {
	background-color: #0A96E1;
	background-image: -moz-radial-gradient(center, ellipse closest-corner, #29C4FD 20%,
		#0F6CB1 100%);
	background-image: -webkit-radial-gradient(center, ellipse closest-side, #29C4FD 30%,
		#0F6CB1 100%);
	background-image: -ms-radial-gradient(center, ellipse closest-side, #29C4FD 20%, #0F6CB1
		100%);
	background-image: -o-radial-gradient(center, ellipse closest-side, #29C4FD 20%, #0F6CB1
		100%);
}

.logindiv {
	z-index: 1;
	width: 800px;
	height: 360px;
	display: block;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -400px;
	margin-top: -180px;
	border: 1px #106EB6 solid;
	text-align: center;
	background-color: #FFFFFF;
	background-image: -webkit-gradient(linear, top, bottom, from(#D1E3ED),
		to(#FFFFFF));
	background-image: -webkit-linear-gradient(top, #D1E3ED 0%, #FFFFFF 20%);
	background-image: -moz-linear-gradient(top, #D1E3ED 0%, #FFFFFF 20%);
	background-image: -ms-linear-gradient(top, #D1E3ED 0%, #FFFFFF 20%);
	background-image: -o-linear-gradient(top, #D1E3ED 0%, #FFFFFF 20%);
	background-image: linear-gradient(to bottom, #D1E3ED 0%, #FFFFFF 20%);
}

.logintable {
	position: absolute;
	width: 220px;
	height: 164px;
	right: 20px;
	top: 50%;
	margin-top: -82px;
	border: 1px #7DC4DB solid;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-ms-border-radius: 5px;
	-o-border-radius: 5px;
	border-radius: 5px;
}
</style>
</head>

<body>
	<%
	RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp"); 
	dispatcher .forward(request, response); 
		%>
</body>
</html>