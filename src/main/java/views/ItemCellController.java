package views;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.PageModel;
import model.PageTransitionModel;
import model.PersonTransitionModel;

public class ItemCellController {

	PageModel curr_model;
	ItemListCell model;
	BorderPane mainview;
	PageTransitionModel transition;
	public void setModel(ItemListCell cell)
	{
	    	model = cell;
	    	mainview = cell.mainview;
	}   
    @FXML
    private Label itemLabel;
    
    
    public void updateView(PageModel item)
    {
    	if(item ==null)
    	{
    		itemLabel.setText("");
    	}
    	else
    	{
    		curr_model = item;
    		itemLabel.setText(item.getName().getValue());
    	}
    }

    

    @FXML
    void onItemClicked(MouseEvent event) {
    	
    	System.out.println("Click");
    	curr_model.create_transition(mainview).showNoEdit();
    	
    }

}


