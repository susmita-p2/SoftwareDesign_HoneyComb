package honeyComb;


import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Main;
import model.HomeTransitionModel;
import model.LoginNavigationModel;
import model.LoginNavigationModelInterface;
import model.Page;
import model.Person;
import model.PersonModel;
import model.PersonTransitionModel;
import model.RestStorage;
import views.HomeBarController;
import views.LoginPageController;
import views.PersonCanEditController;


@ExtendWith(ApplicationExtension.class)
public class HomeTest implements LoginNavigationModelInterface
{
	String username = null;
	BorderPane mainview;
	@Start
	private void start(Stage stage)
	{
		searchCount = 0;
		logoutCount = 0;
		homeCount= 0;
		PopulateRest.main(null);
		
	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(Main.class.getResource("../views/BackgroundView.fxml"));
		 BorderPane view = null;
		try
		{
			view = loader.load();
			this.mainview = view;
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    LoginPageController cont = loader.getController();
	    if(cont == null)
	    {
	    	System.out.println("");
	    }
	    LoginNavigationModelInterface navModel = new LoginNavigationModel(view); 

	    cont.setModel(navModel);
	    
	    this.showHomepage("0");
	   
	    
	    Scene s = new Scene(view);
	    stage.setScene(s);
	    stage.show();
	}
	int searchCount = 0;
	int logoutCount = 0;
	int homeCount= 0;
	@Test
	public void testButton(FxRobot robot)
	{
		robot.clickOn("#searchButton");
		Assertions.assertThat(searchCount).isEqualTo(1);
		
		robot.clickOn("#homeButton");
		Assertions.assertThat(homeCount).isEqualTo(1);
		
		robot.clickOn("#searchButton");
		robot.clickOn("#homeButton");
		//Assertions.assertThat(searchCount).isEqualTo(2);
		robot.clickOn("#logoutButton");
		
		//Assertions.assertThat(homeCount).isEqualTo(2);
		//Assertions.assertThat(logoutCount).isEqualTo(1);
		
		
	}
	@Override
	public void showHomepage(String username)
	{
		searchCount++;
		homeCount++;
		logoutCount++;
		System.out.println(searchCount);
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
	@Override
	public void showLogin()
	{
		// TODO Auto-generated method stub
		
	}
}
