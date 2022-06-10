package com.hybridFramework.testCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TC_DBTest {
	
	
public static void main(String arg[]) throws SQLException, ClassNotFoundException
{
	String name=null;
	String designation=null;
	Connection con=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-UJQAFN8;databaseName=Test","sa","1234");
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("Select * from Employee");
	while(rs.next())
	{
		name=rs.getString("Name");
		designation=rs.getString("Designation");
		System.out.println(name);
		System.out.println(designation);
		
	}
	
	
	
}
}
