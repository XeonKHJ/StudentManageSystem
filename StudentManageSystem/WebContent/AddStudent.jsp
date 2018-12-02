<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"
	import="com.StudentManageSystem.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加学生</title>
<%
	Cookie[] cookies = request.getCookies();
	int userNo, pwNo;
	for(userNo = 0; userNo < cookies.length && !cookies[userNo].getName().equals("userId") ; ++userNo);
	for(pwNo = 0; pwNo < cookies.length && !cookies[pwNo].getName().equals("password"); ++pwNo);
	DatabaseConnection databaseConnection = new DatabaseConnection(cookies[userNo].getValue(), cookies[pwNo].getValue(), "XEON-DELL7460", "StudentsManagement");
	String countStudentsSql = "SELECT COUNT(*) as StudentCount FROM COURSES";
	String queryStudents = "SELECT * FROM COURSES";
%>
<script>
function AddStudent()
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
				document.getElementById("addStudentResult").innerHTML = "添加学生成功";
			}
			else{
				document.getElementById("addStudentResult").innerHTML = "添加失败！"
			}
			RefreshTheStudentsTable();
		}
	}
	var studentId = document.getElementById("studentId").value;
	var studentName = document.getElementById("studentName").value;
	var enterYear = document.getElementById("enterYear").value;
	
	
	var addStudentString = "AddStudent?studentId=" + studentId + 
						 "&studentName=" + studentName;
	
	xmlhttp.open("GET", addStudentString ,true);
	xmlhttp.send();
}

function RefreshTheStudentsTable()
{
	var xmlhttp;
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			//document.getElementById("registerInfo").innerHTML=xmlhttp.responseText;
			document.getElementById("students").innerHTML = xmlhttp.responseText;
		}
	}
	
	xmlhttp.open("GET", "RefreshStudents" ,true);
	xmlhttp.send();
}

function UploadIcon()
{
	 
}
</script>

</head>
<body>
	<script>RefreshTheStudentsTable();</script>
	<table border="1" id="students"></table>
	<form name="addStudentForm" method="get">
		<table>
			<tr>
				<td><label for="studentId">学生编号:&nbsp;</label></td>
				<td><input name="studentId" tabindex="1" title="请输入学生ID"
					id="studentId" style="width: 105px;" type="text" maxlength="40"
					value=""></td>
				<td><label for="studentName">学生名：&nbsp;</label></td>
				<td><input name="studentName" tabindex="2" id="studentName"
					style="width: 105px;" type="text" maxlength="40" /></td>
				<td><label for="birthday">生日:&nbsp;</label></td>
				<td><input name="birthday" tabindex="3" id="birthday"
					style="width: 105px;" type="date" maxlength="40" /></td>
				<td><label for="enterYear">入学年份：&nbsp;</label></td>
				<td><input name="enterYear" tabindex="4" id="enterYear"
					style="width: 105px;" type="text" maxlength="40" /></td>
				<td><label for="enterYear">头像：&nbsp;</label></td>
				<td colspan="2"><input name="submitBtn" tabindex="5"
					class="blue-button" type="file"
					style="margin-left: 7px; margin-right: 7px" value="上传头像"></td>
				<td colspan="2"><input name="submitBtn" tabindex="6"
					class="blue-button" type="button" onclick="UploadIcon()"
					style="margin-left: 7px; margin-right: 7px" value="上传"></td>
				<td colspan="2"><input name="submitBtn" tabindex="6"
					class="blue-button" type="button" onclick="AddStudent()"
					style="margin-left: 7px; margin-right: 7px" value="添加"></td>
			</tr>
			<tr>
				<td><p id="addStudentResult" style="color: red"></p></td>
			</tr>
		</table>
	</form>
</body>
</html>