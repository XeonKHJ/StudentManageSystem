package com.StudentManageSystem.bean;

import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class DatabaseConnection 
{
	private Connection con;
	public DatabaseConnection (String user, String password, String serverName, String databaseName) throws SQLServerException
	{
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser(user);
		ds.setPassword(password);
		ds.setServerName(serverName);
		ds.setDatabaseName(databaseName);
		con = ds.getConnection();
	}
	public Connection getCon() {
		return con;
	}
}
