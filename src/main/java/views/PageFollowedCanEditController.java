package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Page;
import model.PageModel;
import model.PageTransitionModel;
import model.RestStorage;

public class PageFollowedCanEditController {
	PageModel model;
	PageTransitionModel transition;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label nameLabel;

    @FXML
    void onEditClick(ActionEvent event) {
    	transition.showEditable();
    }

    @FXML
    void onLinkClick(ActionEvent event) {
    	transition.showLinks();
    }
    
    @FXML
    void onFollowClick(ActionEvent event) {
    	//transition.showLinks();
    }
    @FXML
    void onUnfollowClick(ActionEvent event) {
    	Page curr = model.getPage();
    	Page human = RestStorage.pull_request(LoginPageController.getUsername());
    	System.out.println(curr.getName());
    	human.removeLink("following", curr);
    	RestStorage.update_request(human);
    	transition.showFollowed();

    }
    public void setModel(PageModel newModel, PageTransitionModel transitionModel) {
  		model = newModel;
  		transition = transitionModel;
  		Bindings.bindBidirectional(nameLabel.textProperty(), model.getName());
  		Bindings.bindBidirectional(descriptionLabel.textProperty(), model.getDescription());
  	}


}

