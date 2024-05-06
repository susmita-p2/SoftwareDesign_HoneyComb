package honeyComb;

import static org.junit.jupiter.api.Assertions.fail;

import model.ClassIncompatibleException;
import model.Company;
import model.JobPosting;
import model.NewsArticle;
import model.Person;
import model.Project;
import model.RestStorage;
import model.Skill;

public class PopulateRest {
	
	
	public static void main(String[] args)
	{
		RestStorage.createProductShell();
		String[] page_classes = {"Person","Company","Skill","NewsArticle","Project","JobPosting"};
		
		for(int i = 0; i < page_classes.length; i++)
		{
			RestStorage.create_Pages(page_classes[i]);
		}
		Skill Python;
		Skill Java;
		Project Ice;
		Project Fire;
		JobPosting SWE;
		JobPosting DA;
		NewsArticle WA;
		NewsArticle NY;
		Person A = new Person("Alice", "Fun", "she/her", "coolalice@gmail.com", "859-000-0000");
		Person B = new Person("Bob", "Techie", "he/him", "bob@gmail.com", "123-456-7890");
		
		
		Company Meta = new Company("Meta", "Stuff with social media");
		Company Amazon = new Company("Amazon", "Fueling shopping addiction");
		Python = new Skill("Python", "Not a snake");
		Java = new Skill("Java", "Another Programming language");
		Ice = new Project("Ice","Hot project!");
		Fire = new Project("Fire", "Cool project with tons of stuff");
		SWE = new JobPosting("SWE", "Can build stuff!", null);
		DA = new JobPosting("DA", "Work with data!", null);
		NY = new NewsArticle("NY: AI Boom", "Billionth Article about AI");
		WA = new NewsArticle("WA:Global Warming", "We're all dying");
		try
		{
			A.addLink("project", Ice);
			A.addLink("follower", B);
			A.addLink("employer", Amazon);
			A.addLink("friend", B);
			A.addLink("skill", Python);
			A.addLink("project", Fire);
			A.addLink("news_article", NY);
			A.addLink("mentor",B);
		} catch (ClassIncompatibleException e)
		{
			e.printStackTrace();
			fail("threw exception!");
		}
		RestStorage.push_request(A);
		RestStorage.push_request(B);
		RestStorage.push_request(Meta);
		RestStorage.push_request(Amazon);
		RestStorage.push_request(Python);
		RestStorage.push_request(Java);
		RestStorage.push_request(Meta);
		RestStorage.push_request(NY);
		RestStorage.push_request(Meta);
		RestStorage.push_request(WA);
		RestStorage.push_request(NY);
		RestStorage.push_request(Fire);
		RestStorage.push_request(SWE);
		RestStorage.push_request(Ice);
	}

}
