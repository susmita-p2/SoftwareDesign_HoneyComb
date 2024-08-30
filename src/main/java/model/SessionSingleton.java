package model;

import java.util.ArrayList;

public class SessionSingleton
{
	static SessionSingleton currentSession = new SessionSingleton();
	String userId;
	
	private SessionSingleton()
	{
		this.userId = "";
	}
	
	public static SessionSingleton getInstance()
	{
		return currentSession;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public void endSession()
	{
		this.userId = "";
	}
	
	public boolean startSession(String id, String password)
	{
		if(this.checkPassword(id, password))
		{
			//this.userId = id;
			ArrayList <String> people_id = new ArrayList<String>();
			people_id = RestStorage.pull_page("Person");
			System.out.println(people_id);
			for (int i = 0; i < people_id.size(); i++)
			{
				if (id.equals(people_id.get(i)))
				{
					System.out.println("Id exists");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkPassword(String id, String password)
	{
		if(password == "" || id == "")
		{
			return false;
		}
		
		return true;
	}
	
}
