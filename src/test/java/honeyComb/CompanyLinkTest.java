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
import model.PersonModel;
import model.PersonTransitionModel;
import model.RestStorage;
import views.CompanyLinksController;
import views.HomeBarController;
import views.LoginPageController;

@ExtendWith(ApplicationExtension.class)
class CompanyLinkTest
{
	PageModel pModel;
	PersonTransitionModel transit;
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
					      .getResource("../views/CompanyLinks.fxml"));

			      Node center = (Node)personLoader.load();
			      CompanyLinksController personCont = personLoader.getController();
			      
			  	  //PageTransitionModel personTransitionModel = new CompanyTransitionModel(mainview,pModel);
			
			      personCont.setModel(pModel,allLinks, mainview);
			      mainview.setCenter(center);	
			      Scene s = new Scene(mainview);
				  stage.setScene(s);
				  stage.show();
			      
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	}
	public void enterUser(FxRobot robot, String id, String target)
	{
		robot.clickOn(target);
		robot.write(id);
	}
	@Test
	public void CompanyTest(FxRobot robot)
	{

		robot.clickOn("#jobButton");
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
	public void CompanyTest2(FxRobot robot)
	{

		robot.clickOn("#followerButton");
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
	
	
	  @SuppressWarnings("unchecked")
	  ListView<PageModel> getPageDetails(FxRobot robot)

	  {
	   return (ListView<PageModel>) robot.lookup("#listView")
	       .queryAll().iterator().next();
	  }
	  
	  
	  private void selectItem(FxRobot robot, int index)
	  {
		  Platform.runLater(()->{
			  ListView<PageModel> job = getPageDetails(robot);
			  job.scrollTo(index);
			  job.getSelectionModel().clearAndSelect(index);
		  });
		  WaitForAsyncUtils.waitForFxEvents();
	}
	
	
	
}
