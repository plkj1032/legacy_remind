package com.codemate.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/member";
		
		String user = "root";
		String password = "mysql00";
		
		return DriverManager.getConnection(url,user,password);
	}
}
