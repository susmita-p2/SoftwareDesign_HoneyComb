package honeyComb;



public class NewsArticle extends Page
{

	static String[] roles_is = {"news_article"};
	static String[] roles_has = { "editor","contributor","mentor","viewer"};
	public NewsArticle(String name, String description)
	{
		super(name, description);
		
	}
	public NewsArticle() {}
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
