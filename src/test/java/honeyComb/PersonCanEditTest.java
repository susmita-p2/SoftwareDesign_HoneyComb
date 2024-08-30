package honeyComb;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.HomeTransitionModel;
import model.LoginNavigationModel;
import model.Page;
import model.PageModel;
import model.Person;
import model.PersonModel;
import model.PersonTransitionModel;
import model.RestStorage;
import views.HomeBarController;
import views.LoginPageController;
import views.PersonCanEditController;

@ExtendWith(ApplicationExtension.class)
public class PersonCanEditTest 
{
	
	PageModel pModel;
	PersonTransitionModel transit;
	BorderPane mainview = new BorderPane();
	Page x = null;

	@Start
	private void start(Stage stage) 
	{
		
			PopulateRest.main(null);
		
			LoginPageController loginPageController = new LoginPageController();
			loginPageController.setUsername("0");
		    Page x = RestStorage.pull_request("2");
		    //System.out.println(x.getName());
		    pModel = new PersonModel(x);
		    //System.out.println(pModel.getName());
			
			  FXMLLoader homeLoader = new FXMLLoader();
			  FXMLLoader personLoader = new FXMLLoader();
			
			    try {
			    	
			    //set top
				  homeLoader.setLocation(LoginNavigationModel.class
					      .getResource("../views/Home.fxml"));

			      Pane topBanner = homeLoader.load();
			      HomeBarController cont = homeLoader.getController();
			  	  HomeTransitionModel homeTransitionModel = new HomeTransitionModel(mainview, pModel);
			      cont.setModel(homeTransitionModel);
			      mainview.setTop(topBanner);
			      
			    //set center
				  personLoader.setLocation(PersonTransitionModel.class
					      .getResource("../views/PersonCanEditView.fxml"));

			      Node center = (Node)personLoader.load();
			      PersonCanEditController personCont = personLoader.getController();
			      
			  	  PersonTransitionModel personTransitionModel = new PersonTransitionModel(mainview,pModel);
			      personCont.setModel(pModel, personTransitionModel);
			      mainview.setCenter(center);	
			      Scene s = new Scene(mainview);
				  stage.setScene(s);
				  stage.show();
			      
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	 
	}

	public void changeField(FxRobot robot, String value, String target)
	{
		robot.clickOn(target);
		robot.write(value);
	}
	
	@Test
	public void testFollowButton(FxRobot robot)
	{
		
		Person Alice = (Person) RestStorage.pull_request("0");
		ArrayList<String> arr = Alice.getPage_links().get("following");
		assertFalse(arr.contains("2"));
		robot.clickOn("#followButton");
		Person new_Alice = (Person) RestStorage.pull_request("0");
		ArrayList<String> arr2 = new_Alice.getPage_links().get("following");
		System.out.println("New arr" + arr2);
		assertTrue(arr2.contains("2"));
		robot.clickOn("#logoutButton");	
	
	}
	@Test
	public void testLinksButton(FxRobot robot)
	{
		
	
		robot.clickOn("#linksButton");
		robot.clickOn("#logoutButton");	
	
	}
	
	@Test
	public void testEditButton(FxRobot robot)
	{
		robot.clickOn("#editButton");
		changeField(robot," McAllister","#nameLabel");
		changeField(robot," Very cool", "#descriptionLabel");
		robot.clickOn("#updateButton");
		Person edited = (Person) RestStorage.pull_request("2");
		System.out.println(edited.getName());
		assertEquals("Helen McAllister", edited.getName());
		assertEquals("Student Very cool", edited.getDescription());
		robot.clickOn("#logoutButton");
	}
	
	@Test
	public void testPageEditButton(FxRobot robot)
	{
		robot.clickOn("#searchButton");
		robot.clickOn("#allPagesButton");
		robot.clickOn("#personButton");
	
		
		try
		{
			selectItem(robot,1);
			   
		    Thread.sleep(1000);
	
		    
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}

	
	}
	 @SuppressWarnings("unchecked")
	  ListView<PageModel> getPageDetails(FxRobot robot)

	  {
	   return (ListView<PageModel>) robot.lookup("#listView")
	       .queryAll().iterator().next();
	  }
	  
	  
	  private void selectItem(FxRobot robot, int index)
	  {
		  Platform.runLater(()->{
			  ListView<PageModel> people = getPageDetails(robot);
			  people.scrollTo(index);
			  people.getSelectionModel().clearAndSelect(index);
		  });
		  WaitForAsyncUtils.waitForFxEvents();
	}


}
