package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.ClassIncompatibleException;
import model.Page;
import model.PageModel;
import model.PageTransitionModel;
import model.RestStorage;

public class PageCanEditController
{
	PageModel model;
	PageTransitionModel transition;
	
    @FXML
    private Label descriptionLabel;

    @FXML
    private Label nameLabel;
    public void setModel(PageModel newModel, PageTransitionModel transitionModel) {
		model = newModel;
		transition = transitionModel;
		Bindings.bindBidirectional(nameLabel.textProperty(), model.getName());
		Bindings.bindBidirectional(descriptionLabel.textProperty(), model.getDescription());
	}
    @FXML
    public void onEditClick(ActionEvent event) {
    	
    	transition.showEditable();
    }
    @FXML
    public void onFollowClick(ActionEvent event) {
    	//transition.showFollowed();
    	Page curr = model.getPage();
    	Page human = RestStorage.pull_request(LoginPageController.getUsername());
    	System.out.println(human.getName());
    	System.out.println(curr.getName());
    	try
		{
			human.addLink("following", curr);
		} catch (ClassIncompatibleException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	RestStorage.update_request(human);
    	human =  RestStorage.pull_request(LoginPageController.getUsername());
    	transition.showFollowed();
    	//transition.showUneditable();
    }
    @FXML
    public void onUnfollowClick(ActionEvent event) {
    	Page curr = model.getPage();
    	Page human = RestStorage.pull_request(LoginPageController.getUsername());
    	human.removeLink("following", curr);
    	RestStorage.update_request(human);
    	transition.showUneditable();
    	
    }
    @FXML
    void onLinkClick(ActionEvent event) {
    	transition.showLinks();
    }
    
    
}
