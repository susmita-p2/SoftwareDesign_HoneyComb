package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import views.CompanyLinksController;

public class CompanyTransitionModel extends PageTransitionModel
{

	public CompanyTransitionModel(BorderPane view, PageModel newModel)
	{
		super(view, newModel);
		
	}


	public void showLinks()
	{
		System.out.println("Links");
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(CompanyTransitionModel.class
			        .getResource("../views/CompanyLinks.fxml"));
		 
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      //System.out.println("loaded");
			      CompanyLinksController cont = loader.getController();
			      //System.out.println("Susmita");
			      cont.setModel(model, new PageLinks(mainview, model), mainview);
			      //System.out.println("IS DEAD");
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	}

}
