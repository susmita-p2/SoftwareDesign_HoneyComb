package views;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
//import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.PersonModel;
import model.PersonTransitionModel;
import model.RestStorage;

public class PersonEditController implements Initializable{
	PersonModel model;
	PersonTransitionModel transition;
    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField idField;

    @FXML
    private ChoiceBox<String> linksChoices;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField pronounsField;
    
   
    private String[] choiceBox_roles = {"skill", "employer", "project", "news_article", "follower", "friend", "viewer", "editor", "mentor", "job_posting", "following"};
 
	
   
    @FXML
    void onAddLinkClick(ActionEvent event) {
    	String role = linksChoices.getValue();
    	String id = idField.getText();
    	System.out.println(role + id);
    	/*ArrayList <String> vals= model.getPage().getPage_links().get(role);
    	vals.add(id);
     	RestStorage.update_request(model.getPage());*/
    	
 
    }
    public void setModel(PersonModel newModel, PersonTransitionModel transitionModel)
    {
    	model = newModel;
    	transition = transitionModel;
    	
    	/*nameField.setText(model.getName().get()); 
    	emailField.setText(model.getEmail().get()); 
    	pronounsField.setText(model.getPronoun().get()); 
    	phoneField.setText(model.getPhone().get());
    	descriptionField.setText(model.getDescription().get()); 
		*/
    	
    	
    	Bindings.bindBidirectional(nameField.textProperty(), model.getName());
    	Bindings.bindBidirectional(pronounsField.textProperty(), model.getPronoun());
    	Bindings.bindBidirectional(emailField.textProperty(), model.getEmail());
    	Bindings.bindBidirectional(phoneField.textProperty(), model.getPhone());
    	Bindings.bindBidirectional(descriptionField.textProperty(), model.getDescription());

    	
    }
    @FXML
    public void onUpdateClick(ActionEvent event) {
    	//update variables
    	model.getName().setValue(nameField.getText());
    	model.getEmail().setValue(emailField.getText());
    	model.getPronoun().setValue(pronounsField.getText());
    	model.getPhone().setValue(phoneField.getText());
    	model.getDescription().setValue(descriptionField.getText());
    	
    	model.getPage().setName(nameField.getText());
    	model.getPage().setDescription(emailField.getText());
    	model.getPage().setEmail(emailField.getText());
    	model.getPage().setPronoun(pronounsField.getText());
    	model.getPage().setPhone(phoneField.getText());
    	
    	RestStorage.update_request(model.getPage());
    	transition.showUneditable();
    }
    public void onCancelClick(ActionEvent event) {
    	model.getName().setValue(model.getPage().getName());
    	model.getDescription().setValue(model.getPage().getDescription());
    	model.getPronoun().setValue(model.getPage().getPronoun());
    	model.getEmail().setValue(model.getPage().getEmail());
    	model.getPhone().setValue(model.getPage().getPhone());
    	transition.showUneditable();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		linksChoices.getItems().addAll(choiceBox_roles);
		
	}
}
