package honeyComb;



public class NewsArticle extends Page
{

	final static String[] roles_is = {"news_article"};
	final static String[] roles_has = { "editor","contributor","mentor","viewer"};
	public NewsArticle(String name, String description)
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
