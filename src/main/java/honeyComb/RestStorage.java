package honeyComb;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

//import honeyComb.RestStorage.PersonResponse;

public class RestStorage
{
	static RestClient defaultClient = RestClient.create();
	final static String uribase = "http://localhost:9000/v1/HoneyComb";
	public record RDesc(String name, String description, String location) {};
	public record RResponseDesc(String request, String successful, String message, RDesc data) {};
	public record Update(String request, String successful, String message, String data) {};
	public record PersonResponse(String request, String successful, String message,  Person data) {};
	/*public record CompanyResponse(String request, String successful, String message,  Company data) {};
	public record SkillResponse(String request, String successful, String message,  Skill data) {};
	public record JobPostingResponse(String request, String successful, String message,  JobPosting data) {};
	public record ProjectResponse(String request, String successful, String message,  Project data) {};
	public record NewsArticleResponse(String request, String successful, String message,  NewsArticle data) {};*/
	
	
	
	public static  RResponseDesc createProductShell()
	{
		String delete_team = defaultClient.delete()
				.uri(uribase)
				.retrieve()
				.body(String.class);
		RResponseDesc result = defaultClient.post() 
			  .uri(uribase)
			  .body(new RDesc("HoneyComb", "Networking platform",""))
			  .retrieve() 
			  .body(RResponseDesc.class); 
		//System.out.println(result);
		return result;	
	}
	public static RResponseDesc create_Pages(String class_name)
	{
		String class_uri = uribase+"/"+class_name;
		RResponseDesc result_class= defaultClient.post() 
				  .uri(class_uri)
				  .body(new RDesc("Person", "Page of HoneyComb",  null))
				  .retrieve() 
				  .body(RResponseDesc.class); 
		//System.out.println(result_class);
		return result_class;
	}
	public static  String push_request(Page p) 
	{
		String id_uri = uribase + "/" + p.getClass().getSimpleName()+ "/" + p.getId();
		System.out.println(id_uri);
		try {
		RResponseDesc result_id= defaultClient.post() 
				  .uri(id_uri)
				  .body(p)
				  .retrieve() 
				  .body(RResponseDesc.class); 
		System.out.println(result_id); 
		return (result_id.successful());
		} catch (RestClientException e)
		{
			System.out.println("Page already exists!!");
			return "false";
		}
		
	}
	
	public static Update update_request(Page p)
	{
		String post_uri = uribase + "/" + p.getClass().getSimpleName() + "/" + p.getId();
		System.out.println(post_uri);
		Update result = defaultClient.put() 
				  .uri(post_uri)
				  .body(p)
				  .retrieve()
				  .body(Update.class); 
		System.out.println(result);
		return result;
	}


	public static Page pull_request(String id)
	{
	
		String check_result = check_request(id);
		System.out.println(check_result);
		if (check_result == "Fail")
		{
			return null;
		}
		String id_uri = uribase+ "/" + check_result+ "/" + id;
		return PageFactory.pull(check_result, id_uri);
		//System.out.println(id_uri);

		
	}
	//helper function to find the uri for the given id 
	public static String check_request(String id)
	{
		String[] page_classes = {"Person","Company","Skill","NewsArticle","Project","JobPosting"};
		for(int i = 0; i < page_classes.length; i++)
		{
			String test_uri = uribase + "/" + page_classes[i] + "/" + id;
			System.out.println(test_uri);
			try
			{
			String  id_exists= defaultClient.get()
					.uri(test_uri)
					.retrieve()
					.body(String.class);
			System.out.println(id_exists);	
			System.out.println(page_classes[i]);
			return page_classes[i];
			} catch (RestClientException ex)
			{
				System.out.println("Not exist");
			}
		}
		return "Fail";
	}
	public static String pull(String id)
	{
		String id_uri =  uribase+ "/" + "Person" + "/" + id;
		String  id_exists= defaultClient.get()
				.uri(id_uri)
				.retrieve()
				.body(String.class);
		System.out.println(id_exists);
		return "";
	}
	
	public static void main(String[] args)
	{
		createProductShell();
		String[] page_classes = {"Person","Company","Skill","NewsArticle","Project","JobPosting"};
		for(int i = 0; i < page_classes.length; i++)
		{
			RestStorage.create_Pages(page_classes[i]);
		}
		Person A = new Person("Alice", "Fun", "she/her", "coolalice@gmail.com", "859-000-0000");
		Person B = new Person("Bob", "Funny", "he/him", "bob@gmail.com", "200");
		Company Amazon = new Company("Amazon", "Fueling shopping addiction");
		ArrayList<String> stuff = new ArrayList<String>();
		stuff.add("Github");
		B.setExternal_links(stuff);
	
		Person C = new Person("Bob", "Funny", "he/him", "bob@gmail.com", "200");
		//System.out.println(push_request(A).successful());
		push_request(A);
		push_request(Amazon);
		push_request(B);
		A.setName("Alsion");
		//update_request(A);
		//find_id("2");
		//PersonResponse x = pull("0");
		//System.out.println(CreateMap());
		//check_request("1");
		//pull_request("1");
		//A.setName("XXXXXXX");
		//update_request(A);
		//Object a = pull_request("1");
		//System.out.println(((Person) a).getName());
		//System.out.println(x.data.getExternalLinks());
		//System.out.println(x.data());
		//System.out.println(update_request(A));
		//push_request(Amazon);
		//A.setName("Markopolo");
		//push_request(B);
		//update_request(A);
		/*String id_uri ="http://localhost:9000/v1/HoneyComb/Person/1";
		ClassResponse  id_exists= defaultClient.get()
				.uri(id_uri)
				.retrieve()
				.body(ClassResponse.class);
		System.out.println(id_exists.data.getRolesHas());
		CompanyResponse  exists= defaultClient.get()
				.uri("http://localhost:9000/v1/HoneyComb/Company/2")
				.retrieve()
				.body(CompanyResponse.class);
		System.out.println(exists.data.getRolesHas());*/
		
		
	}
}
