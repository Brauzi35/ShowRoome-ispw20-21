package logic.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import logic.appcontroller.SSUserController;
import logic.bean.SponsoredShowBean;

public class ControllerSSUser implements Initializable {
	
	@FXML
    private AnchorPane rootpane5;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ListView<String> listViewSpShows;

    @FXML
    private AnchorPane artistPane;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label locationLabel;

    @FXML
    private Label capacityLabel;

    @FXML
    private Label artistLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//fill listViewArtists
				SSUserController ssuc = new SSUserController();
				listViewSpShows.getItems().addAll(ssuc.buildShowStringArray());
				listViewSpShows.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
						//this listener method makes the description of the selected show appear in the description pane
						SponsoredShowBean ssb = ssuc.getSponsoredShow(listViewSpShows.getSelectionModel().getSelectedItem());
						
						descriptionLabel.setText(ssb.getDescription());
						artistLabel.setText(ssb.getArtist());
						titleLabel.setText(ssb.getTitle());
						locationLabel.setText(ssb.getLocation());
						capacityLabel.setText(ssb.getCapacity());
					}
					
				});
		
	}
	
}
