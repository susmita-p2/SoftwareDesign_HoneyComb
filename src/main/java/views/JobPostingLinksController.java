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

public class JobPostingLinksController {
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
    private Button applicantButton;

    @FXML
    private Button contributorButton;

    @FXML
    private Button editorButton;

    @FXML
    private Button employerButton;

    @FXML
    private Button mentorButton;

    @FXML
    private Button skillButton;

    @FXML
    private Button viewerButton;

    @FXML
    void onApplicantButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
  	if (RestStorage.create_models(curr_id, "applicant") != null)
  	{
  		allLinksListView.setItems(RestStorage.create_models(curr_id, "applicant"));
  	}

    }

    @FXML
    void onContributorButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
  	if (RestStorage.create_models(curr_id, "contributor") != null)
  	{
  		allLinksListView.setItems(RestStorage.create_models(curr_id, "contributor"));
  	}

    }

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
    void onEmployerButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
  	if (RestStorage.create_models(curr_id, "employer") != null)
  	{
  		allLinksListView.setItems(RestStorage.create_models(curr_id, "employer"));
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
    void onSkillButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
  	if (RestStorage.create_models(curr_id, "skill") != null)
  	{
  		allLinksListView.setItems(RestStorage.create_models(curr_id, "skill"));
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

