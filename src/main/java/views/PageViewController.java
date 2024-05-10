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

public class PageViewController {

	PageModel model;
	PageTransitionModel transition;
    @FXML
    private Label descriptionLabel;

    @FXML
    private Label nameLabel;

    @FXML
    void onFollowClick(ActionEvent event) {
     	//transition.showFollowed();
    	Page curr = model.getPage();
    	Page human = RestStorage.pull_request(LoginPageController.getUsername());
    	//System.out.println(human.getName());
    	//System.out.println(curr.getName());
    	try
		{
			human.addLink("following", curr);
		} catch (ClassIncompatibleException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	RestStorage.update_request(human);
    	//human =  RestStorage.pull_request(LoginPageController.getUsername());
    	transition.showFollowedNoEdit();
    }

    @FXML
    void onLinksClick(ActionEvent event) {
    	transition.showLinks();
    
    }

    public void setModel(PageModel newModel, PageTransitionModel transitionModel) {
  		model = newModel;
  		transition = transitionModel;
  		Bindings.bindBidirectional(nameLabel.textProperty(), model.getName());
  		Bindings.bindBidirectional(descriptionLabel.textProperty(), model.getDescription());
  	}

}

