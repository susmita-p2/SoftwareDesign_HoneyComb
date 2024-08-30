package model;

import javafx.scene.layout.BorderPane;

public class AllPagesModel
{
	BorderPane mainview;
	PageModel model;
	
	public AllPagesModel(BorderPane mainview, PageModel model)
	{
		super();
		this.mainview = mainview;
		this.model = model;
	}
}
