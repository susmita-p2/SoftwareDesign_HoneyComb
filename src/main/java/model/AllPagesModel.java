package model;

import javafx.scene.layout.BorderPane;

public class AllPagesModel
{
	BorderPane mainview;
	PersonModel model;
	
	public AllPagesModel(BorderPane mainview, PersonModel model)
	{
		super();
		this.mainview = mainview;
		this.model = model;
	}
}
