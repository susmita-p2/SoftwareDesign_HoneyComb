package honeyComb;

public class Company extends Page
{
	final static String[] roles_is = { "contributor", "employer", "following"};
	final static String[] roles_has = { "employee", "project", "job_posting", "follower", "news_article"};
	
	public Company( String name, String description )
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
