package me.deager4.guestmaster.database;

public class SponsorVisit 
{
	private String guestFirstName;
	private String guestLastName;
	private FormattedDate date;
	private boolean guestPass;
	
	public SponsorVisit(String guestFirstName, String guestLastName, FormattedDate date, boolean guestPass)
	{
		this.guestFirstName = guestFirstName;
		this.guestLastName = guestLastName;
		this.date = date;
		this.guestPass = guestPass;
	}
	
	public String getGuestName()
	{
		return this.guestFirstName + " " + guestLastName;
	}
	
	public FormattedDate getDate()
	{
		return date;
	}
	
	public boolean getPass()
	{
		return guestPass;
	}
	
	public String toString()
	{
		String payment = "";
		if(this.guestPass == true)
		{
			payment = "Guest Pass";
		}
		else if(this.guestPass == false)
		{
			payment = "Credit";
		}
		return("Guest Name:" + this.guestFirstName + " " + this.guestLastName + ";Date:" + this.date.toString() +";payment:" + payment);
	}
}
