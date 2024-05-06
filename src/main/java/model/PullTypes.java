package model;


import org.springframework.web.client.RestClient;
//import org.springframework.web.client.RestClientException;

public class PullTypes
{
	static RestClient defaultClient = RestClient.create();
	public record PersonResponse(String request, String successful, String message,  Person data) {};
	public record CompanyResponse(String request, String successful, String message,  Company data) {};
	public record SkillResponse(String request, String successful, String message,  Skill data) {};
	public record JobPostingResponse(String request, String successful, String message,  JobPosting data) {};
	public record ProjectResponse(String request, String successful, String message,  Project data) {};
	public record NewsArticleResponse(String request, String successful, String message,  NewsArticle data) {};
	
	public static Page pull_person(String id_uri)
	{
		PersonResponse id_exists = defaultClient.get()
				.uri(id_uri)
				.retrieve()
				.body(PersonResponse.class);

		System.out.println(id_exists.data);
		return id_exists.data;
	}
	public static Page pull_company(String id_uri)
	{
		CompanyResponse id_exists = defaultClient.get()
				.uri(id_uri)
				.retrieve()
				.body(CompanyResponse.class);

		System.out.println(id_exists.data);
		return id_exists.data;
	}
	public static Page pull_skill(String id_uri)
	{
		SkillResponse id_exists = defaultClient.get()
				.uri(id_uri)
				.retrieve()
				.body(SkillResponse.class);

		System.out.println(id_exists.data);
		return id_exists.data;
	}
	public static Page pull_project(String id_uri)
	{
		ProjectResponse id_exists = defaultClient.get()
				.uri(id_uri)
				.retrieve()
				.body(ProjectResponse.class);

		System.out.println(id_exists.data);
		return id_exists.data;
	}
	public static Page pull_news(String id_uri)
	{
		NewsArticleResponse id_exists = defaultClient.get()
				.uri(id_uri)
				.retrieve()
				.body(NewsArticleResponse.class);

		System.out.println(id_exists.data);
		return id_exists.data;
	}
	public static Page pull_job(String id_uri)
	{
		JobPostingResponse id_exists = defaultClient.get()
				.uri(id_uri)
				.retrieve()
				.body(JobPostingResponse.class);

		System.out.println(id_exists.data);
		return id_exists.data;
	}
}
