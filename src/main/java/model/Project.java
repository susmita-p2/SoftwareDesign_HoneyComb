package model;


public class Project extends Page
{

	static String[] roles_is = {"project"};
	static String[] roles_has = { "editor","contributor", "follower", "mentor", "viewer"};
	public Project(String name, String description)
	{
		super(name, description);
	
	}
	public Project() {}
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
	 * @param rolesIs the rolesIs to set
	 */
	public static void setRolesIs(String[] rolesIs)
	{
		roles_is = rolesIs;
	}
	/**
	 * @param rolesHas the rolesHas to set
	 */
	public static void setRolesHas(String[] rolesHas)
	{
		roles_has = rolesHas;
	}
	@Override
	public PageModel makeModel()
	{
		// TODO Auto-generated method stub
		return new ProjectModel (this);
	}

}
