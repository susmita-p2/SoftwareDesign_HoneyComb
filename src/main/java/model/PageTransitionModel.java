package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import views.LoginPageController;
import views.NoPermissionsController;
import views.PageCanEditController;
import views.PageEditController;
import views.PageFollowedCanEditController;
import views.PageFollowedController;
import views.PageViewController;

public abstract class PageTransitionModel extends TransitionModel
{
	public PageTransitionModel(BorderPane view, PageModel newModel)
	{
		super(view,newModel);
		//mainview = view;
		//model = newModel;
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
			        .getResource("../views/PageCanEdit.fxml"));
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
			        .getResource("../views/PageFollowedCanEditView.fxml"));
			    try {
			    	
			      Node view = loader.load();
			      //System.out.println("What is happening?");
			      mainview.setCenter(view);
			      PageFollowedCanEditController cont = loader.getController();
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
			        .getResource("../views/PageFollowedView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PageFollowedController cont = loader.getController();
			      cont.setModel(model,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }
		
	}

	@Override
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
	public void showPage()
	{
		
		Person x = (Person) RestStorage.pull_request(LoginPageController.getUsername());
		System.out.println(model.getName());
		//Person x = (Person)model.getPage();
		if(! x.canView(model.getPage()))
		{
			FXMLLoader loader = new FXMLLoader();
			 loader.setLocation(PageTransitionModel.class
				        .getResource("../views/NoPermissionPage.fxml"));
				    try {
				      System.out.println("No Permissions");
				      Node view = loader.load();
				      mainview.setCenter(view);
				      NoPermissionsController cont = loader.getController();
				      cont.setModel(this);
				    } catch (IOException e) {
				      // TODO Auto-generated catch block
				      e.printStackTrace();
				    }
		} else
			
			{
				if(! x.canEdit(model.getPage()))
				{
					showNoEdit();
				}
				else
				{
					showUneditable();
				}
			}
		
	}
	public abstract void showLinks();

}
