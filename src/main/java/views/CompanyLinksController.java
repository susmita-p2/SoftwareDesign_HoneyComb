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

public class CompanyLinksController {
	
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
		
	}
	
    @FXML
    private ListView<PageModel> allLinksListView;

    @FXML
    private Button editorButton;

    @FXML
    private Button employeeButton;

    @FXML
    private Button followerButton;

    @FXML
    private Button jobPostingButton;

    @FXML
    private Button mentorButton;

    @FXML
    private Button newsArticleButton;

    @FXML
    private Button projectButton;

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
    	if (RestStorage.create_models(curr_id, "editor") != null)
    	{
    		allLinksListView.setItems(RestStorage.create_models(curr_id, "editor"));
    	}

    }

    @FXML
    void onEmployeButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
    	if (RestStorage.create_models(curr_id, "employee") != null)
    	{
    		allLinksListView.setItems(RestStorage.create_models(curr_id, "employee"));
    	}
    	
    	

    }

    @FXML
    void onFollowerButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
  	if (RestStorage.create_models(curr_id, "follower") != null)
  	{
  		allLinksListView.setItems(RestStorage.create_models(curr_id, "follower"));
  	}

    }

    @FXML
    void onJobButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
  	if (RestStorage.create_models(curr_id, "job_posting") != null)
  	{
  		allLinksListView.setItems(RestStorage.create_models(curr_id, "job_posting"));
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
  	if (RestStorage.create_models(curr_id, "mentor") != null)
  	{
  		allLinksListView.setItems(RestStorage.create_models(curr_id, "mentor"));
  	}

    }

    @FXML
    void onNewsArticleButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
	if (RestStorage.create_models(curr_id, "news_article") != null)
	{
		allLinksListView.setItems(RestStorage.create_models(curr_id, "news_article"));
	}

    }

    @FXML
    void onProjectButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
	if (RestStorage.create_models(curr_id, "project") != null)
	{
		allLinksListView.setItems(RestStorage.create_models(curr_id, "project"));
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
	if (RestStorage.create_models(curr_id, "viewer") != null)
	{
		allLinksListView.setItems(RestStorage.create_models(curr_id, "viewer"));
	}

    }


	



}

