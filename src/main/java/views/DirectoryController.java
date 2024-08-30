package views;

import javafx.fxml.FXML;
import model.DirectoryTransitionModel;
import model.PageModel;
import javafx.event.ActionEvent;

public class DirectoryController {

	PageModel person;
	DirectoryTransitionModel dirModel;
	
	public void setModel(PageModel model, DirectoryTransitionModel dirModel) {
		this.person = model;
		this.dirModel = dirModel;
	}
    @FXML
    void onClickAll(ActionEvent event) {
    	dirModel.showAllPages();
    }

    @FXML
    void onClickMyLinks(ActionEvent event) {
    	dirModel.showLinkPages();
    }

}
