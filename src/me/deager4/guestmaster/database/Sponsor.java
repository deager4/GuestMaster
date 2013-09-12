package me.deager4.guestmaster.database;

import java.io.IOException;
import java.util.ArrayList;

import me.deager4.guestmaster.GuestMaster;

public class Sponsor 
{
	private String name;
	
	private ArrayList<SponsorVisit> visits = new ArrayList<SponsorVisit>();
	
	public Sponsor(String name)
	{
		this.name = name;
	}
	
	public void addVisit(SponsorVisit visit) throws IOException
	{
		this.visits.add(visit);
		GuestMaster.getDatabase().exportDatabase();
	}
	
	public ArrayList<SponsorVisit> getVisits()
	{
		return this.visits;
	}
	
	public String getName()
	{
		return this.name;
	}
}
