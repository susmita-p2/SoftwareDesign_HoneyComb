package honeyComb;

import java.util.ArrayList;

public class Person extends Page
{
	
	String pronoun;
	String email;
	String phone;
	String[] roles_is = {"mentor", "contributor", "employee", "editor", "follower", "applicant", "friend", "viewer"};
	String[] roles_has = {"skill", "employer", "project", "news_article", "follower", "friend", "viewer", "editor", "mentor", "job_posting"};
	/**
	 * @return the pronoun
	 */
	public String getPronoun()
	{
		return pronoun;
	}
	/**
	 * @param pronoun the pronoun to set
	 */
	public void setPronoun(String pronoun)
	{
		this.pronoun = pronoun;
	}
	/**
	 * @return the roles_is
	 */
	/*public String[] getRoles_is()
	{
		return roles_is;
	}
	/**
	 * @return the roles_has
	 */
//	public String[] getRoles_has()
//	{
//		return roles_has;
//	}
	
	//String[] roles_is = {"mentor", "contributor", "employee", "editor", "follower", "applicant", "friend", "viewer"};
	
	public Person(String name, String description,  String pronoun, String email, String phone)
	{
		super(name, description);
		this.pronoun = pronoun;
		this.email = email;
		this.phone = phone;
		//RestStorage.push_request(this);	
	}
	public Person() {}

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
	
	public boolean canView(Page p)
	{
		ArrayList<Page> empty_arr = new ArrayList <Page>();
		if (! p.page_links.containsKey("viewer"))
		{
			return true;
		}
		if (p.page_links.get("viewer").equals(empty_arr))
		{
			return true;
		}
		else
		{
			if (p.page_links.get("viewer").contains(this.getId()))
			{
				 return true;
			}

		}
		return false;	
	}
	
	public boolean canEdit(Page p) throws ClassIncompatibleException
	{
		if(p.page_links.containsKey("editor"))
		{
			if(p.page_links.get("editor").contains(this.getId()))
			{
				return true;
			}
			return false;
		}
		else
		{
			throw new ClassIncompatibleException();
		}
	}
	
	public String toString()
	{
		return "Person: " + name +", " +  description +", "+  pronoun + ", "+  email + ", " + phone;
	}
	public void setRoles_has(String[] roles_has)
	{
		this.roles_has = roles_has;
	}
	public void setRoles_is(String[] roles_is)
	{
		this.roles_is = roles_is;
	}
}
