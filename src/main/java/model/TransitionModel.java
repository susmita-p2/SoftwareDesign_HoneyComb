package model;

import javafx.scene.layout.BorderPane;

public abstract class TransitionModel {
	BorderPane mainview;
	PageModel model;
	public TransitionModel(BorderPane view, PageModel newModel) {
		this.mainview = view;
		model = newModel;
	}
	public abstract void showEditable();
	public abstract void showUneditable();
	public abstract void showFollowed();
	public abstract void showFollowedNoEdit();
	public abstract void showNoEdit();
}
