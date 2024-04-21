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
	//@Test
	void testPerson()
	{
		assertEquals("Person: Alice, Fun, she/her, coolalice@gmail.com, 859-000-0000", A.toString());
		assertEquals("Person: Bob, Techie, he/him, bob@gmail.com, 123-456-7890", B.toString());
		assertEquals("Helen", C.getName());
		assertEquals("Student", C.getDescription());
		assertEquals("they/them", C.getPronouns());
		assertEquals("helen@gmail.com", C.getEmail());
		assertEquals("859-691-9812", C.getPhone());
		
		String[] person_is= {"mentor", "contributor", "employee", "editor", "follower", "applicant", "friend", "viewer"};
		String[] person_has = {"skill", "employer", "project", "news_article", "follower", "friend", "viewer", "editor", "mentor", "job_posting"};
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
		
		assert(D.page_links.isEmpty());
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
			
			Meta.addLink("follower", A);
			Meta.addLink("employee", C);
			Meta.addLink("job_posting", SWE);
			Meta.addLink("news_article", NY);
			Meta.addLink("project", Fire);
			Meta.addLink("mentor", A);
			
			Ice.addLink("contributor", Meta);
			Ice.addLink("editor", B);
			Ice.addLink("follower", A);
			Ice.addLink("mentor", C);
			
			SWE.addLink("skill", Java);	
			DA.addLink("applicant", A);
			DA.addLink("skill", Python);
			SWE.addLink("editor", C);
			SWE.addLink("contributor", B);
		
			Meta.addLink("news_article", WA);
			Meta.addLink("employee", C);
			Meta.addLink("follower", A);
			Meta.addLink("project", Ice);
			Meta.addLink("job_posting", SWE);
			Meta.addLink("editor", B);
			
			NY.addLink("editor", B);
			NY.addLink("contributor", Meta);
			WA.addLink("mentor", A);
		
		} catch (ClassIncompatibleException e)
		{

			e.printStackTrace();
			fail("threw exception!");
		}
	}
	    //The following test-cases fail as we are trying to add roles that are not compatible with the class! Part of testing
	    
	@Test
	void exception_page_links()
	{
		HashMap<String, ArrayList<String>> mock = new HashMap<String,ArrayList<String>>();
		ArrayList<String> vals1 = new ArrayList <String>();
		ArrayList<String> vals2 = new ArrayList <String>();
		ArrayList<String> vals3 = new ArrayList <String>();
		ArrayList<String> vals4 = new ArrayList <String>();
	//Case: 1
		assertThrows(ClassIncompatibleException.class,  
				() -> {A.addLink("project", NY);}
				);
		
		
		assertThrows(ClassIncompatibleException.class,  
				() -> {DA.addLink("skill", A); }
				);
		
		assertThrows(ClassIncompatibleException.class,  
				() -> {Meta.addLink("employer", Amazon);}
				);
		
		
		assertThrows(ClassIncompatibleException.class,  
				() -> {Python.addLink("skill", A); }
				);
		
		
		assertThrows(ClassIncompatibleException.class,  
				() -> {Meta.addLink("employee", Amazon);}
				);
		
		assertThrows(ClassIncompatibleException.class,  
				() -> {Ice.addLink("contributor", Python); }
				);
		
		assertThrows(ClassIncompatibleException.class,  
				() -> {Fire.addLink("contributor", SWE);}
				);
		
		vals1.add(A.getId());
		vals1.add(B.getId());
		vals1.add(C.getId());
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
			D.addLink("project", Ice);
			assertEquals(3,D.getPage_links().size());
			D.removeLink("follower", A);
			
			//assertEquals(mock,D.getPage_links()); -->This becomes false now since we successfully removed A from follower
			D.removeLink("employer", Amazon);
			assertEquals(3,D.getPage_links().size());
			assert(D.page_links.containsKey("follower"));
			assert(D.page_links.containsKey("employer"));
			assert(D.page_links.containsKey("project"));
			assertEquals(vals3, D.page_links.get("employer"));
			D.removeLink("employer", Amazon);
			assertEquals(vals3, D.page_links.get("employer"));
			D.removeLink("mentor", A);
			mock.put("employer", vals2);
			mock.put("project", vals4);
			assertTrue(D.getPage_links().keySet().equals(mock.keySet()));
				
		} catch (ClassIncompatibleException e)
		{
	
			e.printStackTrace();
			System.out.println("threw exception!!");
		}
		
	
		assertFalse(D.page_links.containsKey("news_article")); //Checking with a key that does not exist
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
		String[] roles_is = { "contributor", "employer"};
		String[] roles_has = { "employee", "project", "job_posting", "follower", "news_article", "viewer", "mentor", "editor"};
		assertArrayEquals(Amazon.getRolesHas(), roles_has);
		assertArrayEquals(Meta.getRolesIs(), roles_is);
	}
	@Test
	void test_Project()
	{
		String[] roles_is = {"project"};
		String[] roles_has =  { "editor","contributor", "follower", "mentor", "viewer"};
		assertArrayEquals(Fire.getRolesHas(), roles_has);
		assertArrayEquals(Ice.getRolesIs(), roles_is);
	}
	@Test
	void test_Skill()
	{
		 String[] roles_is = { "skill"};
	     String[] roles_has =  { "editor","following", "mentor", "viewer"};
		assertArrayEquals(Python.getRolesHas(), roles_has);
		assertArrayEquals(Java.getRolesIs(), roles_is);
	}
	@Test
	void test_NewsArticle()
	{
		String[] roles_is = {"news_article"};
		String[] roles_has = { "editor","contributor","mentor","viewer"};
		assertArrayEquals(WA.getRolesHas(), roles_has);
		assertArrayEquals(NY.getRolesIs(), roles_is);
	}
	
	@Test
	void test_JobPosting()
	{
		String[] roles_is = { "job_posting"};
		String[] roles_has =  { "editor","applicant", "skill", "mentor", "viewer", "contributor"};
		assertArrayEquals(SWE.getRolesHas(), roles_has);
		assertArrayEquals(DA.getRolesIs(), roles_is); 
	}
	@Test
	void test_viewPermission()
	{
		ArrayList<Page> empty_arr = new ArrayList <Page>();
		assertTrue(A.canView(Amazon));
		try
		{
			Amazon.addLink("viewer",B);
		} catch (ClassIncompatibleException e)
		{
			e.printStackTrace();
		}
		System.out.println(B.getId());
		assertFalse(A.canView(Amazon));
		assertTrue(B.canView(Amazon));
		
		try
		{
			Python.addLink("viewer", B);
			Python.removeLink("viewer", B);
		} catch (ClassIncompatibleException e)
		{
			e.printStackTrace();
		}
		assert(Python.getPage_links().containsKey("viewer"));
		assertEquals(empty_arr, Python.getPage_links().get("viewer"));
		assertTrue(A.canView(Python));		
	}
	@Test
	void test_editPermission() 
	{
		try
		{
			Fire.addLink("editor", A);
		} catch (ClassIncompatibleException e)
		{
			e.printStackTrace();
			fail("Shouldn't happen!");
		}
		try
		{
			assertTrue(A.canEdit(Fire));
		} catch (ClassIncompatibleException e)
		{

			e.printStackTrace();
			fail("Shouldn't happen!");
		}
		try
		{
			assertFalse(B.canEdit(Fire));
		} catch (ClassIncompatibleException e)
		{
			e.printStackTrace();
			fail("Shouldn't happen!");
		}
	
			//assertTrue(Python.page_links.get("editor"));
			//assert(Python.getPage_links().containsKey("editor"));
		
			  try
			{
				Python.addLink("editor", A);
			} catch (ClassIncompatibleException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		   // Python.addLink("viewer", B);
		    Python.removeLink("editor", A);
			assertTrue(Python.getLink("editor"));
			//assertTrue(Python.getLink("editor"));
			try
			{
				assertFalse(B.canEdit(Python));
			} catch (ClassIncompatibleException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		assertThrows(ClassIncompatibleException.class,  
				() -> {A.canEdit(NY);}
				);
		assertFalse(Fire.getLink("mentor"));
		assertTrue(Fire.getLink("editor"));
		
	}
	
	
	
	
		
}
