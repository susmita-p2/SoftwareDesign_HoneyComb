package views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.LoginNavigationModelInterface;
import model.SessionSingleton;
import javafx.event.ActionEvent;

public class LoginPageController {
	
	LoginNavigationModelInterface loginNavModel;
	private static String username;
	public LoginPageController()
	{
		
	}
	
	public void setModel(LoginNavigationModelInterface model)
	{
		this.loginNavModel = model;
	}
	
    public static String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@FXML
    private Button loginButton;

    @FXML
    private TextField passwordLabel;

    @FXML
    private TextField usernameLabel;
    
    
    
    @FXML
    void onLoginButtonClick(ActionEvent event) {
    	username = usernameLabel.getText();
    	String password = passwordLabel.getText();
    	
    	SessionSingleton currentSession = SessionSingleton.getInstance();
    	System.out.println("Current id" + username);
    	if(currentSession.startSession(username, password))
    	{
    		if(this.loginNavModel == null)
    		{
    			System.out.println("HELP");
    		}
    		System.out.println("Calling home!");
    		this.loginNavModel.showHomepage(username);
    	}
    	else
    	{
    		System.out.println("Not calling home!");
    	}
    	
    }
    
}
