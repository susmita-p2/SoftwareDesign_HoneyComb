package model;

public interface Recommender
{
	public boolean isQualified(JobPosting j, String curr_id);
}