//Copyright 2015, Alan Solitar, All rights reserved.
package dataProcessing;
import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class DataProcessor 
{	
	private CachedRowSet crs; //solves the problem of returning a closed resultset
	private Statement statement;
	private ResultSet results;
 
	//Object to connect to MySQL DB
	public DataProcessor(String url, String user, String pw) 
	{
		try
		{
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Retrieve data from database;
	public CachedRowSet importData(String query,Connection c)
	{
		
		
		try 
		{
			statement= c.createStatement();
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
			try{if(c!=null)c.close();} catch(Exception e) {e.printStackTrace();};
			
		}
			return crs;
	}
		
		/*
		 Functions to connect to or close connection to DB
		 Will determine later whether multiple connections/closes
		 are necessary.
		 */
	
	

	

}
