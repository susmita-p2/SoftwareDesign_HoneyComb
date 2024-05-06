package model;

import java.util.ArrayList;

public class FollowingRecommender implements Recommender
{

	@Override
	public boolean isQualified(JobPosting j, String curr_id)
	{
		// TODO Auto-generated method stub
		ArrayList<String> company_list= j.page_links.get("employer");
		String company_name = company_list.get(0);
		Page x = RestStorage.pull_request(curr_id);
		ArrayList<String> person_following = ((Person)x).getPage_links().get("following");
		
		if (person_following == null)
		{
			return false;
		}
		for (int i = 0; i < person_following.size(); i++)
		{
			if (person_following.get(i).equals(company_name))
			{
				return true;
			}
		}
		
		return false;
	}

}
