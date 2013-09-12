package me.deager4.guestmaster.database;

public class Visit 
{
	private String sponsorMemberFirstName;
	private String sponsorMemberLastName;
	private String guestFirstName;
	private String guestLastName;
	private FormattedDate date;
	public Visit(String sponsorMemberFirstName, String sponsorMemberLastName, FormattedDate date)
	{
		this.sponsorMemberFirstName = sponsorMemberFirstName;
		this.sponsorMemberLastName = sponsorMemberLastName;
		this.date = date;
	}
	
	public String getSponsorMemberFirstName()
	{
		return this.sponsorMemberFirstName;
	}
	
	public String getSponsorMemberLastName()
	{
		return this.sponsorMemberLastName;
	}
	
	public FormattedDate getDate()
	{
		return this.date;
	}
	
	public String toOutputString()
	{
		return "Sponsor Name:" + this.sponsorMemberFirstName + " " + this.sponsorMemberLastName + ";Date:" + date.toString();
	}
	
	public String toString()
	{
		return "Sponsor Name: " + this.sponsorMemberFirstName + " " + this.sponsorMemberLastName + "; Date: " + date.toString();
	}
}
