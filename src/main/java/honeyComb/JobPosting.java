package honeyComb;



public class JobPosting extends Page
{
	static String[] roles_is = { "job_posting"};
	static String[] roles_has = { "editor","applicant", "skill", "mentor", "viewer", "contributor"};
	
	public JobPosting(String name, String description)
	{
		super(name, description);
	}
	public JobPosting() {}
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
