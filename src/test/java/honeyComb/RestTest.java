package honeyComb;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClientException;

import honeyComb.RestStorage.RResponseDesc;

class RestTest
{
	Person A;
	Person B;
	Person C;
	Person D;
	Company Meta;
	Company Amazon;
	Skill Python;
	Skill Java;
	Project Ice;
	Project Fire;
	JobPosting SWE;
	JobPosting DA;
	NewsArticle WA;
	NewsArticle NY;
	RResponseDesc result;
	RResponseDesc Person;
	RResponseDesc Company;
	RResponseDesc Skill;
	RResponseDesc NewsArticle;
	RResponseDesc JobPosting;
	RResponseDesc Project;
	

	@BeforeEach
	void setUp() throws Exception
	{
		A = new Person("Alice", "Fun", "she/her", "coolalice@gmail.com", "859-000-0000");
		A = new Person("Alice", "Fun", "she/her", "coolalice@gmail.com", "859-000-0000");
		B = new Person("Bob", "Techie", "he/him", "bob@gmail.com", "123-456-7890");
		C = new Person("Helen", "Student", "they/them", "helen@gmail.com","859-691-9812");
		D = new Person("Rose", "Programmer", "she/her", "rose@gmail.com", "000-111-9812");
		Meta = new Company("Meta", "Stuff with social media");
		Amazon = new Company("Amazon", "Fueling shopping addiction");
		Python = new Skill("Python", "Not a snake");
		Java = new Skill("Java", "Another Programming language");
		Ice = new Project("Ice","Hot project!");
		Fire = new Project("Fire", "Cool project with tons of stuff");
		SWE = new JobPosting("SWE", "Can build stuff!");
		DA = new JobPosting("DA", "Work with data!");
		NY = new NewsArticle("AI Boom", "Billionth Article about AI");
		WA = new NewsArticle("Global Warming", "We're all dying");
	
		result = RestStorage.createProductShell();
		Person = RestStorage.create_Pages("Person");
		Company = RestStorage.create_Pages("Company");
		Skill = RestStorage.create_Pages("Skill");
		NewsArticle = RestStorage.create_Pages("NewsArticle");
		Project = RestStorage.create_Pages("Project");
		JobPosting = RestStorage.create_Pages("JobPosting");
		A.addExternalLink("Github");
		A.addExternalLink("LinkedIn");
		System.out.println(A.getExternalLinks());
		/*RestStorage.createProductShell();
		String[] page_classes = {"Person","Company","Skill","NewsArticle","Project","JobPosting"};
		
		for(int i = 0; i < page_classes.length; i++)
		{
			RestStorage.create_Pages(page_classes[i]);
		}*/
		

	}


	@Test
	void test_rest()
	{
		assertEquals("true",result.successful());
		assertEquals("true", Person.successful());
		assertEquals("true", Company.successful());
		assertEquals("true", Skill.successful());
		assertEquals("true", NewsArticle.successful());
		assertEquals("true", Project.successful());
		assertEquals("true", JobPosting.successful());
		
		RestStorage.push_request(A);
		RestStorage.push_request(B);
		RestStorage.push_request(C);
		RestStorage.push_request(A);
		
		RestStorage.push_request(Ice);
		RestStorage.push_request(Fire);
		
		RestStorage.push_request(Python);
		RestStorage.push_request(Java);
		
		RestStorage.push_request(SWE);
		RestStorage.push_request(DA);
		
		RestStorage.push_request(Meta);
		RestStorage.push_request(Amazon);
		
		RestStorage.push_request(WA);
		RestStorage.push_request(NY);
		Object x = RestStorage.pull_request(A.getId());
		
		assertEquals("Alice", ((Person) x).getName());
		assertEquals("Fun", ((Person)x).getDescription());
		assertEquals("she/her", ((Person)x).getPronouns());
		assertEquals("coolalice@gmail.com", ((Person)x).getEmail());
		assertEquals("859-000-0000", ((Person)x).getPhone());
		assert(((Person)x).getPage_links().isEmpty());
		System.out.println(((Person) x).getExternalLinks());
		try
		{
			A.addLink("project", Ice);
			A.addLink("follower", C);
			A.addLink("employer", Amazon);
			A.addLink("friend", B);
			A.addLink("skill", Python);
			A.addLink("project", Fire);
			A.addLink("news_article", NY);
			A.addLink("mentor",C);
		} catch (ClassIncompatibleException e)
		{
			e.printStackTrace();
			fail("threw exception!");
		}
		HashMap<String, ArrayList<String>> mock = new HashMap<String,ArrayList<String>>();
		ArrayList<String> vals1 = new ArrayList <String>();
		ArrayList<String> vals2 = new ArrayList <String>();
		ArrayList<String> vals3 = new ArrayList <String>();
		ArrayList<String> vals4 = new ArrayList <String>();
		ArrayList<String> vals5 = new ArrayList <String>();
		ArrayList<String> vals6 = new ArrayList <String>();
		vals1.add(C.getId());
		vals2.add(NY.getId());
		vals3.add(Python.getId());
		vals4.add(B.getId());
		vals5.add(Ice.getId());
		vals5.add(Fire.getId());
		vals6.add(Amazon.getId());
		mock.put("mentor", vals1);
		mock.put("follower", vals1);
		mock.put("news_article", vals2);
		mock.put("skill", vals3);
		mock.put("friend", vals4);
		mock.put("project", vals5);
		mock.put("employer", vals6);
		
		A.setName("Mariam");
		A.addExternalLink("Instagram");
		A.addExternalLink("Facebook");
		RestStorage.update_request(A);
		
		String[] roles_is = {"mentor", "contributor", "employee", "editor", "follower", "applicant", "friend", "viewer"};
		String[] roles_has = {"skill", "employer", "project", "news_article", "follower", "friend", "viewer", "editor", "mentor", "job_posting"};
		assertArrayEquals(roles_is, ((Person)x).getRolesIs());
		assertArrayEquals(roles_has, ((Person)x).getRolesHas());	
	
		Object x2 = RestStorage.pull_request(A.getId());
		Page x3 = RestStorage.pull_request("55555");
		assertEquals(null,x3);
		assertEquals("Mariam", ((Person) x2).getName());
		ArrayList <String> expected = new ArrayList <String>();
		expected.add("Github");
		expected.add("LinkedIn");
		expected.add("Instagram");
		expected.add("Facebook");
		assertEquals(4,((Person) x2).getExternalLinks().size());
		assertTrue(((Person) x2).getExternalLinks().equals(expected));
		assert(((Person) x2).getPage_links().containsKey("follower"));
		assert(((Person) x2).getPage_links().containsKey("mentor"));
		assert(((Person) x2).getPage_links().containsKey("mentor"));
		assertFalse(((Person) x2).getPage_links().containsKey("contributor"));
		assertTrue(((Person) x2).getPage_links().keySet().equals(mock.keySet()));
		assertEquals(vals6, ((Person) x2).getPage_links().get("employer"));
		assertEquals(vals1, ((Person) x2).getPage_links().get("follower"));
		assertEquals(vals1, ((Person) x2).getPage_links().get("mentor"));
		assertEquals(((Person) x2).getPage_links().get("project"), vals5);
		assertEquals(vals2, ((Person) x2).getPage_links().get("news_article"));
		assertEquals(vals3, ((Person) x2).getPage_links().get("skill"));		
		
		ArrayList <String> output = new ArrayList<String>();
		output = RestStorage.pull_page("Person");
		System.out.println(output);
		ArrayList <String> output2 = new ArrayList<String>();
		output2.add(A.getId());
		output2.add(B.getId());
		output2.add(C.getId());
		System.out.println(output2);
		assertTrue(output.containsAll(output2) && output2.containsAll(output));

	}
	
	@Test
	void test_Company()
	{
		RestStorage.push_request(Meta);
		RestStorage.push_request(Amazon);
		RestStorage.push_request(Amazon);
		String[] roles_is = { "contributor", "employer"};
		String[] roles_has = { "employee", "project", "job_posting", "follower", "news_article", "viewer", "mentor", "editor"};
		Object x = RestStorage.pull_request(Meta.getId());
		assertEquals("Meta", ((Company) x).getName());
		assertEquals(Meta.getId(), ((Company) x).getId());
		assertArrayEquals(roles_is, ((Company) x).getRolesIs());
		assertArrayEquals(roles_has, ((Company) x).getRolesHas());
		Meta.addExternalLink("Instagram");
		ArrayList <String> externLink = new ArrayList <String>();
		externLink.add("Instagram");
		Meta.setName("Metaverse");
		RestStorage.update_request(Meta);
		Object x2 = RestStorage.pull_request(Meta.getId());
		assertEquals("Metaverse", ((Company) x2).getName());
		assertTrue(externLink.equals(((Company) x2).getExternalLinks()));	
		
	}
	
	@Test
	void test_Skill()
	{
		 String[] roles_is = { "skill"};
	     String[] roles_has =  { "editor","following", "mentor", "viewer"};
	     
	    RestStorage.push_request(Python);
		RestStorage.push_request(Java);
		Object x = RestStorage.pull_request(Python.getId());
		assertArrayEquals(((Skill)x).getRolesHas(), roles_has);
		assertArrayEquals(((Skill)x).getRolesIs(), roles_is);
		
	}
	@Test
	void test_Project()
	{
		
		String[] roles_is = {"project"};
		String[] roles_has =  { "editor","contributor", "follower", "mentor", "viewer"};
	     
	    RestStorage.push_request(Fire);
		RestStorage.push_request(Ice);
		Object x = RestStorage.pull_request(Fire.getId());
		assertArrayEquals(((Project)x).getRolesHas(), roles_has);
		assertArrayEquals(((Project)x).getRolesIs(), roles_is);
		
		Fire.setName("Fired");
		RestStorage.update_request(Fire);
		Object x2 = RestStorage.pull_request(Fire.getId());
		assertEquals("Fired", ((Project)x2).getName());	
	}
	@Test
	void test_NewsArticle()
	{
		String[] roles_is = {"news_article"};
		String[] roles_has = { "editor","contributor","mentor","viewer"};
		RestStorage.push_request(NY);
		RestStorage.push_request(WA);
		Object x = RestStorage.pull_request(WA.getId());
		assertArrayEquals(((NewsArticle)x).getRolesHas(), roles_has);
		assertArrayEquals(((NewsArticle)x).getRolesIs(), roles_is);
	}
	
	@Test
	void test_JobPosting()
	{
		String[] roles_is = { "job_posting"};
		String[] roles_has =  { "editor","applicant", "skill", "mentor", "viewer", "contributor"};
		RestStorage.push_request(SWE);
		RestStorage.push_request(DA);
		Object x = RestStorage.pull_request(SWE.getId());
		assertArrayEquals(((JobPosting)x).getRolesHas(), roles_has);
		assertArrayEquals(((JobPosting)x).getRolesIs(), roles_is);
	}
	

	




}
