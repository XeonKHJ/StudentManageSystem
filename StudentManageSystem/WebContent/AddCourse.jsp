<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加课程</title>
<script>
function AddCourse()
{
	var xmlhttp;
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			//document.getElementById("registerInfo").innerHTML=xmlhttp.responseText;
		}
	}
	var courseId = document.getElementById("courseId").value;
	var courseName = document.getElementById("courseName").value;
	
	var addCourseString = "AddCourse?courseId=" + courseId + 
						 "&courseName=" + courseName;
	
	xmlhttp.open("GET", addCourseString ,true);
	xmlhttp.send();
}
</script>

</head>
<body>
	<table>
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
		</table>
	</form>
</body>
</html>