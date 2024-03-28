package honeyComb;


public class Project extends Page
{

	final static String[] roles_is = {"project"};
	final static String[] roles_has = { "editor","contributor", "follower", "mentor", "viewer"};
	public Project(String name, String description)
	{
		super(name, description);
	
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

}
