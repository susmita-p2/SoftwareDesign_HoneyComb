package model;

import javafx.scene.layout.BorderPane;

public class SkillModel extends PageModel
{

	public SkillModel(Page p)
	{
		super(p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PageTransitionModel create_transition(BorderPane view)
	{
		
		return new SkillTransitionModel(view, this);
	}

}
