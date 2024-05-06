package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import views.CompanyCanEditController;
import views.CompanyLinksController;
import views.PageCanEditController;
import views.PageEditController;
import views.PersonCanEditController;
import views.PersonEditController;
import views.PersonLinksTypesFlowController;

public class CompanyTransitionModel extends PageTransitionModel
{

	public CompanyTransitionModel(BorderPane view, PageModel newModel)
	{
		super(view, newModel);
		
	}


	public void showLinks()
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(CompanyTransitionModel.class
			        .getResource("../views/CompanyLinks.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      CompanyLinksController cont = loader.getController();
			      cont.setModel(model, new PageLinks(mainview, model));
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	}

}
