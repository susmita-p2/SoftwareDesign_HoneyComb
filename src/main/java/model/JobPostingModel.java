package model;

import javafx.scene.layout.BorderPane;

public class JobPostingModel extends PageModel
{

	public JobPostingModel(Page p)
	{
		super(p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PageTransitionModel create_transition(BorderPane view)
	{
		return new JobTransitionModel(view, this);
	}

}
