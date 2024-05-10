package honeyComb;

import static org.junit.jupiter.api.Assertions.fail;

import model.AllRecommender;
import model.ClassIncompatibleException;
import model.Company;
import model.IDGenerator;
import model.JobPosting;
import model.NewsArticle;
import model.Person;
import model.Project;
import model.RestStorage;
import model.Skill;
import model.SkillRecommender;

public class PopulateRest {
	
	
	public static void main(String[] args)
	{
		IDGenerator.getInstance().reset();
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
		//
		NewsArticle WA;
		NewsArticle NY;
		Person A = new Person("Alice", "Fun", "she/her", "coolalice@gmail.com", "859-000-0000");
		Person B = new Person("Bob", "Techie", "he/him", "bob@gmail.com", "123-456-7890");
		Person C = new Person("Helen", "Student", "they/them", "helen@gmail.com","859-691-9812");
		Person D = new Person("Mike", "Student", "they/them", "helen@gmail.com","859-691-9812");
		
		Person E = new Person("Rose", "Fun", "she/her", "coolalice@gmail.com", "859-000-0000");
		Person F = new Person("Billy", "Techie", "he/him", "bob@gmail.com", "123-456-7890");
		Person G = new Person("Ross", "Student", "they/them", "helen@gmail.com","859-691-9812");

		
		Company Meta = new Company("Meta", "Stuff with social media");
		Company Amazon = new Company("Amazon", "Fueling shopping addiction");
		Company Apple = new Company("Apple", "You know what it is");
		Company Verizon= new Company("Verizon", "Connection");
		Company Google =new Company("Google", "Know-it-all");
		Company LinkedIn =new Company("LinkedIn", "Connect people");
		Company HoneyComb =new Company("HoneyComb", "Start-up");
		Skill PHP =  new Skill("PHP", "Make Databases");
		Skill SQL = new Skill("SQL", "Data Science");
		Skill R = new Skill("R", "More data science");
		Skill CSS = new Skill("CSS", "Front-end coding");
		Skill Figma = new Skill("Figma", "Cute projects");
		Python = new Skill("Python", "Not a snake");
		Java = new Skill("Java", "Another Programming language");
		Ice = new Project("Ice","Hot project!");
		Fire = new Project("Fire", "Cool project with tons of stuff");
		SWE = new JobPosting("SWE", "Can build stuff!", null);
		//DA = new JobPosting("DA", "Work with data!", null);
		NY = new NewsArticle("NY: AI Boom", "Billionth Article about AI");
		WA = new NewsArticle("WA:Global Warming", "We're all dying");
		JobPosting News_Anchor = new JobPosting("News_Anchor","speaking and hosting", new AllRecommender());
		JobPosting Professor = new JobPosting("Professor","Teaching magic", new AllRecommender());
		JobPosting engineer = new JobPosting("Engineer","Build stuff", new SkillRecommender());
		JobPosting fairy = new JobPosting("Fairy","do cool magic stuff", new AllRecommender());
		Skill flying = new Skill("Flying", "should be able to learn how to fly");
		Skill magic = new Skill("Kindness for all", "fairies must be kind");
		
		try
		{
			A.addLink("project", Ice);
			A.addLink("follower", B);
			A.addLink("follower", C);
			A.addLink("follower", D);
			B.addLink("editor", A);
			C.addLink("editor", A);
			F.addLink("viewer", B);
			/*A.addLink("friend", C);
			A.addLink("friend", D);
			A.addLink("friend", E);*/
			
			/*A.addLink("follower", E);
			A.addLink("follower", F);
			A.addLink("follower", G);
			A.addLink("follower", H);*/
			A.addLink("employer", Amazon);
			A.addLink("editor", E);
			B.addLink("follower",C);
			A.addLink("employer", Meta);
			A.addLink("friend", B);
			A.addLink("skill", Python);
			A.addLink("skill", Java);
			A.addLink("skill", PHP);
			A.addLink("skill", R);
			A.addLink("skill", CSS);
			B.addLink("employer",Apple);
			A.addLink("employer", Apple);
			Apple.addLink("viewer", B);
			B.addLink("mentor", G);
			B.addLink("friend", C);
			B.addLink("friend", A);
			B.addLink("friend", D);
			B.addLink("friend", E);
			B.addLink("skill", PHP);
			B.addLink("skill", Python);
			C.addLink("mentor", F);
			C.addLink("mentor", G);
			A.addLink("project", Fire);
			A.addLink("news_article", NY);
			A.addLink("mentor",B);
			Amazon.addLink("editor", A);
			Meta.addLink("viewer", B);
			Java.addLink("editor", A);
			Java.addLink("following", B);
			Java.addLink("following", C);
			Java.addLink("following", D);
			SWE.addLink("skill", Python);
			SWE.addLink("applicant",A);
			A.addLink("friend", B);
			A.addLink("friend", C);
			A.addLink("friend", D);
			A.addLink("friend", E);
			A.addLink("friend", F);
			A.addLink("friend", G);
			B.addLink("viewer", A);
			A.addLink("job_posting", SWE);
			A.addLink("job_posting", Professor);
			A.addLink("job_posting", fairy);
			A.addLink("job_posting", engineer);
			A.addLink("job_posting", News_Anchor);
			A.addLink("employer", Amazon);
			A.addLink("employer", Google);
			fairy.addLink("viewer", A);
			fairy.addLink("applicant", D);
			fairy.addLink("applicant", E);
			fairy.addLink("applicant", F);
			fairy.addLink("skill", magic);
			fairy.addLink("skill", flying);
			magic.addLink("editor", A);
			
		} catch (ClassIncompatibleException e)
		{
			e.printStackTrace();
			fail("threw exception!");
		}
		RestStorage.push_request(A);
		RestStorage.push_request(B);
		RestStorage.push_request(C);
		RestStorage.push_request(D);
		RestStorage.push_request(E);
		RestStorage.push_request(F);
		RestStorage.push_request(G);
		RestStorage.push_request(Meta);
		RestStorage.push_request(Amazon);
		RestStorage.push_request(Python);
		RestStorage.push_request(Google);
		RestStorage.push_request(LinkedIn);
		RestStorage.push_request(Verizon);
		RestStorage.push_request(HoneyComb);
		RestStorage.push_request(Apple);
		RestStorage.push_request(Java);
		RestStorage.push_request(Meta);
		RestStorage.push_request(NY);
		RestStorage.push_request(Meta);
		RestStorage.push_request(WA);
		RestStorage.push_request(NY);
		RestStorage.push_request(Fire);
		RestStorage.push_request(SWE);
		RestStorage.push_request(Ice);
		RestStorage.push_request(PHP);
		RestStorage.push_request(Figma);
		RestStorage.push_request(CSS);
		RestStorage.push_request(R);
		RestStorage.push_request(SQL);
		RestStorage.push_request(fairy);
		RestStorage.push_request(Professor);
		RestStorage.push_request(News_Anchor);
		RestStorage.push_request(engineer);
		RestStorage.push_request(flying);
		RestStorage.push_request(magic);
		
		try
		{
			A.addLink("mentor", E);
		} catch (ClassIncompatibleException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestStorage.update_request(A);
	}

}
