package model;


public class Skill extends Page
{
	static String[] roles_is = { "skill", "following"};
	static String[] roles_has = { "editor","following", "mentor", "viewer", "follower"};
	public Skill(String name, String description)
	{
		super(name, description);

	}
	public Skill() {}
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
		return new SkillModel(this);
	}
	
}
