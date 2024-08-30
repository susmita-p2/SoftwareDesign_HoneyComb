package honeyComb;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.CompanyModel;
import model.CompanyTransitionModel;
import model.HomeTransitionModel;
import model.LoginNavigationModel;
import model.Page;
import model.PageModel;
import model.PageTransitionModel;
import model.RestStorage;
import views.HomeBarController;
import views.LoginPageController;
import views.PageViewController;

@ExtendWith(ApplicationExtension.class)
class PageView
{
	PageModel pModel;
	PageTransitionModel transit;
	BorderPane mainview = new BorderPane();
	Page x = null;
	
	@Start
	private void start(Stage stage) 
	{
		
			PopulateRest.main(null);
			LoginPageController loginPageController = new LoginPageController();
			loginPageController.setUsername("1");
		    Page x =RestStorage.pull_request("11");
		    //System.out.println(x.getName());
		    //pModel = new PersonModel(x);
		    pModel = new CompanyModel(x);
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
				  personLoader.setLocation(PageTransitionModel.class
					      .getResource("../views/PageView.fxml"));

			      Node center = (Node)personLoader.load();
			      PageViewController personCont = personLoader.getController();
			      
			  	  PageTransitionModel personTransitionModel = new CompanyTransitionModel(mainview,pModel);
			      personCont.setModel(pModel, personTransitionModel);
			      mainview.setCenter(center);	
			      Scene s = new Scene(mainview);
				  stage.setScene(s);
				  stage.show();
			      
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	}
	@Test
	public void testFollowButton(FxRobot robot)
	{
		robot.clickOn("#followButton");
		robot.clickOn("#logoutButton");
	}
	@Test
	public void testLinksButton(FxRobot robot)
	{
		robot.clickOn("#linksButton");
		robot.clickOn("#logoutButton");
	}
	
	
	
}
