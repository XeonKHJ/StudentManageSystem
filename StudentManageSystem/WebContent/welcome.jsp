<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.*" import="com.StudentManageSystem.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		
	</script>
	<%
		Cookie[] cookies = request.getCookies();
		int userNo, pwNo;
		for(userNo = 0; userNo < cookies.length && !cookies[userNo].getName().equals("userId") ; ++userNo);
		for(pwNo = 0; pwNo < cookies.length && !cookies[pwNo].getName().equals("password"); ++pwNo);
		DatabaseConnection con = new DatabaseConnection(cookies[userNo].getValue(), cookies[pwNo].getValue(), "XEON-DELL7460", "StudentsManagement");
	%>
	<p><%= cookies[userNo].getName() %>，欢迎来到教务系统。</p>
</body>
</html>