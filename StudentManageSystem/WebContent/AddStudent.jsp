<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<script>
	function Register()
	{
		var form = document.getElementById("registerForm");
		var xmlhttp;
		xmlhttp=new XMLHttpRequest();
		document.getElementById("registerInfo").innerHTML=xmlhttp.responseText;
		xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				if(xmlhttp.responseText == 1)
				{
					document.getElementById("registerInfo").innerHTML="注册成功";
				}
			}
		}
		var userId = document.getElementById("userId").value;
		var name = document.getElementById("name").value;
		var birthday = document.getElementById("birthday").value;
		var enterYear = document.getElementById("enterYear").value;
		var major = document.getElementById("major").value;
		var school = document.getElementById("school").value;
		
		var registerString = "RegisterCheck?userId=" + userId + 
							 "&name=" + name +
							 "&birthday=" + birthday +
							 "&enterYear=" + enterYear + 
							 "&major=" + major + 
							 "&school=" + school;
		
		xmlhttp.open("GET", registerString ,true);
		xmlhttp.send();
	}
	</script>
<meta charset="UTF-8">
<title>注册</title>
</head>

<body>
	<form name="registerForm" method="get">
		<table>
			<tr>
				<td><label for="userId">ID：&nbsp;</label></td>
				<td><input name="userId" tabindex="1" title="请输就用户名"
					id="userId" style="width: 105px;" type="text" maxlength="40"
					value=""></td>
			</tr>
			<tr>
				<td><label for="name">姓名：&nbsp;</label></td>
				<td><input name="name" tabindex="3" id="name"
					style="width: 105px;" type="text" maxlength="40" /></td>
			</tr>
			<tr>
				<td><label for="sex">性别：&nbsp;</label></td>
				<td><input type="radio" name="sex" value="male" checked
					tabindex="4">男 <br> <input type="radio" name="sex"
					value="female" tabindex="5">女</td>

			</tr>
			<tr>
				<td><label for="birthday">生日：&nbsp;</label></td>
				<td><input name="birthday" tabindex="7" id="birthday"
					style="width: 105px;" type="date" maxlength="40" /></td>
			</tr>
			<tr>
				<td><label for="enterYear">入学年份：&nbsp;</label></td>
				<td><input name="enterYear" tabindex="8" id="enterYear"
					style="width: 105px;" type="text" maxlength="40" /></td>
			</tr>
						<tr>
				<td><label for="school">学院：&nbsp;</label></td>
				<td><input name="school" tabindex="9" id="school"
					style="width: 105px;" type="text" maxlength="40" /></td>
			</tr>
						<tr>
				<td><label for="major">专业：&nbsp;</label></td>
				<td><input name="major" tabindex="10" id="major"
					style="width: 105px;" type="text" maxlength="40" /></td>
			</tr>
			<tr>
				<td colspan="2"><input name="submitBtn" tabindex="9"
					class="blue-button" type="button" onclick="Register()"
					style="margin-left: 7px; margin-right: 7px" value="注册"></td>
			</tr>
		</table>
	</form>
	<div>
		<p id="registerInfo"></p>
	</div>
</body>

</html>