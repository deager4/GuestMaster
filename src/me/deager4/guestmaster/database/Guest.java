package me.deager4.guestmaster.database;

import java.io.File;
import java.util.ArrayList;

import me.deager4.guestmaster.GuestMaster;

public class Guest 
{
	private ArrayList<Visit> visits = new ArrayList<Visit>();
	private String firstName;
	private String lastName;
	private boolean isOverLimit;
	private FormattedDate birthDate;
	
	public Guest(String firstName, String lastName, boolean isOverLimit, FormattedDate birthDate)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.isOverLimit = isOverLimit;
		this.birthDate = birthDate;
	}
	
	public void setOverLimit(boolean boo)
	{
		this.isOverLimit = boo;
	}
	
	public ArrayList<Visit> getVisits()
	{
		return this.visits;
	}
	
	public String getName()
	{
		return this.firstName + " " + this.lastName;
	}
	
	public FormattedDate getBirthDate()
	{
		return this.birthDate;
	}
	
	public void addVisit(Visit visit)
	{
		this.visits.add(visit);
	}
	
	public void removeVisit(Visit visit)
	{
		this.visits.remove(visit);
	}
	
	public boolean isOverLimit()
	{
		return this.isOverLimit;
	}
	
	public String toString()
	{
		return this.firstName + " " + this.lastName + "; Visits: " + visits.size();
	}
}
