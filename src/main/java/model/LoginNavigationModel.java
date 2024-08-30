package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import views.HomeBarController;
import views.LoginPageController;
import views.PersonCanEditController;

public class LoginNavigationModel implements LoginNavigationModelInterface
{
	BorderPane mainview;
	//PersonModel personModel;
	Page p;
	 public LoginNavigationModel(BorderPane view)
	 {
	    this.mainview = view;
	    //this.personModel = new PersonModel(p);
	 }
	@Override
	public void showLogin()
	{
			    FXMLLoader loader = new FXMLLoader();
			    loader.setLocation(LoginNavigationModel.class
			        .getResource("../views/LoginPage.fxml"));
			    try {
			      Pane view = loader.load();
			      mainview.setCenter(view);
			      LoginPageController cont = loader.getController();
			      cont.setModel(this);
			      
			      
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }
	}
	
	@Override
	public void showHomepage(String username)
	{
	    FXMLLoader homeLoader = new FXMLLoader();
	    FXMLLoader personLoader = new FXMLLoader();
	    PersonModel personModel;
	    Page x = (Person)RestStorage.pull_request(username);
	    personModel = new PersonModel(x);
	   
	    try {
	    	
	    //set top
		  homeLoader.setLocation(LoginNavigationModel.class
			      .getResource("../views/Home.fxml"));

	      Pane topBanner = homeLoader.load();
	      HomeBarController cont = homeLoader.getController();
	  	  HomeTransitionModel homeTransitionModel = new HomeTransitionModel(mainview, personModel);
	      cont.setModel(homeTransitionModel);
	      mainview.setTop(topBanner);
	      
	    //set center
		  personLoader.setLocation(LoginNavigationModel.class
			      .getResource("../views/PersonCanEditView.fxml"));

	      Node center = (Node)personLoader.load();
	      PersonCanEditController personCont = personLoader.getController();
	      
	  	  PersonTransitionModel personTransitionModel = new PersonTransitionModel(mainview,personModel);
	      personCont.setModel(personModel, personTransitionModel);
	      mainview.setCenter(center);	      
	      
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	

}
