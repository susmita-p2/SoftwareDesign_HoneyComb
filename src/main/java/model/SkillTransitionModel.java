package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import views.SkillLinksController;

public class SkillTransitionModel extends PageTransitionModel
{

	public SkillTransitionModel(BorderPane view, PageModel newModel)
	{
		super(view, newModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showLinks()
	{
		System.out.println("Skillss");
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(CompanyTransitionModel.class
			        .getResource("../views/SkillLinks.fxml"));
		 
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      System.out.println("loaded");
			      SkillLinksController cont = loader.getController();
			      
			      cont.setModel(model, new PageLinks(mainview, model), mainview);
			      
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	}
		

	

}
