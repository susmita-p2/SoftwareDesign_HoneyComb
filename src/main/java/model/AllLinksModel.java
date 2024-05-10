package model;

import javafx.scene.layout.BorderPane;

public class AllLinksModel
{
	BorderPane mainview;
	PersonModel model;
	public AllLinksModel(BorderPane mainview, PageModel model)
	{
		super();
		this.mainview = mainview;
		this.model = (PersonModel)model;
	}
}
