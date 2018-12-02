<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.StudentManageSystem.bean.*"
	import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息管理系统：登陆界面</title>
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
		<script>
		function loginCheck()
		{
			var xmlhttp;
			xmlhttp=new XMLHttpRequest();

			var userId = document.getElementById("userId").value;
			var password = document.getElementById("password").value;
			var result;
			
			xmlhttp.onreadystatechange=function()
			{
				if (xmlhttp.readyState==4 && xmlhttp.status==200)
				{
					result = xmlhttp.responseText;
					
					if(result == 1){
						document.getElementById("LoginFaild").innerHTML="登陆成功";
						window.location.href = "Home.jsp";
						}
					else{
						document.getElementById("LoginFaild").innerHTML="登陆失败，请检查用户名和密码！";
					}
				}
			}
			var inputParameter = "Login?userId=" + userId + "&password=" + password;
			xmlhttp.open("GET",inputParameter,true);
			xmlhttp.send();
		}
		</script>
</head>
<body>
	<div class="logindiv">
		<div
			style="position: absolute; top: 15px; left: 22px; width: 301px; height: 65px;">
			<h1>学生信息管理系统</h1>
		</div>
		<form name="loginForm" method="post">
			<table class="logintable">
				<tbody>
					<tr>
						<td style="text-align: center; color: red;" colspan="2"></td>
					</tr>
					<tr>
						<td><label for="userId">用户名:&nbsp;</label></td>
						<td><input name="userId" tabindex="1" title="请输就用户名"
							id="userId" style="width: 105px;" type="text" maxlength="40"
							value=""></td>
					</tr>
					<tr>
						<td><label for="password">密 码:&nbsp;</label></td>
						<td><input name="password" tabindex="2" id="password"
							style="width: 105px;" type="password" maxlength="40" /> <input
							name="encodedPassword" type="hidden" value="" /></td>
					</tr>
					<tr>
						<td></td>
						<td><a onclick="return bg.Go(this,null)"
							href="/eams/resetPassword.action">忘记密码?</a></td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td colspan="2"><input name="submitBtn" tabindex="6"
							class="blue-button" type="button" onclick="loginCheck()"
							style="margin-left: 7px; margin-right: 7px" value="登录"></td>
					</tr>
										<tr>
						<td colspan="2"><p id="LoginFaild" style="color:red"></p></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>