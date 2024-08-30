package honeyComb;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import model.HomeTransitionModel;
import model.LoginNavigationModel;
import model.Page;
import model.PageModel;
import model.PersonModel;
import model.PersonTransitionModel;
import model.RestStorage;
import views.HomeBarController;
import views.PersonEditController;

@ExtendWith(ApplicationExtension.class)
public class PersonEditTest
{


	PageModel pModel;
	PersonTransitionModel transit;
	BorderPane mainview = new BorderPane();
	Page x = null;
	@Start
	private void start(Stage stage) 
	{
		
			PopulateRest.main(null);
		    Page x =RestStorage.pull_request("0");
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
					      .getResource("../views/PersonEditView.fxml"));

			      Node center = (Node)personLoader.load();
			      PersonEditController personCont = personLoader.getController();
			      
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
	@Test
	public void testCancelButton(FxRobot robot)
	{
		//robot.clickOn("#editButton");
		
		changeField(robot," Rai","#nameLabel");
		robot.clickOn("#cancelButton");
		//robot.clickOn("#logoutButton");
		//changeField(robot, "0", "#userButton");
		//changeField(robot, "0", "#passwordButton");
		//robot.clickOn("#loginButton");
	}
	
	@Test
	public void testUpdateButton(FxRobot robot)
	{
		Page x = RestStorage.pull_request("0");
		assertEquals("Alice", x.getName());
		changeField(robot, " The Queen", "#nameLabel");
		robot.clickOn("#updateButton");
		
		Page updated_x = RestStorage.pull_request("0");
		assertEquals("Alice The Queen", updated_x.getName());
		
	}
	public void changeField(FxRobot robot, String value, String target)
	{
		robot.clickOn(target);
		robot.write(value);
	}
}
