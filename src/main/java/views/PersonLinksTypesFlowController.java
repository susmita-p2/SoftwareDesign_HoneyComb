package views;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import model.AllLinksModel;
import model.AllPagesModel;
import model.LoginNavigationModel;
import model.Page;
import model.PageModel;
import model.Person;
import model.PersonModel;
import model.RestStorage;

public class PersonLinksTypesFlowController {
	PersonModel model; // this will be the page we're looking at
	AllLinksModel allLinksModel;

	public void setModel(PersonModel newmodel, AllLinksModel allLinks)
	{
		model = newmodel;
		this.allLinksModel = allLinks;
	    //String a = LoginPageController.getUsername();
		//Person x = (Person) RestStorage.pull_request(a);
		//model = new PersonModel(x);
		//HashMap<String, ArrayList<String>> curr_links = x.getPage_links();
		//System.out.println(curr_links);
		//allLinksListView.setItems(FXCollections.observableArrayList());
	}

    @FXML
    private ListView<PageModel> allLinksListView;

    @FXML
    private Button companyPageTypeBtn;

    @FXML
    private Button jobPostingPageTypeBtn;

    @FXML
    private Button newsArticlePageTypeBtn;

    @FXML
    private Button personPageTypeBtn;

    @FXML
    private Button personPageTypeBtn1;

    @FXML
    private Button personPageTypeBtn2;

    @FXML
    private Button personPageTypeBtn3;

    @FXML
    private Button projectPageTypeBtn;

    @FXML
    private Button skillPageTypeBtn;
    
    //String id = model.getId().toString();
    String a = LoginPageController.getUsername();
	//Person x = (Person) RestStorage.pull_request(a);
	//model = new PersonModel(x);
	//HashMap<String, ArrayList<String>> curr_links = x.getPage_links();
	
	
	
    @FXML
    void onEmployerButtonClick(ActionEvent event) {
    	/*System.out.println(a);
    	model = new PersonModel(x);
    	System.out.println(model.getPage_links());
    	ObservableList<PageModel> employers = FXCollections.observableArrayList();
		ArrayList<String> arr = curr_links.get("employer");
		model.getPage_links().get("employer").setAll(arr);
		System.out.println(model.getPage_links());
    
    	System.out.println(employers);
    	for (int i = 0; i < arr.size(); i++)
    	{
    		Page a = RestStorage.pull_request(arr.get(i));
    		PageModel pg = a.makeModel();
    		employers.add(pg);
    		System.out.println(pg);
    		
    	}
    //	System.out.println(a.getName());
    	//employers.add(a.getName());*/
    	
    	allLinksListView.setItems(RestStorage.create_models(a, "employer"));


    }

    @FXML
    void onFollowerButtonClick(ActionEvent event) {
    	allLinksListView.setItems(RestStorage.create_models(a, "follower"));

    }

    @FXML
    void onFollowingButtonClick(ActionEvent event) {
    	allLinksListView.setItems(RestStorage.create_models(a, "following"));

    }

    @FXML
    void onFriendButtonClick(ActionEvent event) {
    	
    	allLinksListView.setItems(RestStorage.create_models(a, "friend"));

    }

    @FXML
    void onMentorButtonClick(ActionEvent event) {
    	allLinksListView.setItems(RestStorage.create_models(a, "mentor"));

    }

    @FXML
    void onNewsArticleButtonClick(ActionEvent event) {
    	allLinksListView.setItems(RestStorage.create_models(a, "news_article"));

    }

    @FXML
    void onProjectButtonClick(ActionEvent event) {
    	allLinksListView.setItems(RestStorage.create_models(a, "project"));

    }

    @FXML
    void onViewerButtonClick(ActionEvent event) {
    	allLinksListView.setItems(RestStorage.create_models(a, "viewer"));

    }
    
    //TODO delete this, for demo only
    @FXML
    void onClickAmazon(ActionEvent event)
    {
    	//this.allLinksModel.showAmazon();
    }
    

}

