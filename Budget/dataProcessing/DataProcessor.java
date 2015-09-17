//Copyright 2015, Alan Solitar, All rights reserved.
package dataProcessing;
import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class DataProcessor 
{	
	private CachedRowSet crs;
	private Connection connection; //Solves the issue of trying to return a closed Resultset
	private Statement statement;
	private ResultSet results;
 
	//Object to connect to MySQL DB
	public DataProcessor(String url, String user, String pw) 
	{
		try
		{
			connection = DriverManager.getConnection(url, user, pw); //connect to mySQL	
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//Retrieve data from database;
	public CachedRowSet importData(String query)
	{
		
		
		try 
		{
			statement= connection.createStatement();
			results= statement.executeQuery(query);
			crs= new CachedRowSetImpl();
			crs.populate(results);
		
			return crs;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		//close unused statement and resultset.
		finally 
		{
			try{if(statement!=null)statement.close();} catch(Exception e) {e.printStackTrace();};
			try{if(results!=null)results.close();} catch(Exception e) {e.printStackTrace();};
		}
			return crs;
	}
		/*
		 Functions to connect to or close connection to DB
		 Will determine later whether multiple connections/closes
		 are necessary.
		 */
		public void connectToDB(String url,String user,String pw)
		{
			try 
			{
			connection = DriverManager.getConnection(url, user, pw);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		public void closeDB()
		{
			try 
			{
				if(connection!=null) { connection.close();}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}

	

}
