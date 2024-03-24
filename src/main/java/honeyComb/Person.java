package honeyComb;



public class Person extends Page
{
	
	String pronoun;
	String email;
	String phone;
	final static String[] roles_is = {"mentor", "contributor", "employee", "editor", "follower", "applicant", "following"};
	final static String[] roles_has = {"skill", "employer", "project", "news_article", "follower", "following"};
	
	public Person(String name, String description, String pronoun, String email, String phone)
	{
		super(name, description);
		this.pronoun = pronoun;
		this.email = email;
		this.phone = phone;
	
	}

	@Override
	public String[] getRolesHas()
	{
		
		return roles_has;
	}
	@Override
	public String[] getRolesIs()
	{
	
		return roles_is;
	}
	/**
	 * @return the pronouns
	 */
	public String getPronouns()
	{
		return pronoun;
	}
	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone()
	{
		return phone;
	}



	/**
	 * @param pronouns the pronouns to set
	 */
	public void setPronouns(String pronoun)
	{
		this.pronoun = pronoun;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}



	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String toString()
	{
		return "Person: " + name +", " +  description +", "+  pronoun + ", "+  email + ", " + phone;
	}
	
	
}
