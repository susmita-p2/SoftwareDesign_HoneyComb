package views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import model.PageModel;
import model.PageTransitionModel;

public class ItemCellController implements ChangeListener<Boolean>{

	PageModel curr_model;
	ItemListCell model;
	BorderPane mainview;
	PageTransitionModel transition;
	public void setModel(ItemListCell cell)
	{
	    	if(model != null)
	    	{
	    		model.selectedProperty().removeListener(this);
	    	}
	    	model = cell;
	    	mainview = cell.mainview;
	    	if(model != null)
	    	{
	    		model.selectedProperty().addListener(this);
	    	}
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
    	
    	//System.out.println("Click");
    	//curr_model.create_transition(mainview).showPage();
    	
    }



	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
	{
		// TODO Auto-generated method stub
		if (newValue)
		{
		 	System.out.println("Click");
	    	curr_model.create_transition(mainview).showPage();
	
		}
		
	}

}


