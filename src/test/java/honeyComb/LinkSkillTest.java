package honeyComb;

import java.io.IOException;

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
import model.PageLinks;
import model.PageModel;
import model.PageTransitionModel;
import model.PersonModel;
import model.PersonTransitionModel;
import model.RestStorage;
import views.HomeBarController;
import views.LoginPageController;
import views.PersonCanEditController;

@ExtendWith(ApplicationExtension.class)
class LinkSkillTest
{
	PageModel pModel;
	PageTransitionModel transit;
	BorderPane mainview = new BorderPane();
	PageLinks allLinks;

	@Start
	private void start(Stage stage) 
	{
		
			PopulateRest.main(null);
			LoginPageController loginPageController = new LoginPageController();
			loginPageController.setUsername("0");
		    Page x = RestStorage.pull_request("0");
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
			
			      personCont.setModel(pModel,personTransitionModel);
			      mainview.setCenter(center);	
			      Scene s = new Scene(mainview);
				  stage.setScene(s);
				  stage.show();
			      
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	}
	@Test
	public void SkillListTest(FxRobot robot)
	{

		robot.clickOn("#searchButton");
		robot.clickOn("#allPagesButton");
		robot.clickOn("#skillButton");
		//robot.clickOn("#followingButton");

		
		try
		{
			selectItem(robot,6);
			
		    Thread.sleep(1000);
	
		    	//selectItem(robot,2);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		robot.clickOn("#linksButton");
		robot.clickOn("#followingButton");
		try
		{
			selectItem(robot,2);
			
		    Thread.sleep(1000);
	
		    	//selectItem(robot,2);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		robot.clickOn("#logoutButton");
		
	}
	@Test
	public void SkillEditTest(FxRobot robot)
	{

		robot.clickOn("#searchButton");
		robot.clickOn("#allPagesButton");
		robot.clickOn("#skillButton");
		//robot.clickOn("#followingButton");

		
		try
		{
			selectItem(robot,7);
			
		    Thread.sleep(1000);
	
		    	//selectItem(robot,2);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		robot.clickOn("#editButton");
		enterUser(robot," WE LOVEEE JAVA","#descriptionLabel");
		enterUser(robot, ": Programming Language", "#nameLabel");
		robot.clickOn("#updateButton");
		robot.clickOn("#logoutButton");

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
		public void enterUser(FxRobot robot, String id, String target)
		{
			robot.clickOn(target);
			robot.write(id);
		}

	
}