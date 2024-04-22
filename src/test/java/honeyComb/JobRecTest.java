package honeyComb;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JobRecTest
{
	Person A;
	Person B;
	Person C;
	Person D;
	Company Meta;
	Company Amazon;
	JobPosting SWE;
	JobPosting DA;
	JobPosting intern;
	JobPosting HR;
	JobPosting dataScientist;
	Skill Python;
	Skill Java;
	Skill PHP;
	Skill Analytics;
	Skill REST_API;
	

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
		PHP = new Skill("PHP",null);
		Analytics = new Skill("Analytics", null);
		REST_API = new Skill("REST_API", null);
		Java = new Skill("Java", "Another Programming language");
		SWE = new JobPosting("SWE", "Can build stuff!", new FollowingRecommender());
		DA = new JobPosting("DA", "Work with data!", new SkillRecommender());
		HR = new JobPosting("HR", "Handles stuff", new AllRecommender());
		intern = new JobPosting("intern", "learn", new SkillRecommender());
		dataScientist = new JobPosting("dataScientist", "some sciency stuff", new SkillRecommender());
		
		RestStorage.createProductShell();
		String[] page_classes = {"Person","Company","Skill","NewsArticle","Project","JobPosting"};
		
		for(int i = 0; i < page_classes.length; i++)
		{
			RestStorage.create_Pages(page_classes[i]);
		}
		String[] roles = SWE.getRolesHas();
		System.out.println(roles[0]);
		
		
		DA.addLink("employer", Meta);
		HR.addLink("employer", Amazon);
		SWE.addLink("employer", Meta);
		A.addLink("following", Meta);
		A.addLink("following", Amazon);
		C.addLink("following", Amazon);
		DA.addLink("skill", PHP);
		B.addLink("skill", PHP);
		B.addLink("skill", Java);
		dataScientist.addLink("skill", PHP);
		dataScientist.addLink("skill", Analytics);
		dataScientist.addLink("skill", Python);
		dataScientist.addLink("skill", REST_API);
		//dataScientist.addLink("skill", Java);
		
		A.addLink("skill", PHP);
		A.addLink("skill", Python);
		A.addLink("skill", Analytics);
		
		
		RestStorage.push_request(A);
		RestStorage.push_request(B);
		RestStorage.push_request(C);
		RestStorage.push_request(D);
		RestStorage.push_request(Python);
		RestStorage.push_request(Java);
		RestStorage.push_request(SWE);
		RestStorage.push_request(DA);
		RestStorage.push_request(HR);
		RestStorage.push_request(Amazon);
		RestStorage.push_request(Meta);
		RestStorage.push_request(intern);
		RestStorage.push_request(dataScientist);
	}

	@Test
	void test()
	{
		HR.recommend();
		
		SWE.recommend();
		DA.recommend();
		intern.recommend();
		dataScientist.recommend();
		
		Page a = RestStorage.pull_request(A.getId());
		Page b = RestStorage.pull_request(B.getId());
		Page c = RestStorage.pull_request(C.getId());
		Page d = RestStorage.pull_request(D.getId());
		ArrayList <String> list_a = new ArrayList <String>();
		ArrayList <String> list_b = new ArrayList <String>();
		ArrayList <String> list_c = new ArrayList <String>();
		
		list_a.add(HR.getId());
		list_a.add(SWE.getId());
		list_a.add(intern.getId());
		list_a.add(dataScientist.getId());
		list_a.add(DA.getId());
		
		list_b.add(HR.getId());
		list_b.add(DA.getId());
		list_b.add(intern.getId());
		
		list_c.add(HR.getId());
		list_c.add(intern.getId());
		
		assertTrue(list_a.containsAll(((Person)a).getPage_links().get("job_posting")) &&  
				((Person)a).getPage_links().get("job_posting").containsAll(list_a));
		
		assertTrue(list_b.containsAll(((Person)b).getPage_links().get("job_posting")) &&  
				((Person)b).getPage_links().get("job_posting").containsAll(list_b));
		
		assertTrue(list_c.containsAll(((Person)c).getPage_links().get("job_posting")) &&  
				((Person)c).getPage_links().get("job_posting").containsAll(list_c));
		
		assertFalse(list_b.containsAll(((Person)d).getPage_links().get("job_posting")) &&  
				((Person)d).getPage_links().get("job_posting").containsAll(list_b));
		//fail("Not yet implemented");
		
		
	}

}
