package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.AllLinksModel;
import model.PageLinks;
import model.PageModel;
import model.PersonModel;

public class CompanyLinksController {
	
	PageModel model; // this will be the page we're looking at
	PageLinks allLinksModel;
	public void setModel(PageModel newmodel, PageLinks allLinks)
	{
		model = newmodel;
		this.allLinksModel = allLinks;
		
	}
	
    @FXML
    private ListView<?> allLinksListView;

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
    private Button projectPageTypeBtn;

    @FXML
    private Button skillPageTypeBtn;

    @FXML
    void onEditorButtonClick(ActionEvent event) {

    }

    @FXML
    void onEmployeButtonClick(ActionEvent event) {

    }

    @FXML
    void onFollowerButtonClick(ActionEvent event) {

    }

    @FXML
    void onJobButtonClick(ActionEvent event) {

    }

    @FXML
    void onMentorButtonClick(ActionEvent event) {

    }

    @FXML
    void onNewsArticleButtonClick(ActionEvent event) {

    }

    @FXML
    void onProjectButtonClick(ActionEvent event) {

    }

    @FXML
    void onViewerButtonClick(ActionEvent event) {

    }


	



}

