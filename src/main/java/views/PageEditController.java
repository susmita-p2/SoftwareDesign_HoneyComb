
package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.PageModel;
import model.PageTransitionModel;
import model.RestStorage;

public class PageEditController {

	PageModel model;
	PageTransitionModel transition;
    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField idField;

    @FXML
    private ChoiceBox<?> linksChoices;

    @FXML
    private TextField nameField;

    @FXML
    void onAddLinkClick(ActionEvent event) {

    }

    @FXML
    void onCancelClick(ActionEvent event) {
    	model.getName().setValue(model.getPage().getName());
    	model.getDescription().setValue(model.getPage().getDescription());
    	transition.showUneditable();
    }

    @FXML
    void onUpdateClick(ActionEvent event) {
    	model.getName().setValue(nameField.getText());
    	model.getDescription().setValue(descriptionField.getText());
    	
    	model.getPage().setName(nameField.getText());
    	model.getPage().setDescription(descriptionField.getText());
    	RestStorage.update_request(model.getPage());
    	transition.showUneditable();

    }

	public void setModel(PageModel model, PageTransitionModel transition)
	{
		this.model = model;
		this.transition = transition;
		Bindings.bindBidirectional(nameField.textProperty(), model.getName());
		Bindings.bindBidirectional(descriptionField.textProperty(), model.getDescription());	
	}

}


