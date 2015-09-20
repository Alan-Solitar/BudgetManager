//Copyright 2015, Alan Solitar, All rights reserved.
package dataProcessing;
import java.util.Date;

//Object that holds row of the purchase DB
public class Purchase
{
	//Class Variables
	private int id;
	private Date date; 
	private String item;
	private String location;
	private String note;
	private double price;
	private double balance_before;
	private double balance_after;
	//Class Methods
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Date getDate() 
	{
		return date;
	}
	public void setDate(Date date) 
	{
		this.date = date;
	}
	public String getItem()
	{
		return item;
	}
	public void setItem(String item)
	{
		this.item = item;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getNote() 
	{
		return note;
	}
	public void setNote(String note) 
	{
		this.note = note;
	}
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price) 
	{
		this.price = price;
	}
	public double getBalance_before()
	{
		return balance_before;
	}
	public void setBalance_before(double balance_before) 
	{
		this.balance_before = balance_before;
	}
	public double getBalance_after() 
	{
		return balance_after;
	}
	public void setBalance_after(double balance_after)
	{
		this.balance_after = balance_after;
	}
	
	//Print function for testing purposes
	public void print()
	{
		System.out.print(id+ " ");
		System.out.print(item+ " ");
		System.out.print(price+ " ");
		System.out.print(location+ " ");
		System.out.print(date+ " ");
		System.out.print(note+ " ");
		System.out.print(balance_before+ " ");
		System.out.print(balance_after+ " \n");
		;
	}

	
}
