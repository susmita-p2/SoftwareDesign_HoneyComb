package views;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.PageTransitionModel;

public class NoPermissionsController {
	PageTransitionModel transitionModel;

    @FXML
    private Label permissionLabel;

	public void setModel(PageTransitionModel pageTransitionModel)
	{
		transitionModel = pageTransitionModel;
	}

}

