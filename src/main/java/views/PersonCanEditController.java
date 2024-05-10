package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.ClassIncompatibleException;
import model.Page;
import model.PageModel;
import model.PersonModel;
import model.PersonTransitionModel;
import model.RestStorage;

public class PersonCanEditController {

	PersonTransitionModel transitionModel;
	PersonModel model;
	
    @FXML
    private Label descriptionLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label pronounsLabel;

    public void setModel(PageModel newModel, PersonTransitionModel newTransitionModel)
    {
    	transitionModel = newTransitionModel;
    	model = (PersonModel)newModel;
    	Bindings.bindBidirectional(nameLabel.textProperty(), model.getName());
    	Bindings.bindBidirectional(pronounsLabel.textProperty(), model.getPronoun());
    	Bindings.bindBidirectional(emailLabel.textProperty(), model.getEmail());
    	Bindings.bindBidirectional(phoneLabel.textProperty(), model.getPhone());
    	Bindings.bindBidirectional(descriptionLabel.textProperty(), model.getDescription());
    }
    @FXML
    public void onEditClick(ActionEvent event) {
    	transitionModel.showEditable();
    }
    @FXML
    public void onFollowClick(ActionEvent event) {
    	Page curr = model.getPage();
    	Page human = RestStorage.pull_request(LoginPageController.getUsername());
    	System.out.println(curr.getName());
    	System.out.println(human.getName());
    	if (curr.getName().equals(human.getName()))
    	{
    		transitionModel.showFollowed();
    		//System.out.println("In equals");
    	}
    	else
    	{
    	try
		{
			human.addLink("following", curr);
			RestStorage.update_request(human);
		} catch (ClassIncompatibleException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	transitionModel.showFollowed();
    	}
    }
    
    @FXML
    public void onUnfollowClick(ActionEvent event) {
    	Page curr = model.getPage();
    	Page human = RestStorage.pull_request(LoginPageController.getUsername());
    	human.removeLink("following", curr);
    	RestStorage.update_request(human);
    	transitionModel.showUneditable();
    }

    @FXML
    void onLinkClick(ActionEvent event) {
    	transitionModel.showLinks();

    }
}
