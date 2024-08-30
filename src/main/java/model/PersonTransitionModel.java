package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import views.LoginPageController;
import views.NoPermissionsController;
import views.PersonCanEditController;
import views.PersonEditController;
import views.PersonFollowedCanEditController;
import views.PersonFollowedController;
import views.PersonLinksTypesFlowController;
import views.PersonViewController;

public class PersonTransitionModel extends PageTransitionModel
{
	String personPageId;
	
	public PersonTransitionModel(BorderPane view, PageModel newModel)
	{
		super(view,newModel);
	

	}
	
	public void showEditable()
	{
	    System.out.println(mainview);

		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonEditView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonEditController cont = loader.getController();
			      cont.setModel(model,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
			    
	}
	public void showUneditable()
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonCanEditView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonCanEditController cont = loader.getController();
			      cont.setModel(model,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
			    System.out.println(mainview + "wefojifja");
	}
	public void showFollowed()
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonFollowedCanEdit.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonFollowedCanEditController cont = loader.getController();
			      cont.setModel(model,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	@Override
	public void showFollowedNoEdit()
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonFollowedView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonFollowedController cont = loader.getController();
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
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonViewController cont = loader.getController();
			      cont.setModel(model,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	@Override
	public void showPage()
	{
		
		Person x = (Person) RestStorage.pull_request(LoginPageController.getUsername());
		//Person x = (Person)model.getPage();
		if(! x.canView(model.getPage()))
		{
			FXMLLoader loader = new FXMLLoader();
			 loader.setLocation(PageTransitionModel.class
				        .getResource("../views/NoPermissionPage.fxml"));
				    try {
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
				System.out.println(x.canEdit(model.getPage()));
				System.out.println(x.getId());
				System.out.println(model.getPage().getPage_links().get("editor"));
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


	@Override
	public void showLinks()
	{
		//System.out.println("Links");
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(CompanyTransitionModel.class
			        .getResource("../views/PersonLinksTypesFlowView.fxml"));
		 
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			   
			      PersonLinksTypesFlowController cont = loader.getController();
			   
			      cont.setModel(model,  new AllLinksModel(mainview, model), mainview);
			      //cont.setModel(model, new AllLinksModel(mainview, model));
			    
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		
	}
}
