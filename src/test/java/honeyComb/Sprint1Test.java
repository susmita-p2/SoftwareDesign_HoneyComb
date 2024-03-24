package honeyComb;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Sprint1Test
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
	
	
	
	@BeforeEach
	void setUp() throws Exception
	{
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
	}

	//Tests Person class 
	@Test
	void testPerson()
	{
		assertEquals("Person: Alice, Fun, she/her, coolalice@gmail.com, 859-000-0000", A.toString());
		assertEquals("Person: Bob, Techie, he/him, bob@gmail.com, 123-456-7890", B.toString());
		assertEquals("Helen", C.getName());
		assertEquals("Student", C.getDescription());
		assertEquals("they/them", C.getPronouns());
		assertEquals("helen@gmail.com", C.getEmail());
		assertEquals("859-691-9812", C.getPhone());
		
		String[] person_is = {"mentor", "contributor", "employee", "editor", "follower", "applicant", "following"};
		String[] person_has = {"skill", "employer", "project", "news_article", "follower", "following"};
		System.out.println(A.getRolesIs());
		assertArrayEquals(person_is,A.getRolesIs());
		assertArrayEquals(person_has,A.getRolesHas());
		
		//Tested with multiple modified arrays of roles
		//assertArrayEquals(person_has,A.getRolesIs());
		//assertArrayEquals(person_is,A.getRolesHas());
	}
	
	@Test 
	void test_external_links()
	{
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Github");
		expected.add("Instagram");
		
		C.addExternalLink("Github");
		C.addExternalLink("LinkedIn");
		C.addExternalLink("Github");
		C.addExternalLink("Github");
		
		assertEquals(2, C.getExternalLinks().size());
		
		//assertTrue(expected.equals(C.getExternalLinks()));
		C.removeExternalLink("LinkedIn");
		//assertTrue(expected.equals(C.getExternalLinks()));
		C.removeExternalLink("Facebook");
		C.addExternalLink("Instagram");
		assertTrue(expected.equals(C.getExternalLinks()));
		
	}
	@Test
	void test_Page_Links()
	{
		HashMap<String, ArrayList<Page>> mock = new HashMap<String,ArrayList<Page>>();
		ArrayList<Page> vals1 = new ArrayList <Page>();
		ArrayList<Page> vals2 = new ArrayList <Page>();
		ArrayList<Page> vals3 = new ArrayList <Page>();
		ArrayList<Page> vals4 = new ArrayList <Page>();
		assert(D.page_links.isEmpty());
	    try
		{
			A.addLink("project", Ice);
			A.addLink("follower", B);
			A.addLink("follower", C);
			A.addLink("employer", Amazon);
			A.addLink("following", B);
			A.addLink("following", Amazon);
			A.addLink("project",Ice);
			A.addLink("news_article", NY);
			
			Meta.addLink("follower", A);
			Meta.addLink("employee", C);
			Meta.addLink("job_posting", SWE);
			Meta.addLink("news_article", NY);
			Meta.addLink("project", Fire);
			
			Ice.addLink("contributor", Meta);
			Ice.addLink("editor", B);
			Ice.addLink("follower", A);
			
			SWE.addLink("skill", Java);	
			DA.addLink("applicant", A);
			DA.addLink("skill", Python);
			SWE.addLink("editor", C);
		
			Meta.addLink("news_article", WA);
			Meta.addLink("employee", C);
			Meta.addLink("follower", A);
			Meta.addLink("project", Ice);
			
			NY.addLink("editor", B);
			NY.addLink("contributor", Meta);
			WA.addLink("follower", A);
		
		} catch (ClassIncompatibleException e)
		{

			e.printStackTrace();
			fail("threw exception!");
		}
	    
	    //The following test-cases fail as we are trying to add roles that are not compatible with the class! Part of testing
	    
	    /*try
			{
				A.addLink("project", NY); //News article cannot be added as Project
				DA.addLink("skill", A);  //Person is not a skill
				Python.addLink("skill", A); //Skill page doesn't have a skill section
				Meta.addLink("employer", Amazon); //Company cannot have an employer
				Meta.addLink("employee", Amazon);// Company cannot be a employee
				Fire.addLink("contributor", SWE); //Only Person and Company can be contributor
			    Ice.addLink("contributor", Python); //Skill cannot be a contributor
			    A.addLink("Following", NY);// Only Person and Company are followable
			     
				
			} catch (ClassIncompatibleException e)
			{
				e.printStackTrace();
				fail("threw exception!");
			}*/
		vals1.add(A);
		vals1.add(B);
		vals1.add(C);
		mock.put("follower", vals1);
		try
		{
			D.addLink("follower", A);
			D.addLink("follower", B);
			D.addLink("follower", C);
			D.addLink("follower",C);
			D.addLink("follower", C);
			assertEquals(1,D.getPage_links().size());
			assertEquals(mock,D.getPage_links());
			D.addLink("employer", Amazon);
			D.addLink("following", Amazon);
			D.addLink("project", Ice);
			assertEquals(4,D.getPage_links().size());
			D.removeLink("follower", A);
			
			//assertEquals(mock,D.getPage_links()); -->This becomes false now since we successfully removed A from follower
			D.removeLink("employer", Amazon);
			D.removeLink("following", Meta);
			assertEquals(4,D.getPage_links().size());
			assert(D.page_links.containsKey("follower"));
			assert(D.page_links.containsKey("employer"));
			assert(D.page_links.containsKey("following"));
			mock.put("employer", vals2);
			mock.put("following", vals3);
			mock.put("project", vals4);
			assertTrue(D.getPage_links().keySet().equals(mock.keySet()));
			
			
			
		} catch (ClassIncompatibleException e)
		{
	
			e.printStackTrace();
		}
		
		//assert(D.page_links.containsKey("news_article")); //Checking with a key that does not exist
	}

	@Test
	void test_IDGenerator()
	{
		IDGenerator id = IDGenerator.getInstance();
		String ID1=id.getNextID();
	
		int i = 0;
		while(i < 10)
		{
		
			String ID2 = id.getNextID();
			assertEquals(Integer.parseInt(ID1)+1, Integer.parseInt(ID2));
			ID1 = ID2;	
			i++;	
		}
		
	}
	@Test
	void test_Company()
	{
		assertEquals("Amazon", Amazon.getName());
		assertEquals("Stuff with social media", Meta.getDescription());
		String[] roles_is = { "contributor", "employer", "following"};
		String[] roles_has = { "employee", "project", "job_posting", "follower", "news_article"};
		assertArrayEquals(Amazon.getRolesHas(), roles_has);
		assertArrayEquals(Meta.getRolesIs(), roles_is);
	}
	@Test
	void test_Project()
	{
		String[] roles_is = {"project"};
		String[] roles_has = { "editor","contributor", "follower"};
		assertArrayEquals(Fire.getRolesHas(), roles_has);
		assertArrayEquals(Ice.getRolesIs(), roles_is);
	}
	@Test
	void test_Skill()
	{
		 String[] roles_is = { "skill"};
	     String[] roles_has = { "editor","following"};
		assertArrayEquals(Python.getRolesHas(), roles_has);
		assertArrayEquals(Java.getRolesIs(), roles_is);
	}
	@Test
	void test_NewsArticle()
	{
		String[] roles_is = {"news_article"};
		String[] roles_has = { "editor","contributor", "follower"};
		assertArrayEquals(WA.getRolesHas(), roles_has);
		assertArrayEquals(NY.getRolesIs(), roles_is);
	}
	
	@Test
	void test_JobPosting()
	{
		String[] roles_is = { "job_posting"};
		String[] roles_has = { "editor","applicant", "skill"};
		assertArrayEquals(SWE.getRolesHas(), roles_has);
		assertArrayEquals(DA.getRolesIs(), roles_is);
	}
	
	
	
	
		
}
