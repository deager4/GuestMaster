package me.deager4.guestmaster.database;

/**
 * A simple date object. Easier to use than the Date object in java.util for simple things
 * @author deager4
 *
 */
public class FormattedDate 
{
	/**
	 * The day portion of the date. int
	 */
	private int day;
	
	/**
	 * The month portion of the date, int
	 */
	private int month;
	
	/**
	 * THe year portion of the date, int
	 */
	private int year;
	
	/**
	 * I should not have to explain this
	 */
	public FormattedDate(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	 * Public getter for {@link FormattedDate#day}
	 * @return {@link FormattedDate#date}
	 */
	public int getDay()
	{
		return this.day;
	}
	
	/**
	 * Public getter for {@link FormattedDate#month}
	 * @return {@link FormattedDate#month}
	 */
	public int getMonth()
	{
		return this.month;
	}
	
	/**
	 * Public getter for {@link FormattedDate#year}
	 * @return {@link FormattedDate#year}
	 */
	public int getYear()
	{
		return this.year;
	}
	
	/**
	 * Formats the {@link FormattedDate} object in the format: "{@link FormattedDate#month}/{@link FormattedDate#day}/{@link FormattedDate#year)"
	 */
	public String toString()
	{
		return this.month + "/" + this.day + "/" + this.year;
	}
}
