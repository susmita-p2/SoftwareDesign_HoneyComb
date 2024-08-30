package views;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import model.AllLinksModel;
import model.Page;
import model.PageModel;
import model.PersonModel;
import model.RestStorage;

public class PersonLinksTypesFlowController {
	PersonModel model; // this will be the page we're looking at
	AllLinksModel allLinksModel;
	BorderPane mainview;
	String curr_id;
	public void setModel(PageModel newmodel, AllLinksModel allLinks,BorderPane mainview)
	{
		model = (PersonModel)newmodel;
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
    private Button employerButton;

    @FXML
    private Button followerButton;

    @FXML
    private Button followingButton;

    @FXML
    private Button friendButton;

    @FXML
    private Button jobPostingButton;

    @FXML
    private Button mentorButton;

    @FXML
    private Button newsArticleButton;

    @FXML
    private Button projectButton;

    @FXML
    private Button skillButton;

    @FXML
    private Button viewerButton;
    
    //String id = model.getId().toString();
    String a = LoginPageController.getUsername();

    

	
	
	
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
    	//Page page = RestStorage.pull_request(curr_id);
  	
    	if (RestStorage.create_models(curr_id, "employer") != null)
    	{
    		allLinksListView.setItems(RestStorage.create_models(curr_id, "employer"));
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
    	//Page page = RestStorage.pull_request(curr_id);
    	
    	if (RestStorage.create_models(curr_id, "follower") != null)
    	{
    		allLinksListView.setItems(RestStorage.create_models(curr_id, "follower"));
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
    void onFriendButtonClick(ActionEvent event) {
    	
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
    	//Page page = RestStorage.pull_request(curr_id);
	
    	if (RestStorage.create_models(curr_id, "friend") != null)
    	{
    		allLinksListView.setItems(RestStorage.create_models(curr_id, "friend"));
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
    void onNewsArticleButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
    	//Page page = RestStorage.pull_request(curr_id);
	
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
  	//Page page = RestStorage.pull_request(curr_id);
	
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
    	//Page page = RestStorage.pull_request(curr_id);
	
    	if (RestStorage.create_models(curr_id, "viewer") != null)
    	{
    		allLinksListView.setItems(RestStorage.create_models(curr_id, "viewer"));
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
    	//Page page = RestStorage.pull_request(curr_id);
	
    	if (RestStorage.create_models(curr_id, "skill") != null)
    	{
    		allLinksListView.setItems(RestStorage.create_models(curr_id, "skill"));
    	}

    }
    @FXML
    void onJobPostingButtonClick(ActionEvent event) {
    	allLinksListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
    	//Page page = RestStorage.pull_request(curr_id);
	
    	if (RestStorage.create_models(curr_id, "job_posting") != null)
    	{
    		allLinksListView.setItems(RestStorage.create_models(curr_id, "job_posting"));
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
  	//Page page = RestStorage.pull_request(curr_id);
	
  	if (RestStorage.create_models(curr_id, "editor") != null)
  	{
  		allLinksListView.setItems(RestStorage.create_models(curr_id, "editor"));
  	}

    }

    

}

