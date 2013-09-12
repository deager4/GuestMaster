package me.deager4.guestmaster.database;

public class FormattedDate 
{
	private int day;
	private int month;
	private int year;
	public FormattedDate(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay()
	{
		return this.day;
	}
	
	public int getMonth()
	{
		return this.month;
	}
	
	public int getYear()
	{
		return this.year;
	}
	
	public String toString()
	{
		return this.month + "/" + this.day + "/" + this.year;
	}
}
