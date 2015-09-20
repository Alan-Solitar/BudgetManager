//Copyright 2015, Alan Solitar, All rights reserved.
package main;
import java.sql.*;
import dataProcessing.PurchaseProcessor;
import sun.security.pkcs11.Secmod.DbMode;
import dataProcessing.ConnectToDatabase;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;

import dataProcessing.ConnectToDatabase;
import dataProcessing.DataProcessor;
import dataProcessing.Purchase;


public class Main
{
	public static void main(String[] args) throws Exception
	{
		ArrayList<Purchase> purchases = new ArrayList<Purchase>(); //Array to hold purchase objects
		//information to connect to MySQL Database
		String user="";
		String pw = "";
		String url = "";
		Connection connection=null;
		try 
		{
			FileReader reader = new FileReader("config.properties"); //File reader to get properties
			Properties properties = new Properties(); 
			properties.load(reader); //load properties from config file
			user = properties.getProperty("user");
			pw = properties.getProperty("pw");
			url = properties.getProperty("url");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(user + " " + pw + " "+ url);
		connection = ConnectToDatabase.DBConnect(connection,url, user, pw);
		DataProcessor processor = new DataProcessor(url, user, pw);
		CachedRowSet crs= processor.importData("select * from purchase;",connection);
		try 
		{
			//ResultSetMetaData rsmd= (ResultSetMetaData)crs.getMetaData();
			while(crs.next())
			{
				Purchase p = new Purchase();
				p.setId(crs.getInt("id"));
				p.setDate(crs.getDate("purchase_date"));
				p.setItem(crs.getString("item"));
				p.setLocation(crs.getString("location"));
				p.setNote(crs.getString("note"));
				p.setPrice(crs.getDouble("price"));
				p.setBalance_before(crs.getDouble("balance_before"));
				p.setBalance_after(crs.getDouble("balance_after"));
				purchases.add(p);
			}
			connection = ConnectToDatabase.DBConnect(connection);
			PurchaseProcessor pProcessor= new PurchaseProcessor(url, user, pw);
			pProcessor.insertion(purchases,connection);
			//pProcessor.insertion(purchases.get(2),connection);
		}	
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		
		for(Purchase i:purchases)
		{
			i.print();
		}
	

		
		
	}
}