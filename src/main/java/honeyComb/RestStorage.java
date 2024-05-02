package honeyComb;

import java.util.ArrayList;
//import java.util.HashMap;

import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;



public class RestStorage
{
	static RestClient defaultClient = RestClient.create();
	final static String uribase = "http://localhost:9000/v1/HoneyComb";
	//private static final RDesc Null = null;
	public record RDesc(String name, String description, String location) {};
	public record RResponseDesc(String request, String successful, String message, RDesc data) {};
	public record Update(String request, String successful, String message, String data) {};
	public record PageResponse(String request, String successful, String message, RDesc[] data) {};

	
	
	
	public static  RResponseDesc createProductShell()
	{
		defaultClient.delete()
				.uri(uribase)
				.retrieve();
				
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
		//System.out.println(result_id); 
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
		//System.out.println(result);
		return result;
	}


	public static Page pull_request(String id)
	{
	
		String check_result = check_request(id);
		//System.out.println(check_result);
		/*if (check_result.equals(""))
		{
			return null;
		}*/
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
		
		
			try
			{
				/*RResponseDesc  id_exists=*/ defaultClient.get()
						.uri(test_uri)
						.retrieve()
						.body(RResponseDesc.class);
				
					return page_classes[i];
				
				
			} catch (RestClientException ex)
			{
					System.out.println( test_uri + "Not exist");
				
			}
		}
		return "";
	}

	
	public static ArrayList<String> pull_page(String class_name)
	{
		ArrayList<String> arr_id = new ArrayList<String>();
		String id_uri =  uribase+ "/" + class_name;
		PageResponse  page_exists= defaultClient.get()
				.uri(id_uri)
				.retrieve()
				.body(PageResponse.class);
		System.out.println(page_exists.data);
		RDesc[] data_arr = page_exists.data;
		//System.out.println(data_arr.length);
		int i = 0;
		while (i <(data_arr.length))
		{
			//System.out.println(data_arr[i].name() + i);
			arr_id.add(data_arr[i].name());
			i++;
		}
		return arr_id;	
	}
	//Pull all Person entities
	public static ArrayList<Page> pull_Person()
	{
		ArrayList<Page> person_arr = new ArrayList<Page>();
		ArrayList<String> arr_id = new ArrayList<String>();
		String id_uri =  uribase+ "/" + "Person";
		PageResponse  page_exists= defaultClient.get()
				.uri(id_uri)
				.retrieve()
				.body(PageResponse.class);
		System.out.println(page_exists.data);
		RDesc[] data_arr = page_exists.data;
		System.out.println(data_arr.length);
		int i = 0;
		while (i <(data_arr.length))
		{
			System.out.println(data_arr[i].name() + ","+ i);
			arr_id.add(data_arr[i].name());
			i++;
		}
		int j = 0;
		while (j < (arr_id.size()))
		{
			Person x = (Person) pull_request(arr_id.get(j));
			//System.out.println(x);
			person_arr.add((Person)x);
			j++;
		}
		
		return person_arr;
	}
	
	//Pull all company entities
	public static ArrayList<Page> pull_Company()
	{
		ArrayList<Page> company_arr = new ArrayList<Page>();
		ArrayList<String> arr_id = new ArrayList<String>();
		String id_uri =  uribase+ "/" + "Company";
		PageResponse  page_exists= defaultClient.get()
				.uri(id_uri)
				.retrieve()
				.body(PageResponse.class);
		System.out.println(page_exists.data);
		RDesc[] data_arr = page_exists.data;
		System.out.println(data_arr.length);
		int i = 0;
		while (i <(data_arr.length))
		{
			System.out.println(data_arr[i].name() + ","+ i);
			arr_id.add(data_arr[i].name());
			i++;
		}
		int j = 0;
		while (j < (arr_id.size()))
		{
			Page x = pull_request(arr_id.get(j));
			//System.out.println(x);
			company_arr.add((Company)x);
			j++;
		}
		
		return company_arr;
	}
	//Pull all skill entities
		public static ArrayList<Page> pull_Skill()
		{
			ArrayList<Page> skill_arr = new ArrayList<Page>();
			ArrayList<String> arr_id = new ArrayList<String>();
			String id_uri =  uribase+ "/" + "Skill";
			PageResponse  page_exists= defaultClient.get()
					.uri(id_uri)
					.retrieve()
					.body(PageResponse.class);
			System.out.println(page_exists.data);
			RDesc[] data_arr = page_exists.data;
			System.out.println(data_arr.length);
			int i = 0;
			while (i <(data_arr.length))
			{
				System.out.println(data_arr[i].name() + ","+ i);
				arr_id.add(data_arr[i].name());
				i++;
			}
			int j = 0;
			while (j < (arr_id.size()))
			{
				Page x = pull_request(arr_id.get(j));
				//System.out.println(x);
				skill_arr.add((Skill)x);
				j++;
			}
			
			return skill_arr;
		}
		//Pull all project entities
		public static ArrayList<Page> pull_Project()
		{
			ArrayList<Page> project_arr = new ArrayList<Page>();
			ArrayList<String> arr_id = new ArrayList<String>();
			String id_uri =  uribase+ "/" + "Project";
			PageResponse  page_exists= defaultClient.get()
					.uri(id_uri)
					.retrieve()
					.body(PageResponse.class);
			System.out.println(page_exists.data);
			RDesc[] data_arr = page_exists.data;
			System.out.println(data_arr.length);
			int i = 0;
			while (i <(data_arr.length))
			{
				System.out.println(data_arr[i].name() + ","+ i);
				arr_id.add(data_arr[i].name());
				i++;
			}
			int j = 0;
			while (j < (arr_id.size()))
			{
				Page x = pull_request(arr_id.get(j));
				//System.out.println(x);
				project_arr.add((Project)x);
				j++;
			}
			
			return project_arr;
		}
		//Pull all newsarticle entities
		public static ArrayList<Page> pull_NewsArticle()
		{
			ArrayList<Page> news_arr = new ArrayList<Page>();
			ArrayList<String> arr_id = new ArrayList<String>();
			String id_uri =  uribase+ "/" + "NewsArticle";
			PageResponse  page_exists= defaultClient.get()
					.uri(id_uri)
					.retrieve()
					.body(PageResponse.class);
			System.out.println(page_exists.data);
			RDesc[] data_arr = page_exists.data;
			System.out.println(data_arr.length);
			int i = 0;
			while (i <(data_arr.length))
			{
				System.out.println(data_arr[i].name() + ","+ i);
				arr_id.add(data_arr[i].name());
				i++;
			}
			int j = 0;
			while (j < (arr_id.size()))
			{
				Page x = pull_request(arr_id.get(j));
				//System.out.println(x);
				news_arr.add((NewsArticle)x);
				j++;
			}
			
			return news_arr;
		}
		//Pull all jobposting entities
				public static ArrayList<Page> pull_JobPosting()
				{
					ArrayList<Page> job_arr = new ArrayList<Page>();
					ArrayList<String> arr_id = new ArrayList<String>();
					String id_uri =  uribase+ "/" + "JobPosting";
					PageResponse  page_exists= defaultClient.get()
							.uri(id_uri)
							.retrieve()
							.body(PageResponse.class);
					System.out.println(page_exists.data);
					RDesc[] data_arr = page_exists.data;
					System.out.println(data_arr.length);
					int i = 0;
					while (i <(data_arr.length))
					{
						System.out.println(data_arr[i].name() + ","+ i);
						arr_id.add(data_arr[i].name());
						i++;
					}
					int j = 0;
					while (j < (arr_id.size()))
					{
						Page x = pull_request(arr_id.get(j));
						//System.out.println(x);
						job_arr.add((JobPosting)x);
						j++;
					}
					
					return job_arr;
				}
	//Pull all entities based on ids
				public static ArrayList<Page> pull_entities(ArrayList<String> arr)
				{
					ArrayList<Page> entity_arr = new ArrayList<Page>();
					
					for (int i = 0; i < arr.size(); i++)
					{
						Page x = pull_request(arr.get(i));
						entity_arr.add(x);
					}
					return entity_arr;
				}


}
