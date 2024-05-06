package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.PersonModel;
import model.PersonTransitionModel;

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

    public void setModel(PersonModel newModel, PersonTransitionModel newTransitionModel)
    {
    	transitionModel = newTransitionModel;
    	model = newModel;
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
    	transitionModel.showFollowed();
    }
    @FXML
    public void onUnfollowClick(ActionEvent event) {
    	transitionModel.showUneditable();
    }
}
