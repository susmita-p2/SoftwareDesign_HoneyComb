package model;

public class AllRecommender implements Recommender
{

	@Override
	public boolean isQualified(JobPosting j, String curr_id)
	{
		
		return true;
	}
	
}
