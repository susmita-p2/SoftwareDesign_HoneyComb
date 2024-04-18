package honeyComb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import honeyComb.PullTypes.PersonResponse;
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
		A.addLink("project", "2");
		
		/*result = RestStorage.createProductShell();
		Person = RestStorage.create_Pages("Person");
		Company = RestStorage.create_Pages("Company");
		Skill = RestStorage.create_Pages("Skill");
		NewsArticle = RestStorage.create_Pages("NewsArticle");
		Project = RestStorage.create_Pages("Project");
		JobPosting = RestStorage.create_Pages("JobPosting");*/
		RestStorage.createProductShell();
		String[] page_classes = {"Person","Company","Skill","NewsArticle","Project","JobPosting"};
		
		for(int i = 0; i < page_classes.length; i++)
		{
			RestStorage.create_Pages(page_classes[i]);
		}
		

	}

	/*@Test
	void test_classes()
	{
		assertEquals("true",result.successful());
		assertEquals("true", Person.successful());
		assertEquals("true", Company.successful());
		assertEquals("true", Skill.successful());
		assertEquals("true", NewsArticle.successful());
		assertEquals("true", Project.successful());
		assertEquals("true", JobPosting.successful());
	}*/
	/*@Test
	void testPushAndUpdate()
	{
		
		assertEquals("true", RestStorage.push_request(A));
		assertEquals("true",RestStorage.push_request(B));
		assertEquals("true",RestStorage.push_request(Amazon));
		assertEquals("true",RestStorage.push_request(Python));
		assertEquals("true",RestStorage.push_request(NY));
		assertEquals("true",RestStorage.push_request(Ice));
		assertEquals("true",RestStorage.push_request(SWE));
		assertEquals("false", RestStorage.push_request(A));
		try
		{
			A.addLink("project", Ice);
			A.addLink("follower", B);
			A.addLink("follower", C);
			A.addLink("employer", Amazon);
			A.addLink("friend", B);
			A.addLink("skill", Python);
			A.addLink("project",Ice);
			A.addLink("news_article", NY);
			A.addLink("mentor",C);
		} catch (ClassIncompatibleException e)
		{
			e.printStackTrace();
			fail("threw exception!");
		}
		Amazon.addExternalLink("BlogPost");
		assertEquals("true",RestStorage.update_request(A).successful());
		assertEquals("true",RestStorage.update_request(Amazon).successful());
		assertEquals("false",RestStorage.update_request(C).successful());
	}*/
	@Test
	void test_get()
	{
		RestStorage.push_request(A);
		
		Object x = RestStorage.pull_request("1");
		
		assertEquals("Alice", ((Person) x).getName());
		assertEquals("Fun", ((Person)x).getDescription());
		assertEquals("she/her", ((Person)x).getPronouns());
		assertEquals("coolalice@gmail.com", ((Person)x).getEmail());
		assertEquals("859-000-0000", ((Person)x).getPhone());
		//assert(((Person)x).getPage_links().isEmpty());
		try
		{
			//A.addLink("project", Ice);
			A.addLink("follower", "2");
			/*A.addLink("follower", C);
			A.addLink("employer", Amazon);
			A.addLink("friend", B);
			A.addLink("skill", Python);
			A.addLink("project",Ice);
			A.addLink("news_article", NY);
			A.addLink("mentor",C);*/
		} catch (ClassIncompatibleException e)
		{
			e.printStackTrace();
			fail("threw exception!");
		}
		A.getExternalLinks().add("Github");
		A.setName("Mariam");
		RestStorage.update_request(A);
		String[] roles_is = {"mentor", "contributor", "employee", "editor", "follower", "applicant", "friend", "viewer"};
		String[] roles_has = {"skill", "employer", "project", "news_article", "follower", "friend", "viewer", "editor", "mentor", "job_posting"};
		assertArrayEquals(roles_is, ((Person)x).getRoles_is());
		assertArrayEquals(roles_has, ((Person)x).getRoles_has());	
		
		RestStorage.pull_request("1");
		//Object x2 = RestStorage.pull_request("1");
		//assertEquals("Bob", ((Person) x).getName());
		//assert(((Person)x).getPage_links().containsKey("follower"));
		
		
	}
	



}
