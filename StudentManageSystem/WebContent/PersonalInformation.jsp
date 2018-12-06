<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="javax.servlet.*" import="com.StudentManageSystem.bean.*" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link id="jquery_theme_link" href="jquery-ui.css?s2j=3.6.1" rel="stylesheet" type="text/css">
<link id="beangle_theme_link" href="beangle-ui,colorbox,chosen.css" rel="stylesheet" type="text/css">
<title>个人信息</title>
	<%
		Cookie[] cookies = request.getCookies();
		int userNo, pwNo;
		for(userNo = 0; userNo < cookies.length && !cookies[userNo].getName().equals("userId") ; ++userNo);
		for(pwNo = 0; pwNo < cookies.length && !cookies[pwNo].getName().equals("password"); ++pwNo);
		DatabaseConnection dbConnection = new DatabaseConnection(cookies[userNo].getValue(), cookies[pwNo].getValue(), "XEON-DELL7460", "StudentsManagement");
		String sql = "SELECT * FROM Students WHERE Sno = '" + "20162430306" + "'";
		Connection con = dbConnection.getCon();
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		rs.next();
		String sNo = rs.getString("Sno");
		String sName = rs.getString("Sname");
		String sSex = rs.getString("Ssex");
		String sBirthday = rs.getString("Sbirthday");
		String sEnterYear = rs.getString("SenterYear");
		String sIconPath = rs.getString("SiconPath");
		String sSchool = rs.getString("Sschool");
		String sMajor = rs.getString("Smajor");
	%>
</head>
<body>
	<div
		class="ajax_container ui-tabs-panel ui-widget-content ui-corner-bottom"
		id="tabPage1" role="tabpanel" aria-expanded="true" aria-hidden="false"
		aria-labelledby="ui-id-1">
		<br>
		<table align="center" class="infoTable" id="studentInfoTb"
			style="width: 95%">
			<tbody>
				<tr>
					<td class="darkColumn"
						style="font-weight: bold; text-align: center" colspan="5">学籍信息</td>
				</tr>
				<tr>
					<td width="25%" class="title" style="width: 18%">学号：</td>
					<td width="25%"><%= sNo%></td>
					<td width="25%" class="title" style="width: 18%">姓名：</td>
					<td><%=sName %></td>
					<td width="11%" id="photoImg" rowspan="5"><img width="80"
						height="110" title="<%=sName %>" alt="<%=sName %>"
						src="<%=sIconPath%>"></td>
				</tr>
				<tr>
					<td class="title" style="width: 18%">性别：</td>
					<td><%=sSex %></td>
				</tr>
				<tr>
					<td class="title" style="width: 18%">年级：</td>
					<td><%= sEnterYear %></td>
				</tr>
				<tr>
					<td class="title" style="width: 18%">院系：</td>
					<td><%=sSchool %></td>
				</tr>
				<tr>
					<td class="title" style="width: 18%">专业：</td>
					<td><%=sMajor %></td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td class="title" style="width: 18%">入校时间：</td>
					<td><%= sEnterYear %></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>