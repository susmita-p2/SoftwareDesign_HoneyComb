package model;

import javafx.scene.layout.BorderPane;

public class CompanyModel extends PageModel
{
	//BorderPane view;
	PageModel pg;
	public CompanyModel(Page p)
	{
		super(p);
		
	}
	public PageTransitionModel create_transition(BorderPane view)
	{
		
		return new CompanyTransitionModel(view, this);
	}


}
