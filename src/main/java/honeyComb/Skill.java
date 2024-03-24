package honeyComb;


public class Skill extends Page
{
	final static String[] roles_is = { "skill"};
	final static String[] roles_has = { "editor","following"};
	public Skill(String name, String description)
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
