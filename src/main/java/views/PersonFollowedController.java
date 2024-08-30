package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Page;
import model.PageModel;
import model.PageTransitionModel;
import model.PersonModel;
import model.PersonTransitionModel;
import model.RestStorage;

public class PersonFollowedController {
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
    public void setModel(PageModel newModel, PageTransitionModel newTransitionModel)
    {
    	transitionModel = (PersonTransitionModel) newTransitionModel;
    	model = (PersonModel)newModel;
    	Bindings.bindBidirectional(nameLabel.textProperty(), model.getName());
    	Bindings.bindBidirectional(pronounsLabel.textProperty(), model.getPronoun());
    	Bindings.bindBidirectional(emailLabel.textProperty(), model.getEmail());
    	Bindings.bindBidirectional(phoneLabel.textProperty(), model.getPhone());
    	Bindings.bindBidirectional(descriptionLabel.textProperty(), model.getDescription());
    	
    }

    @FXML
    void onUnfollowClick(ActionEvent event) {
    	Page curr = model.getPage();
    	Page human = RestStorage.pull_request(LoginPageController.getUsername());
    	human.removeLink("following", curr);
    	RestStorage.update_request(human);
    	transitionModel.showNoEdit();
    }

    @FXML
    void onLinksClick(ActionEvent event) {
    	transitionModel.showLinks();
    }

}

