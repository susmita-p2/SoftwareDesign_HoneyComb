package views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import model.PageModel;
import views.ItemCellController;

public class ItemListCell extends ListCell<PageModel>
{
	ItemCellController itemController;
	Node node;
	BorderPane mainview;
	@Override
	protected void updateItem(PageModel item, boolean empty)
	{
		if(!empty)
		{
			itemController.updateView(item);
		}
		else
		{
			itemController.updateView(null);
		}
		super.updateItem(item, empty);
	}
	
	

	public ItemListCell(ListView<PageModel> list,ItemCellController itemController, BorderPane mainview)
	{
	
		//this.itemController = itemController;
		this.mainview = mainview;
		
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(ItemListCell.class
	        .getResource("./ItemCellView.fxml"));
	    try {
	      node = loader.load(); //store for later
	      
	      this.itemController = loader.getController(); //store for later
	      this.itemController.setModel(this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    setGraphic(node);
	}
}
