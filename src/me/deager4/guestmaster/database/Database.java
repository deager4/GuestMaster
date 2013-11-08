package me.deager4.guestmaster.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

import me.deager4.guestmaster.GuestMaster;

/**
 * The Database for the entire program. Handles pretty much everything.
 * 
 * In a future update, I want to change how the lists are stored, as right now they are really obfuscated.
 * @author deager4
 *
 */
public class Database 
{
	/**
	 * An {@link ArrayList} that stores all {@link Guest}s in the database
	 */
	private ArrayList<Guest> guestList;
	
	/**
	 * A {@link HashMap} that stores all of the {@Sponsor}s in the database
	 */
	private HashMap<String, Sponsor> sponsorList;
	
	/**
	 * This class contains all {@link Guest}s and {@link Sponsor}s for the database, and is also responsible for writing the database to a file.
	 */
	public Database()
	{
		this.guestList = new ArrayList<Guest>();
		this.sponsorList = new HashMap<String, Sponsor>();
	}
	
	/**
	 * Gets the number of entries in {@link Database#guestList}
	 * @return {@link Database#guestList}
	 */
	public int getNumberInGuestList()
	{
		return guestList.size();
	}
	
	/**
	 * if an instance of {@link Guest} is stored in {@link Database#guestList}, and is identical to the param, this method returns that guest
	 * 
	 * note: this may sound really useless, but it is helpful when you are trying to make everything accessible from one class. it makes inheritance a lot e
	 * 
	 * @param guest {@link Guest}
	 * @return {@link Guest}
	 */
	public Guest getGuest(Guest guest)
	{
		if(this.guestList.contains(guest))
		{
			return this.guestList.get(this.guestList.indexOf(guest));
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Adds a {@link Guest} to the {@link Database#guestList}
	 * @param guest {@link Guest}
	 */
	public void addGuest(Guest guest)
	{
		guestList.add(guest);
	}
	
	/**
	 * Does pretty much what it says. It sets all indices of {@link Database#guestList} to null
	 */
	public void clearGuests()
	{
		this.guestList.clear();
	}
	
	/**
	 * exports the database in a .gmf format 
	 * @note (read "gmf README.txt" for more information on file format)
	 * @throws IOException
	 * 
	 * @postScript I know this could have been done a lot easier with buffered writers etc, but I did not know about that at the time, and right now, I really don't feel like changing it. Feel free to though.
	 */
	public void exportDatabase() throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter("Guests\\database.gmf"));
		for(int count = 0; count < this.guestList.size(); count ++)
		{
			writer.write('\n' + "type%%guest");
			writer.write('\n' + "name%%" + this.guestList.get(count).getName() + '\n');
			writer.write("birthDate%%" + this.guestList.get(count).getBirthDate().toString() + '\n');
			for(int count1 = 0; count1 < this.guestList.get(count).getVisits().size(); count1 ++)
			{
				writer.write("visit%%" + this.guestList.get(count).getVisits().get(count1).toOutputString() + '\n');
			}
			writer.write("####");
		}
		Set<String> keyList = sponsorList.keySet();
		Object[] array = keyList.toArray();
		ArrayList<Sponsor> newSponsorList = new ArrayList<Sponsor>();
		for(int count = 0; count < keyList.size(); count ++)
		{
			newSponsorList.add(sponsorList.get((String)array[count]));
		}
		for(int count3 = 0; count3 < newSponsorList.size(); count3 ++)
		{
			writer.write('\n' + "type%%sponsor");
			writer.write('\n' + "name%%" + newSponsorList.get(count3).getName() + '\n');
			for(int count2 = 0; count2 < newSponsorList.get(count3).getVisits().size(); count2 ++)
			{
				writer.write("visit%%" + newSponsorList.get(count3).getVisits().get(count2).toString() + '\n');
			}
			writer.write("####");
		}
		
		char[] buf = GuestMaster.getPassword().toCharArray();
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String stringDate = format.format(date);
		StringTokenizer a = new StringTokenizer(stringDate, "/");
		a.nextToken();
		int day = Integer.parseInt(a.nextToken());
		for(int count = 0; count < buf.length; count ++)
		{
			buf[count] = (char) (buf[count] - day);
		}
		String newPassword = "";
		for(int count2 = 0; count2 < buf.length; count2 ++)
		{
			newPassword = newPassword + buf[count2];
		}
		writer.write('\n' + "type%%password");
		writer.write('\n' + "password%%" + newPassword + '\n');
		writer.write("date%%" + stringDate + '\n');
		writer.write("####");
		
		writer.close();
	}
	
	/**
	 * backs up the database to an external .gmf file
	 * @note (read "gmf README.txt" for more information on file format)
	 * @throws IOException
	 * 
	 * @postScript I know this could have been done a lot easier with buffered writers etc, but I did not know about that at the time, and right now, I really don't feel like changing it. Feel free to though.
	 */
	public void backupDatabase(File file) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for(int count = 0; count < this.guestList.size(); count ++)
		{
			writer.write('\n' + "type%%guest");
			writer.write('\n' + "name%%" + this.guestList.get(count).getName() + '\n');
			writer.write("birthDate%%" + this.guestList.get(count).getBirthDate().toString() + '\n');
			for(int count1 = 0; count1 < this.guestList.get(count).getVisits().size(); count1 ++)
			{
				writer.write("visit%%" + this.guestList.get(count).getVisits().get(count1).toOutputString() + '\n');
			}
			writer.write("####");
		}
		Set<String> keyList = sponsorList.keySet();
		Object[] array = keyList.toArray();
		ArrayList<Sponsor> newSponsorList = new ArrayList<Sponsor>();
		for(int count = 0; count < keyList.size(); count ++)
		{
			newSponsorList.add(sponsorList.get((String)array[count]));
		}
		for(int count3 = 0; count3 < newSponsorList.size(); count3 ++)
		{
			writer.write('\n' + "type%%sponsor");
			writer.write('\n' + "name%%" + newSponsorList.get(count3).getName() + '\n');
			for(int count2 = 0; count2 < newSponsorList.get(count3).getVisits().size(); count2 ++)
			{
				writer.write("visit%%" + newSponsorList.get(count3).getVisits().get(count2).toString() + '\n');
			}
			writer.write("####");
		}
		
		char[] buf = GuestMaster.getPassword().toCharArray();
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String stringDate = format.format(date);
		StringTokenizer a = new StringTokenizer(stringDate, "/");
		a.nextToken();
		int day = Integer.parseInt(a.nextToken());
		for(int count = 0; count < buf.length; count ++)
		{
			buf[count] = (char) (buf[count] - day);
		}
		String newPassword = "";
		for(int count2 = 0; count2 < buf.length; count2 ++)
		{
			newPassword = newPassword + buf[count2];
		}
		writer.write('\n' + "type%%password");
		writer.write('\n' + "password%%" + newPassword + '\n');
		writer.write("date%%" + stringDate + '\n');
		writer.write("####");
		writer.close();
	}
	
	/**
	 * imports the database in a .gmf format 
	 * @note (read "gmf README.txt" for more information on file format)
	 * @throws IOException
	 * 
	 * @postScript I know this could have been done a lot easier with buffered readers etc, but I did not know about that at the time, and right now, I really don't feel like changing it. Feel free to though.
	 */
	public void importDatabase() throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("Guests\\database.gmf"));
		String line = null;
		reader.readLine();
		String name = "";
		String birthDate = "";
		String passDate = "";
		String importedPassword = "";
		ArrayList<String> visits = new ArrayList<String>();
		ArrayList<String> sponsorVisits = new ArrayList<String>();
		String type = "";
		while((line = reader.readLine()) != null)
		{
			StringTokenizer a = new StringTokenizer(line, "%%");
			String startLine = a.nextToken();
			if(startLine.equals("type"))
			{
				type = a.nextToken();
			}
			if(startLine.equals("name"))
			{
				name = a.nextToken();
			}
			else if(startLine.equals("birthDate"))
			{
				birthDate = a.nextToken();
			}
			else if(startLine.equals("date"))
			{
				passDate = a.nextToken();
			}
			else if(startLine.equals("password"))
			{
				importedPassword = a.nextToken();
			}
			else if(startLine.equals("visit"))
			{
				if(type.equals("guest"))
				{
					visits.add(a.nextToken());
				}
				else if(type.equals("sponsor"))
				{
					sponsorVisits.add(a.nextToken());
				}
			}
			if(line.equals("####"))
			{
				if(type.equals("guest"))
				{
					StringTokenizer b = new StringTokenizer(name, " ");
					String firstName = b.nextToken();
					String lastName = b.nextToken();
					StringTokenizer c = new StringTokenizer(birthDate, "/");
					int day = Integer.parseInt(c.nextToken());
					int month = Integer.parseInt(c.nextToken());
					int year = Integer.parseInt(c.nextToken());
					FormattedDate date = new FormattedDate(day, month, year);
					Guest guest = new Guest(firstName, lastName, false, date);
					for(int count = 0; count < visits.size(); count ++)
					{
						String currentVisit = visits.get(count);
						StringTokenizer d = new StringTokenizer(currentVisit, ";");
						String firstHalf = d.nextToken();
						String seccondHalf = d.nextToken();
						StringTokenizer e = new StringTokenizer(firstHalf, ":");
						e.nextToken();
						String sponsorName = e.nextToken();
						StringTokenizer f = new StringTokenizer(seccondHalf, ":");
						f.nextToken();
						String visitDate = f.nextToken();
						StringTokenizer g = new StringTokenizer(sponsorName, " ");
						
						String sponsorFirstName = g.nextToken();
						String sponsorLastName = g.nextToken();
						
						StringTokenizer h = new StringTokenizer(visitDate, "/");
						int visitDay = Integer.parseInt(h.nextToken());
						int visitMonth = Integer.parseInt(h.nextToken());
						int visitYear = Integer.parseInt(h.nextToken());
						FormattedDate actualVisitDate = new FormattedDate(visitDay, visitMonth, visitYear);
						
						Visit visit = new Visit(sponsorFirstName, sponsorLastName, actualVisitDate);
						guest.addVisit(visit);
					}
					if(guest.getVisits().size() >=5)
					{
						guest.setOverLimit(true);
					}
					
					guestList.add(guest);
					name = "";
					birthDate = "";
					visits.clear();
					type = "";
				}
				else if(type.equals("sponsor"))
				{
					Sponsor sponsor = new Sponsor(name);
					for(int count = 0; count < sponsorVisits.size(); count ++)
					{
						String currentVisit = sponsorVisits.get(count);
						StringTokenizer d = new StringTokenizer(currentVisit, ";");
						String firstHalf = d.nextToken();
						String seccondHalf = d.nextToken();
						String thirdHalf = d.nextToken();
						StringTokenizer e = new StringTokenizer(firstHalf, ":");
						e.nextToken();
						String guestName = e.nextToken();
						StringTokenizer f = new StringTokenizer(seccondHalf, ":");
						f.nextToken();
						String visitDate = f.nextToken();
						StringTokenizer g = new StringTokenizer(guestName, " ");
						
						String guestFirstName = g.nextToken();
						String guestLastName = g.nextToken();
						
						StringTokenizer h = new StringTokenizer(visitDate, "/");
						int visitDay = Integer.parseInt(h.nextToken());
						int visitMonth = Integer.parseInt(h.nextToken());
						int visitYear = Integer.parseInt(h.nextToken());
						FormattedDate actualVisitDate = new FormattedDate(visitDay, visitMonth, visitYear);
						StringTokenizer i = new StringTokenizer(thirdHalf, ":");
						i.nextToken();
						String paymentType = i.nextToken();
						boolean pass = false;
						if(paymentType.equals("Guest Pass"))
						{
							pass = true;
						}
						SponsorVisit visit = new SponsorVisit(guestFirstName, guestLastName, actualVisitDate, pass);
						sponsor.addVisit(visit);
					}
					sponsorList.put(name, sponsor);
					name = "";
					sponsorVisits.clear();
					type = "";
				}
				else if(type.equals("password"))
				{
					char[] buf = importedPassword.toCharArray();
					StringTokenizer b = new StringTokenizer(passDate, "/");
					b.nextToken();
					int key = Integer.parseInt(b.nextToken());
					String newPassword = "";
					for(int count = 0; count < buf.length; count ++)
					{
						newPassword = newPassword + (char)(buf[count] + key);
					}
					GuestMaster.setPassword(newPassword);
					passDate = "";
					type = "";
				}
				
			}
		}
	}
	
	/**
	 * imports the database in a .gmf format from another file other than the standard one
	 * @note (read "gmf README.txt" for more information on file format)
	 * @throws IOException
	 * 
	 * @postScript I know this could have been done a lot easier with buffered readers etc, but I did not know about that at the time, and right now, I really don't feel like changing it. Feel free to though.
	 */
	public void restoreDatabase(File file) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		reader.readLine();
		String name = "";
		String birthDate = "";
		String importedPassword = "";
		String passDate = "";
		ArrayList<String> visits = new ArrayList<String>();
		ArrayList<String> sponsorVisits = new ArrayList<String>();
		String type = "";
		while((line = reader.readLine()) != null)
		{
			StringTokenizer a = new StringTokenizer(line, "%%");
			String startLine = a.nextToken();
			if(startLine.equals("type"))
			{
				type = a.nextToken();
			}
			if(startLine.equals("name"))
			{
				name = a.nextToken();
			}
			else if(startLine.equals("birthDate"))
			{
				birthDate = a.nextToken();
			}
			else if(startLine.equals("date"))
			{
				passDate = a.nextToken();
			}
			else if(startLine.equals("password"))
			{
				importedPassword = a.nextToken();
			}
			else if(startLine.equals("visit"))
			{
				if(type.equals("guest"))
				{
					visits.add(a.nextToken());
				}
				else if(type.equals("sponsor"))
				{
					sponsorVisits.add(a.nextToken());
				}
			}
			if(line.equals("####"))
			{
				if(type.equals("guest"))
				{
					StringTokenizer b = new StringTokenizer(name, " ");
					String firstName = b.nextToken();
					String lastName = b.nextToken();
					StringTokenizer c = new StringTokenizer(birthDate, "/");
					int day = Integer.parseInt(c.nextToken());
					int month = Integer.parseInt(c.nextToken());
					int year = Integer.parseInt(c.nextToken());
					FormattedDate date = new FormattedDate(day, month, year);
					Guest guest = new Guest(firstName, lastName, false, date);
					for(int count = 0; count < visits.size(); count ++)
					{
						String currentVisit = visits.get(count);
						StringTokenizer d = new StringTokenizer(currentVisit, ";");
						String firstHalf = d.nextToken();
						String seccondHalf = d.nextToken();
						StringTokenizer e = new StringTokenizer(firstHalf, ":");
						e.nextToken();
						String sponsorName = e.nextToken();
						StringTokenizer f = new StringTokenizer(seccondHalf, ":");
						f.nextToken();
						String visitDate = f.nextToken();
						StringTokenizer g = new StringTokenizer(sponsorName, " ");
						
						String sponsorFirstName = g.nextToken();
						String sponsorLastName = g.nextToken();
						
						StringTokenizer h = new StringTokenizer(visitDate, "/");
						int visitDay = Integer.parseInt(h.nextToken());
						int visitMonth = Integer.parseInt(h.nextToken());
						int visitYear = Integer.parseInt(h.nextToken());
						FormattedDate actualVisitDate = new FormattedDate(visitDay, visitMonth, visitYear);
						Visit visit = new Visit(sponsorFirstName, sponsorLastName, actualVisitDate);
						guest.addVisit(visit);
					}
					if(guest.getVisits().size() >=5)
					{
						guest.setOverLimit(true);
					}
					
					guestList.add(guest);
					name = "";
					birthDate = "";
					visits.clear();
					type = "";
				}
				else if(type.equals("sponsor"))
				{
					Sponsor sponsor = new Sponsor(name);
					for(int count = 0; count < sponsorVisits.size(); count ++)
					{
						String currentVisit = sponsorVisits.get(count);
						StringTokenizer d = new StringTokenizer(currentVisit, ";");
						String firstHalf = d.nextToken();
						String seccondHalf = d.nextToken();
						String thirdHalf = d.nextToken();
						StringTokenizer e = new StringTokenizer(firstHalf, ":");
						e.nextToken();
						String guestName = e.nextToken();
						StringTokenizer f = new StringTokenizer(seccondHalf, ":");
						f.nextToken();
						String visitDate = f.nextToken();
						StringTokenizer g = new StringTokenizer(guestName, " ");
						
						String guestFirstName = g.nextToken();
						String guestLastName = g.nextToken();
						
						StringTokenizer h = new StringTokenizer(visitDate, "/");
						int visitDay = Integer.parseInt(h.nextToken());
						int visitMonth = Integer.parseInt(h.nextToken());
						int visitYear = Integer.parseInt(h.nextToken());
						FormattedDate actualVisitDate = new FormattedDate(visitDay, visitMonth, visitYear);
						StringTokenizer i = new StringTokenizer(thirdHalf, ":");
						i.nextToken();
						String paymentType = i.nextToken();
						boolean pass = false;
						if(paymentType.equals("Guest Pass"))
						{
							pass = true;
						}
						SponsorVisit visit = new SponsorVisit(guestFirstName, guestLastName, actualVisitDate, pass);
						sponsor.addVisit(visit);
					}
					sponsorList.put(name, sponsor);
					name = "";
					sponsorVisits.clear();
					type = "";
				}
				else if(type.equals("password"))
				{
					char[] buf = importedPassword.toCharArray();
					StringTokenizer b = new StringTokenizer(passDate, "/");
					b.nextToken();
					int key = Integer.parseInt(b.nextToken());
					String newPassword = "";
					for(int count = 0; count < buf.length; count ++)
					{
						newPassword = newPassword + (char)(buf[count] + key);
					}
					GuestMaster.setPassword(newPassword);
					passDate = "";
					type = "";
				}
			}
		}
		
	}
	
	/**
	 * Adds a {@link Sponsor} to {@link Database#sponsorList}
	 * @param name Name of the sponsor
	 * @param sponsor the actual {@link Sponsor}
	 * @throws IOException
	 */
	public void addSponsor(String name, Sponsor sponsor) throws IOException
	{
		sponsorList.put(name, sponsor);
		this.exportDatabase();
	}
	
	
	/**
	 * Public getter for {@link Database#sponsorList}
	 * @return {@link Database#sponsorList}
	 */
	public HashMap<String, Sponsor> getSponsorList()
	{
		return sponsorList;
	}
	
	/**
	 * From the name of the sponsor, the guest's visit is added to that sponsor
	 * 
	 * @note kinda confusing I will admit, but really, I could not think of a better way to handle this. I was kinda pressed for time, as my clients added sponsor handling as a requirement at the last minute.
	 * @param name
	 * @param visit
	 * @throws IOException
	 */
	public void addVisitToSponsorFromName(String name, SponsorVisit visit) throws IOException
	{
		for(int count = 0; count < sponsorList.size(); count ++)
		{
			if(sponsorList.get(count).getName().equals(name))
			{
				sponsorList.get(count).addVisit(visit);
			}
		}
	}
	
	/**
	 * Returns the corresponding instance of {@link Guest} associated with the param, from {@link Database#guestList}
	 * @param name
	 * @return {@link Guest}
	 */
	public ArrayList<Guest> getGuestFromName(String name)
	{
		ArrayList<Guest> list = new ArrayList<Guest>();
		for(int count = 0; count < guestList.size(); count ++)
		{
			if(guestList.get(count).getName().toLowerCase().contains(name.toLowerCase()))
			{
				list.add(guestList.get(count));
			}
			else
			{
				continue;
			}
		}
		return list;
	}
	
	
	/**
	 * removes an instance of {@link Guest} from {@link Database#guestList}
	 * @param guest
	 */
	public void removeGuest(Guest guest)
	{
		guestList.remove(guest);
	}
}
