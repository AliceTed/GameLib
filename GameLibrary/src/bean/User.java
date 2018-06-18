package bean;

import java.io.Serializable;

public class User implements Serializable
{
	private int id;
	private String email;
	private String name;
	private String passward;

	public User()
	{
		this.id = -1;
		this.email = "none";
		this.name = "none";
		this.passward = "none";
	}

	public User(int id, String email, String name, String passward)
	{
		this.id = id;
		this.email = email;
		this.name = name;
		this.passward = passward;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassward()
	{
		return passward;
	}

	public void setPassward(String passward)
	{
		this.passward = passward;
	}

}
