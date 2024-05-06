package views;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.DirectoryTransitionModel;
import javafx.util.Callback;
import model.Page;
import model.PageModel;
import model.PersonModel;
import model.RestStorage;
import model.AllPagesModel;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class AllPageTypesFlowController {
	PersonModel model;
	AllPagesModel allPagesModel;
	BorderPane mainview;
    @FXML
    private Button companyPageTypeBtn;

    @FXML
    private Button jobPostingPageTypeBtn;

    @FXML
    private Button newsArticlePageTypeBtn;

    @FXML
    private Button personPageTypeBtn;

    @FXML
    private Button projectPageTypeBtn;

    @FXML
    private Button skillPageTypeBtn;
    
    @FXML
    private ListView<PageModel> allPagesListView;

    @FXML
    void onCompanyPageClick(ActionEvent event) {
    	//allPagesListView.setItems(allPagesModel.getCompanies());
    	ObservableList<Page> allCompanies = FXCollections.observableArrayList();
    	allCompanies.addAll(RestStorage.pull_Company());
    	ObservableList<PageModel> allCompaniesModel = FXCollections.observableArrayList();
       	for (int i = 0; i < allCompanies.size(); i++)
    	{
   
    		PageModel pg = allCompanies.get(i).makeModel();
    		allCompaniesModel.add(pg);
    		System.out.println(pg);
    		
    	}
       	allPagesListView.setCellFactory(new Callback<ListView<PageModel>, ListCell<PageModel>>()
		  {

			@Override
			public ListCell<PageModel> call(ListView<PageModel> lv)
			{
				return new ItemListCell(lv, new ItemCellController(),mainview);
			}
		  });
       	
    	allPagesListView.setItems(allCompaniesModel);
    	
    }

    @FXML
    void onJobPostingPageClick(ActionEvent event) {
    	ObservableList<Page> allJobs = FXCollections.observableArrayList();
    	allJobs.addAll(RestStorage.pull_JobPosting());
    	ObservableList<PageModel> allJobsModel = FXCollections.observableArrayList();
    
    	for (int i = 0; i < allJobs.size(); i++)
    	{
    		PageModel pg = allJobs.get(i).makeModel();
    		allJobsModel.add(pg);
    		System.out.println(pg);
    	}
    	allPagesListView.setItems(allJobsModel);

    }

    @FXML
    void onNewsArticlePageClick(ActionEvent event) {
    	ObservableList<Page> allNews = FXCollections.observableArrayList();
    	allNews.addAll(RestStorage.pull_NewsArticle());
    	ObservableList<PageModel> allNewsModel = FXCollections.observableArrayList();
    
    	for (int i = 0; i < allNews.size(); i++)
    	{
    		PageModel pg = allNews.get(i).makeModel();
    		allNewsModel.add(pg);
    		System.out.println(pg);
    	}
    	allPagesListView.setItems(allNewsModel);

    }

    @FXML
    void onPersonPageClick(ActionEvent event) {
    	ObservableList<Page> allPeople = FXCollections.observableArrayList();
    	allPeople.addAll(RestStorage.pull_Person());
    	ObservableList<PageModemodel, new AllPagesModel(mainview, model), mainviewl> allPeopleModel = FXCollections.observableArrayList();
    
    	for (int i = 0; i < allPeople.size(); i++)
    	{
    		PageModel pg = allPeople.get(i).makeModel();
    		allPeopleModel.add(pg);
    		System.out.println(pg);
    	}
    	allPagesListView.setItems(allPeopleModel);

    }

    @FXML
    void onProjectPageClick(ActionEvent event) {
    	ObservableList<Page> allProject = FXCollections.observableArrayList();
    	allProject.addAll(RestStorage.pull_Project());
    	ObservableList<PageModel> allProjectModel = FXCollections.observableArrayList();
    
    	for (int i = 0; i < allProject.size(); i++)
    	{
    		PageModel pg = allProject.get(i).makeModel();
    		allProjectModel.add(pg);
    		System.out.println(pg);
    	}
    	allPagesListView.setItems(allProjectModel);

    }

    @FXML
    void onSkillPageClick(ActionEvent event) {
    	ObservableList<Page> allSkills = FXCollections.observableArrayList();
    	allSkills.addAll(RestStorage.pull_Skill());
    	ObservableList<PageModel> allSkillsModel = FXCollections.observableArrayList();
    
    	for (int i = 0; i < allSkills.size(); i++)
    	{
    		PageModel pg = allSkills.get(i).makeModel();
    		allSkillsModel.add(pg);
    		System.out.println(pg);
    	}
    	allPagesListView.setItems(allSkillsModel);

    }

	public void setModel(PersonModel model, BorderPane mainview, AllPagesModel allPagesModel)
	{
		this.model = model;
		this.mainview = mainview;
		this.allPagesModel = allPagesModel;
		allPagesListView.setItems(FXCollections.observableArrayList());
	}

}