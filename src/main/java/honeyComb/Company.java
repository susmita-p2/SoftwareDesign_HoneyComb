package honeyComb;

public class Company extends Page
{
	static String[] roles_is = { "contributor", "employer", "following"};
	static String[] roles_has = { "employee", "project", "job_posting", "follower", "news_article", "viewer", "mentor", "editor"};
	
	public Company( String name, String description )
	{
		super(name, description);
	}
	public Company() {}
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
}
