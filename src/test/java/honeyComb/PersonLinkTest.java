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
import model.AllLinksModel;
import model.HomeTransitionModel;
import model.LoginNavigationModel;
import model.Page;
import model.PageModel;
import model.PersonModel;
import model.PersonTransitionModel;
import model.RestStorage;
import views.HomeBarController;
import views.LoginPageController;
import views.PersonLinksTypesFlowController;

@ExtendWith(ApplicationExtension.class)
public class PersonLinkTest
{
	PageModel pModel;
	PersonTransitionModel transit;
	BorderPane mainview = new BorderPane();
	Page x = null;
	AllLinksModel allLinks;
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
					      .getResource("../views/PersonLinksTypesFlowView.fxml"));

			      Node center = (Node)personLoader.load();
			      PersonLinksTypesFlowController personCont = personLoader.getController();
			      
			  	  //PersonTransitionModel personTransitionModel = new PersonTransitionModel(mainview,pModel);
			      personCont.setModel(pModel,allLinks, mainview);
			      mainview.setCenter(center);	
			      Scene s = new Scene(mainview);
				  stage.setScene(s);
				  stage.show();
			      
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	 
	}
	@Test
	public void testCompanyType(FxRobot robot) 
	{
		
		robot.clickOn("#employerButton");
		//Thread.sleep(1000);
		try
		{
			selectItem(robot,1);
			   
		    Thread.sleep(1000);
	
		    	//selectItem(robot,2);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}


	
	@Test
	public void testPersonType(FxRobot robot) 
	{
		
		robot.clickOn("#friendButton");
		//Thread.sleep(1000);
		try
		{
			selectItem(robot,4);
			   
		    Thread.sleep(1000);
	
		    	//selectItem(robot,2);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	@Test
	public void testMentorType(FxRobot robot) 
	{
		
		robot.clickOn("#mentorButton");
		//Thread.sleep(1000);
		try
		{
			selectItem(robot,1);
			   
		    Thread.sleep(1000);
	
		    	//selectItem(robot,2);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		robot.clickOn("#followButton");
		robot.clickOn("#unfollowButton");
		
	}
	@Test
	public void testCompanyNoPermissionType(FxRobot robot) 
	{
		
		robot.clickOn("#employerButton");
		//Thread.sleep(1000);
		try
		{
			selectItem(robot,1);
			   
		    Thread.sleep(1000);
	
		    	//selectItem(robot,2);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		robot.clickOn("#logoutButton");
	
		
	}
	@Test
	public void testCompany(FxRobot robot) 
	{
		
		robot.clickOn("#employerButton");
		//Thread.sleep(1000);
		try
		{
			selectItem(robot,0);
			   
		    Thread.sleep(1000);
	
		    	//selectItem(robot,2);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		robot.clickOn("#followButton");
		robot.clickOn("#editButton");
		
		//robot.clickOn("#unfollowButton");
		robot.clickOn("#logoutButton");
	
		
	}
	@Test
	public void testCanEditablePerson(FxRobot robot) 
	{
		
		robot.clickOn("#friendButton");
		//Thread.sleep(1000);
		try
		{
			selectItem(robot,1);
			   
		    Thread.sleep(1000);
	
		    	//selectItem(robot,2);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		robot.clickOn("#editButton");
		changeField(robot, "/ new@gmail.com", "#emailLabel");
		robot.clickOn("#updateButton");
		//robot.clickOn("#unfollowButton");
		robot.clickOn("#logoutButton");
	
	}
	@Test
	public void testCanEditablePersonUnfollow(FxRobot robot) 
	{
		
		robot.clickOn("#friendButton");
		//Thread.sleep(1000);
		try
		{
			selectItem(robot,1);
			   
		    Thread.sleep(1000);
	
		    	//selectItem(robot,2);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		robot.clickOn("#followButton");
		//robot.clickOn("#unfollowButton");
		robot.clickOn("#logoutButton");
	
	}
	
	@Test
	public void testNoViewPerson(FxRobot robot) 
	{
		
		robot.clickOn("#friendButton");
		//Thread.sleep(1000);
		try
		{
			selectItem(robot,4);
			   
		    Thread.sleep(1000);
	
		    	//selectItem(robot,2);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	
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
		public void changeField(FxRobot robot, String value, String target)
		{
			robot.clickOn(target);
			robot.write(value);
		}
		

}
