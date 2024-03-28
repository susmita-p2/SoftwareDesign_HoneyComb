package honeyComb;



public class JobPosting extends Page
{
	final static String[] roles_is = { "job_posting"};
	final static String[] roles_has = { "editor","applicant", "skill", "mentor", "viewer", "contributor"};
	
	public JobPosting(String name, String description)
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
