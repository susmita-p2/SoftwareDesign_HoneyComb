package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import model.Page;
import model.PageLinks;
import model.PageModel;
import model.RestStorage;

public class SkillLinksController {
	PageModel model; // this will be the page we're looking at
	PageLinks allLinksModel;
	BorderPane mainview;
	String curr_id;
	public void setModel(PageModel newmodel, PageLinks allLinks,BorderPane mainview)
	{
		model = newmodel;
		this.allLinksModel = allLinks;
		this.mainview = mainview;
		Page curr = model.getPage();
		curr_id = curr.getId();
		System.out.println("Current id:" + curr_id);
		
	}

    @FXML
    private ListView<PageModel> allLinksListView;

    @FXML
    private Button editorButton;

    @FXML
    private Button followingButton;

    @FXML
    private Button mentorButton;

    @FXML
    private Button viewerButton;

    @FXML
    void onEditorButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
	//Page page = RestStorage.pull_request(curr_id);
	
	if (RestStorage.create_models(curr_id, "editor") != null)
	{
		allLinksListView.setItems(RestStorage.create_models(curr_id, "editor"));
	}

    }

    @FXML
    void onFollowingButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
	//Page page = RestStorage.pull_request(curr_id);
	
	if (RestStorage.create_models(curr_id, "following") != null)
	{
		allLinksListView.setItems(RestStorage.create_models(curr_id, "following"));
	}

    }

    @FXML
    void onMentorButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
	//Page page = RestStorage.pull_request(curr_id);
	
	if (RestStorage.create_models(curr_id, "mentor") != null)
	{
		allLinksListView.setItems(RestStorage.create_models(curr_id, "mentor"));
	}

    }

    @FXML
    void onViewerButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
	//Page page = RestStorage.pull_request(curr_id);
	
	if (RestStorage.create_models(curr_id, "viewer") != null)
	{
		allLinksListView.setItems(RestStorage.create_models(curr_id, "viewer"));
	}
    	

    }

}

