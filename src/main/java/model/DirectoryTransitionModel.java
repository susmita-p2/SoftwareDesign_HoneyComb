package model;


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import views.AllPageTypesFlowController;
import views.DirectoryController;
import views.PersonCanEditController;
import views.PersonLinksTypesFlowController;


public class DirectoryTransitionModel 
{
	BorderPane mainview;
	PersonModel model;
	public DirectoryTransitionModel(BorderPane view, PersonModel newModel) {
		model = newModel;
		mainview = view;
	}
	
	
	public void showAllPages() {
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/AllPageTypesFlowView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      AllPageTypesFlowController cont = loader.getController();
			      cont.setModel(model, mainview, new AllPagesModel(mainview, model));
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	}

	public void showLinkPages()
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonLinksTypesFlowView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonLinksTypesFlowController cont = loader.getController();
			      cont.setModel(model, new AllLinksModel(mainview, model));
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	}
	
}
