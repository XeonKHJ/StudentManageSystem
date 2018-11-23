<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<script>
		function register()
		{
			//调用Register.java中的类完成该功能。
		}
		//待完成：注册功能
	</script>
<meta charset="UTF-8">
<title>注册</title>
</head>

<body>
	<form action="RegisterCheck" name="registerForm" method="post">
		<table>
			<tr>
				<td><label for="userId">ID:&nbsp;</label></td>
				<td><input name="userId" tabindex="1" title="请输就用户名"
					id="userId" style="width: 105px;" type="text" maxlength="40"
					value=""></td>
			</tr>
			<tr>
				<td><label for="password">密 码:&nbsp;</label></td>
				<td><input name="password" tabindex="2" id="password"
					style="width: 105px;" type="password" maxlength="40" /></td>
			</tr>
			<tr>
				<td><label for="name">姓名:&nbsp;</label></td>
				<td><input name="name" tabindex="3" id="name"
					style="width: 105px;" type="text" maxlength="40" /></td>
			</tr>
			<tr>
				<td><label for="sex">性别:&nbsp;</label></td>
				<td><input type="radio" name="sex" value="male" checked tabindex="4">男
					<br> <input type="radio" name="sex" value="female" tabindex="5">女</td>

			</tr>
			<tr>
				<td><label for="occupation">类型:&nbsp;</label></td>
				<td><select name="occupation" tabindex="6">
						<option value="student">学生</option>
						<option value="teacher">老师</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="birthday">生日:&nbsp;</label></td>
				<td><input name="birthday" tabindex="7" id="birthday"
					style="width: 105px;" type="date" maxlength="40" /></td>
			</tr>
			<tr>
				<td><label for="enterYear">入学年份：&nbsp;</label></td>
				<td><input name="enterYear" tabindex="8" id="enterYear"
					style="width: 105px;" type="text" maxlength="40" /></td>
			</tr>
			<tr>
				<td colspan="2"><input name="submitBtn" tabindex="9"
					class="blue-button" type="submit" onclick=""
					style="margin-left: 7px; margin-right: 7px" value="注册"></td>
			</tr>
		</table>
	</form>
</body>

</html>