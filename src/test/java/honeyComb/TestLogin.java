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
public class TestLogin implements LoginNavigationModelInterface
{
	BorderPane mainview;
	@Start
	private void start(Stage stage)
	{
	
		loginClick = 0;
		homeClick = 0;
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
	    	System.out.println("SHIT");
	    }
	    //LoginNavigationModelInterface navModel = new LoginNavigationModel(view); 

	    cont.setModel(this);
	    
	    this.showLogin();
	   
	    
	    Scene s = new Scene(view);
	    stage.setScene(s);
	    stage.show();
	}
	
	public void enterUser(FxRobot robot, String id)
	{
		robot.clickOn("#userButton");
		robot.write(id);
	}
	
	public void enterPassword(FxRobot robot, String pw)
	{
		robot.clickOn("#passwordButton");
		robot.write(pw);
	}
	@Test
	public void testButton(FxRobot robot)
	{
		enterUser(robot,"1");
		enterPassword(robot,"1");
		robot.clickOn("#loginButton");
		System.out.println(loginClick);
		Assertions.assertThat(loginClick).isEqualTo(1);
		
		enterUser(robot,"");
		enterPassword(robot,"");
		robot.clickOn("#loginButton");
		System.out.println(loginClick);
		Assertions.assertThat(loginClick).isEqualTo(1);
		
	}

	int loginClick = 0;
	int homeClick = 0;
	@Override
	public void showHomepage(String username)
	{
		homeClick++;	
	}

	@Override
	public void showLogin()
	{
		loginClick++;

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
	
}
