package views;

import javafx.event.ActionEvent;
import model.CompanyTransitionModel;
import model.PageModel;
import model.PageTransitionModel;
import model.PersonModel;

public class PageEditController{
	PageModel model;
	PageTransitionModel transitionModel;
	public void setModel(PageModel newModel, PageTransitionModel transition) {
		model = newModel;
		transitionModel = transition;
	}
    public void onUpdateClick(ActionEvent event) {
    	transitionModel.showUneditable();
    }
    public void onCancelClick(ActionEvent event) {
    	transitionModel.showUneditable();
    }

}
