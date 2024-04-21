package honeyComb;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Page
{
	String id;
	String name;
	String description;
	//roles to Page
	// HashMap<String, Page[]>  page_links = new HashMap<String, Page[]> ();
	HashMap<String, ArrayList <String>>  page_links = new HashMap<String, ArrayList<String>> ();
	ArrayList<String> external_links = new ArrayList<String>();
	public Page( String name, String description)
	{
		IDGenerator genID = IDGenerator.getInstance();
		this.id = genID.getNextID();
		this.name = name;
		this.description = description;
	
	}
	public Page(){}
	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @param external_links the external_links to set
	 */
	public void setExternal_links(ArrayList<String> external_links)
	{
		this.external_links = external_links;
	}
	
	


	/**
	 * @return the page_links
	 */
	public HashMap<String, ArrayList<String>> getPage_links()
	{
		return page_links;
	}

	/**

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
	
		for(int i = 0; i < roles.length; i++)
		{
			if (roles[i].toLowerCase().equals(key))
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
			ArrayList<String> list_pages = page_links.get(key);
			String add_id = p.getId();
			if (list_pages.contains(add_id))
			{		
				//System.out.println("Id already presents");
			}
			else
			{
				list_pages.add(add_id);
			}
		}
		else
		{
			ArrayList<String>list_pages1 = new ArrayList<String>();
			String id_page = p.getId();
			//System.out.println(id_page);
			list_pages1.add(id_page);
			page_links.put(key, list_pages1);		
		}
		
		//System.out.println(page_links);
	}
	public void removeLink(String key, Page p)
	{
		if(page_links.containsKey(key))
		{
			ArrayList<String> list_pages = page_links.get(key);
			if (list_pages.contains(p.getId()))
			{
				list_pages.remove(p.getId());
			}
		}
		
	}
	public boolean getLink(String key)
	{
		if(this.page_links.containsKey(key))
		{
			return true;
		}
		return false;
	}
	public abstract String[]  getRolesHas();
	public abstract String[] getRolesIs();
	/**
	 * @param page_links the page_links to set
	 */
	public void setPage_links(HashMap<String, ArrayList<String>> page_links)
	{
		this.page_links = page_links;
	}	
	

		
}
