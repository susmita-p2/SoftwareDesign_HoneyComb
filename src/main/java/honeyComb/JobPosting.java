package honeyComb;

import java.util.ArrayList;

public class JobPosting extends Page
{
	static String[] roles_is = { "job_posting"};
	static String[] roles_has = { "employer","editor","applicant", "skill", "mentor", "viewer", "contributor"};
	Recommender recommender;
	
	public JobPosting(String name, String description, Recommender recommender)
	{
		super(name, description);
		this.recommender = recommender;
	}
	public JobPosting() {}
	@Override
	public String[] getRolesHas()
	{
	
		return roles_has;
	}

	@Override
	public String[] getRolesIs()
	{

		return roles_is;
	}
	/**
	 * @param rolesIs the rolesIs to set
	 */
	public static void setRolesIs(String[] rolesIs)
	{
		roles_is = rolesIs;
	}
	/**
	 * @param rolesHas the rolesHas to set
	 */
	public static void setRolesHas(String[] rolesHas)
	{
		roles_has = rolesHas;
	}
	public void recommend( )
	{
		ArrayList <String> all_people = new ArrayList<String>();
		all_people = RestStorage.pull_page("Person");
		for (int i = 0; i < all_people.size(); i++)
		{
			String curr_id = all_people.get(i);
			 if(recommender.isQualified(this, curr_id) == true)
			 {
				 Page a = RestStorage.pull_request(curr_id);
				 try
				{
					a.addLink("job_posting", this);
				} catch (ClassIncompatibleException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 RestStorage.update_request(a);
			 }
		}
	}

}
