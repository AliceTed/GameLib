package bean;

import java.io.Serializable;
import java.sql.Date;

public class Game implements Serializable
{
	private int id;
	private String title;
	private String company;
	private Date date;
	private String genre;

	public Game()
	{
		id = -1;
		title = "none";
		company = "none";
		date = new Date(0);
		genre = "none";
	}

	public Game(int id, String title, String company, Date date, String genre)
	{
		this.id = id;
		this.title = title;
		this.company = company;
		this.date = date;
		this.genre = genre;
	}

	public Game(int id, String title, String company, String date, String genre)
	{
		this.id = id;
		this.title = title;
		this.company = company;
		setDate(date);
		this.genre = genre;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public void setDate(String date)
	{
		if (date == null)
		{
			this.date = new Date(0);
			return;
		}
		this.date = Date.valueOf(date);
	}

	public String getFormatDate()
	{
		return date.toString();
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}
}
