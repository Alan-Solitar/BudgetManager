//Copyright 2015, Alan Solitar, All rights reserved.
package dataProcessing;

import java.sql.Connection; 
import java.sql.DriverManager;



//This class contains static methods for database connection
public class ConnectToDatabase
{
	static String url,user,pw;
	
	//returns a connection
	public static Connection DBConnect(Connection c)
	{
		try
		{
		c= DriverManager.getConnection(url,user,pw);
		}
		catch(Exception e)
		{
			System.err.println("Failed to connect to Database.  Please check user credentials.");
		}
	return c;
	}
	//overloading: Use to change database or when no credentials have been given
	public static Connection DBConnect(Connection c, String url, String user, String pw)
	{
		//Set credentials
		ConnectToDatabase.url=url;
		ConnectToDatabase.user=user;
		ConnectToDatabase.pw=pw;
		
		try
		{
		c= DriverManager.getConnection(url,user,pw);
		}
		catch(Exception e)
		{
			System.err.println("Failed to connect to Database.  Please check user credentials.");
		}
	return c;
	}
}
