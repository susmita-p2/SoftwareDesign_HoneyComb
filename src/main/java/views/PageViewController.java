package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.PageModel;
import model.PageTransitionModel;

public class PageViewController {

	PageModel model;
	PageTransitionModel transition;
    @FXML
    private Label descriptionLabel;

    @FXML
    private Label nameLabel;

    @FXML
    void onFollowClick(ActionEvent event) {

    }

    @FXML
    void onLinksClick(ActionEvent event) {

    }

	public void setModel(PageModel model, PageTransitionModel transition)
	{
		this.model = model;
		this.transition = transition;
		
	}

}

