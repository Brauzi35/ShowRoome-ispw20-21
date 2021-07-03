package logic.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.appcontroller.MapController;
import logic.bean.PlaceBean;
import logic.exceptions.DescriptionTooLongException;
import logic.exceptions.EmptyFieldException;
import logic.exceptions.ExceptionView;
import logic.utils.ExceptionFactory;
import logic.utils.TypeException;

public class GraphicControllerMapArtist implements Initializable{
	@FXML
    private AnchorPane rootpane3;
	
	@FXML
    private Button eurPlaceArt;

    @FXML
    private Button pignetoPlaceArt;

    @FXML
    private Button villaPlaceArt;

    @FXML
    private Button statuarioPlaceArt;

    @FXML
    private Label nameLabelArt;

    @FXML
    private Label indirizzoLabel;

    @FXML
    private Label capienzaLabel;

    @FXML
    private TextField titleText;

    @FXML
    private TextArea descriptionText;

    @FXML
    private Button submitButton;
    
    MapController mc = new MapController();
    List<PlaceBean> list = mc.freePlaces();

    @FXML
    void eurClick(ActionEvent event) {
    	int pos = 0;
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getName().equalsIgnoreCase("Eur")) {
    			pos=i;
    		}
    	}
    	display(pos);
    }

    @FXML
    void pignetoClick(ActionEvent event) {
    	int pos = 0;
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getName().equalsIgnoreCase("Pigneto")) {
    			pos=i;
    		}
    	}
    	display(pos);
    }

    @FXML
    void statuarioClick(ActionEvent event) {
    	int pos = 0;
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getName().equalsIgnoreCase("Statuario")) {
    			pos=i;
    		}
    	}
    	display(pos);
    }

    @FXML
    void submit(ActionEvent event) throws EmptyFieldException, IOException {
    	//this method creates a new event based on the information gathered
    	try {
			mc.submitEvent(titleText.getText(), nameLabelArt.getText(), descriptionText.getText());
		} catch (EmptyFieldException e) {
			ExceptionFactory ef = ExceptionFactory.getInstance();
			ExceptionView view;
			view = ef.createView(TypeException.EMPTYF);
			rootpane3.getChildren().setAll(view.getRoot());
		} catch (DescriptionTooLongException e) {
			ExceptionFactory ef = ExceptionFactory.getInstance();
			ExceptionView view;
			view = ef.createView(TypeException.TOOLONG);
			rootpane3.getChildren().setAll(view.getRoot());
		}
			
    }
    
    
    void display(int pos) {
    	//setup
    	nameLabelArt.setVisible(true);
		indirizzoLabel.setVisible(true);
		capienzaLabel.setVisible(true);
		titleText.setVisible(true);
		descriptionText.setVisible(true);
		submitButton.setVisible(true);
		
    	nameLabelArt.setText(list.get(pos).getName());
    	Integer cap = list.get(pos).getCapacity();
    	capienzaLabel.setText(cap.toString());
    	indirizzoLabel.setText(list.get(pos).getAddress());
    }

    @FXML
    void villaClick(ActionEvent event) {
    	int pos = 0;
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i).getName().equalsIgnoreCase("Villa")) {
    			pos=i;
    		}
    	}
    	display(pos);
        
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//every button (and textbox and label) starts not visible
		eurPlaceArt.setVisible(false);
		pignetoPlaceArt.setVisible(false);
		villaPlaceArt.setVisible(false);
		statuarioPlaceArt.setVisible(false);
		nameLabelArt.setVisible(false);
		indirizzoLabel.setVisible(false);
		capienzaLabel.setVisible(false);
		titleText.setVisible(false);
		descriptionText.setVisible(false);
		submitButton.setVisible(false);
		for(int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals("Eur")) {
				eurPlaceArt.setVisible(true);
			}
			else if (list.get(i).getName().equals("Statuario")) {
				statuarioPlaceArt.setVisible(true);
			}
			else if (list.get(i).getName().equals("Pigneto")) {
				pignetoPlaceArt.setVisible(true);
			}
			else if (list.get(i).getName().equals("Villa")) {
				villaPlaceArt.setVisible(true);
			}
		}
	}

}
