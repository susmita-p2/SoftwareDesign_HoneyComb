package honeyComb;

import java.util.ArrayList;

public class SkillRecommender implements Recommender
{

	@Override
	public boolean isQualified(JobPosting j, String curr_id)
	{
		
		Page a = RestStorage.pull_request(curr_id);
		ArrayList<String> person_skill = new ArrayList<String>();
		person_skill = a.getPage_links().get("skill");
		Page job_skill = RestStorage.pull_request(j.getId());
		ArrayList<String> skill_list= ((JobPosting) job_skill).getPage_links().get("skill");
		if (skill_list == null)
		{
			return true;
		}
	
		if (person_skill == null)
		{
			return false;
		}
		int total = skill_list.size();
		int count = 0;
	
		for (int i = 0; i < skill_list.size(); i++)
		{
			for (int x= 0; x < person_skill.size();x++)
			{
				if (skill_list.get(i).equals(person_skill.get(x)))
				{
					count++;
					if (count == total)
					{
						return true;
					}
				}
			}
		
		}
		
		// send job recommender if person has half the mentioned skills
		if (count >= total/2)
		{
			return  true;
		}
			
		return false;
	}

}
