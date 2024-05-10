package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import views.JobPostingLinksController;

public class JobTransitionModel extends PageTransitionModel
{

	public JobTransitionModel(BorderPane view, PageModel newModel)
	{
		super(view, newModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showLinks()
	{
		
		System.out.println("Jobs");
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(CompanyTransitionModel.class
			        .getResource("../views/JobPostingLinks.fxml"));
		 
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      System.out.println("loaded");
			      JobPostingLinksController cont = loader.getController();
			      System.out.println("Susmita");
			      cont.setModel(model, new PageLinks(mainview, model), mainview);
			      System.out.println("IS DEAD");
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	}

}
