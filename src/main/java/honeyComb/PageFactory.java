package honeyComb;

public class PageFactory
{
	public static Page pull(String class_name, String id_uri)
	{
		if (class_name.equals("Person"))
		{return PullTypes.pull_person(id_uri);}
		else if (class_name.equals("Company"))
		{return PullTypes.pull_company(id_uri);}
		else if (class_name.equals("Skill"))
		{return PullTypes.pull_skill(id_uri);}
		else if (class_name.equals("NewsArticle"))
		{return PullTypes.pull_news(id_uri);}
		else if (class_name.equals("JobPosting"))
		{return PullTypes.pull_job(id_uri);}
		else if (class_name.equals("Project"))
		{return PullTypes.pull_project(id_uri);}
		return null;
	}
	
}
