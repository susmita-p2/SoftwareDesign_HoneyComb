package honeyComb;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Page
{
	String id;
	String name;
	String description;
	//roles to Page
	HashMap<String, ArrayList<Page>>  page_links = new HashMap<String, ArrayList<Page>> ();
	ArrayList<String> external_links = new ArrayList<String>();
	
	public Page( String name, String description)
	{
		IDGenerator genID = IDGenerator.getInstance();
		this.id = genID.getNextID();
		this.name = name;
		this.description = description;
	
	}

	/**
	 * @return the id
	 */
	public String getID()
	{
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	} 
	/**
	 * @return the page_links
	 */
	public  HashMap<String, ArrayList<Page>> getPage_links()
	{
		return page_links;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	} 
	public ArrayList<String> getExternalLinks()
	{
		return external_links;
	}
	/*
	 * @add externalLinks 
	 */
	public void addExternalLink(String link)
	{
		if (! external_links.contains(link))
		{
			external_links.add(link);
		}
	}
	/*
	 * remove externalLinks
	 */
	public void removeExternalLink(String link)
	{
		if(external_links.contains(link))
		{
			external_links.remove(link);
		}
	}

	public boolean containsRole(String[] roles, String key)
	{
		//String[] roles = p.getRolesIs();
		for(int i = 0; i < roles.length; i++)
		{
			if (roles[i].toLowerCase() == key)
			{
				return true;
			}
		}
		return false;
	}
	public void addLink(String key , Page p) throws ClassIncompatibleException
	{
		//Checks if this page can have the given role 
		if(containsRole(this.getRolesHas(),key) == false)
		{
			throw new ClassIncompatibleException();
		}
		//Checks if the new page that we are trying to add  can assume the given role
		if(containsRole(p.getRolesIs(),key) == false)
		{
			throw new ClassIncompatibleException();
		}
		if ( page_links.containsKey(key))
		{
			ArrayList<Page>list_pages = page_links.get(key);
			if (! list_pages.contains(p))
			{
				list_pages.add(p);
			}
		}
		else
		{
			ArrayList<Page>list_pages = new ArrayList<Page>();
			list_pages.add(p);
			page_links.put(key, list_pages);
			
			
		}
	}
	public void removeLink(String key, Page p)
	{
		if(page_links.containsKey(key))
		{
			ArrayList<Page> list_pages = page_links.get(key);
			if (list_pages.contains(p))
			{
				list_pages.remove(p);
			}
		}
		
	}
	public abstract String[]  getRolesHas();
	public abstract String[] getRolesIs();
	public static void main(String[] args)
	{
		System.out.println("Page created!");
	}
		
}
