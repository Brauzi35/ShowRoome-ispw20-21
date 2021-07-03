package logic.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import logic.appcontroller.ReviewController;
import logic.bean.ReviewBean;
import logic.utils.SessionUser;

public class ReviewArtistController implements Initializable{
	@FXML
    private AnchorPane rootpane5;

    @FXML
    private AnchorPane reviewsPane;

    @FXML
    private Button upButton;

    @FXML
    private Button donwButton;

    @FXML
    private AnchorPane reviewsPane1;

    @FXML
    private Label authorLabel;

    @FXML
    private Label reviewLabel;
    
    @FXML
    private AnchorPane noRevPane;
    
    private List<ReviewBean> lrb = new ArrayList<>();
    
    private int reviewCounter=0;
    
    private int maxCounter=0;

    @FXML
    void up(ActionEvent event) {
    	if(reviewCounter>=0 && reviewCounter<maxCounter-1) {
    		reviewCounter++;//increase reviewCounter
    		display(reviewCounter);
    	}
    }

    @FXML
    void down(ActionEvent event) {
    	if(reviewCounter<=maxCounter-1 && reviewCounter>0) {
    		reviewCounter--;
    		display(reviewCounter);
    	}
    }
    
    void display(int index) {
    	authorLabel.setText(lrb.get(index).getAuthor());
    	reviewLabel.setText(lrb.get(index).getReview());
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		reviewLabel.setWrapText(true); //this line makes text fit in a label
		ReviewController rc = new ReviewController();
		SessionUser su = SessionUser.getInstance();
		lrb = rc.getReviews(su.getUsername());
		noRevPane.setVisible(false);
		
		if(lrb.isEmpty()) {
			reviewsPane1.setVisible(false);
			upButton.setVisible(false);
			donwButton.setVisible(false);
			noRevPane.setVisible(true);
			
		}
		else {
			maxCounter = lrb.size(); //maxCounter is lrb lenght
			display(0);
		}
	}
}
