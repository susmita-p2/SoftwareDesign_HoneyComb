package model;

import javafx.scene.layout.BorderPane;

public class NewsArticleModel extends PageModel
{

	public NewsArticleModel(Page p)
	{
		super(p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PageTransitionModel create_transition(BorderPane view)
	{
		return new NewsArticleTransitionModel(view, this);
	}

}
