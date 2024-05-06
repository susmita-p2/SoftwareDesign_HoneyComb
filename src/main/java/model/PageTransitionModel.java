package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import views.PageCanEditController;
import views.PageEditController;
import views.PageViewController;

public abstract class PageTransitionModel 
{
	BorderPane mainview;
	PageModel model;
	public PageTransitionModel(BorderPane view, PageModel newModel)
	{
		mainview = view;
		model = newModel;
	}

	
	public void showEditable()
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PageTransitionModel.class
			        .getResource("../views/PageEditView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PageEditController cont = loader.getController();
			      cont.setModel(model,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }
		
	}

	
	public void showUneditable()
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PageTransitionModel.class
			        .getResource("../views/PageCanEditView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PageCanEditController cont = loader.getController();
			      cont.setModel(model,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }
		
	}

	
	public void showFollowed()
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PageTransitionModel.class
			        .getResource("../views/PagefollowedView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PageCanEditController cont = loader.getController();
			      cont.setModel(model,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }
		
	}

	
	public void showFollowedNoEdit()
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PageTransitionModel.class
			        .getResource("../views/PageFollowedCanEditView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PageCanEditController cont = loader.getController();
			      cont.setModel(model,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }
		
	}

	
	public void showNoEdit()
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PageTransitionModel.class
			        .getResource("../views/PageView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PageViewController cont = loader.getController();
			      cont.setModel(model,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }	
	}
	public abstract void showLinks();

}
