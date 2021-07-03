package logic.controller;

import java.net.URL;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import logic.appcontroller.MapController;
import logic.bean.EventBean;


public class ControllerHomepage2 implements Initializable{
	@FXML
    private AnchorPane rootpane3;

    @FXML
    private Label nameLabel1;

    @FXML
    private Label descriptionLabel1;

    @FXML
    private Label nameLabel2;

    @FXML
    private Label descriptionLabel2;

    @FXML
    private Label nameLabel3;

    @FXML
    private Label descriptionLabel3;
    
    MapController mc = new MapController();
	List<EventBean> list = mc.liveEventsList();
	int dim = list.size();
   

    @FXML
    void caricainfo(MouseEvent event) {
    	//not used
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nameLabel1.setText("");
		nameLabel2.setText("");
		nameLabel3.setText("");
		descriptionLabel1.setText("");
		descriptionLabel2.setText("");
		descriptionLabel3.setText("");
		
		int j = 3;
		if (dim<j) {
			j=dim;
		}
		Collections.shuffle(list);
		for (int i = 0; i < j; i++) {
			if (i==0) {
				nameLabel1.setText(list.get(i).getName());
				descriptionLabel1.setText(list.get(i).getDescription());
				
				}
			else if (i==1) {
				nameLabel2.setText(list.get(i).getName());
				descriptionLabel2.setText(list.get(i).getDescription());
				
				}
			else if (i==2) {
				nameLabel3.setText(list.get(i).getName());
				descriptionLabel3.setText(list.get(i).getDescription());
				
				}
		}
	}
}
