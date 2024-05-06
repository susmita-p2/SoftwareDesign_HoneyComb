package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.CompanyTransitionModel;
import model.PersonModel;

public class CompanyCanEditController {
	CompanyTransitionModel transitionModel;
	PersonModel model;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label nameLabel;
    public void setModel(PersonModel newModel, CompanyTransitionModel newTransitionModel)
    {
    	transitionModel = newTransitionModel;
    	model = newModel;
    	Bindings.bindBidirectional(nameLabel.textProperty(), model.getName());
    	Bindings.bindBidirectional(descriptionLabel.textProperty(), model.getDescription());
    }

    @FXML
    void onFollowClick(ActionEvent event) {
    	transitionModel.showFollowed();

    }

    @FXML
    void onLinkClick(ActionEvent event) {
    	transitionModel.showLinks();
    }

}

