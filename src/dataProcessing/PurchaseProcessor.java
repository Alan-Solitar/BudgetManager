//Copyright 2015, Alan Solitar, All rights reserved.
package dataProcessing;
import java.sql.*; 
import java.util.ArrayList;

import com.sun.xml.internal.ws.Closeable;

import dataProcessing.Purchase;
public class PurchaseProcessor
{
	private String sql= "INSERT INTO PURCHASE (item,price,location,purchase_date,note,balance_before,balance_after) values(?,?,?,?,?,?,?)";
	private String url, user, pw;
	public PurchaseProcessor(String url, String user, String pw)
	{

	}
	public void insertion(Purchase p, Connection c) 
	{
		try 
		{
		PreparedStatement preparedStatement= c.prepareStatement(sql);
		preparedStatement.setString(1,p.getItem());
		preparedStatement.setDouble(2, p.getPrice());;
		preparedStatement.setString(3,p.getLocation());
		preparedStatement.setDate(4,(Date)p.getDate()); 
		preparedStatement.setString(5,p.getNote());
		preparedStatement.setDouble(6,p.getBalance_before());
		preparedStatement.setDouble(7,p.getBalance_after());
		preparedStatement.executeUpdate();
		preparedStatement.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("error");
		}
		
		
		
	}
	
	public void insertion(ArrayList<Purchase> purchases, Connection c)
	{
		for(Purchase p: purchases)
		{
			insertion(p, c);
			
		}
		try
		{
			if(c!=null)
				c.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}