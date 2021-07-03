package logic.appcontroller;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import logic.controller.GraphicControllerLogin;
import javafx.scene.Scene;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		primaryStage.setTitle("ShowRoome");
		GraphicControllerLogin gcl = new GraphicControllerLogin();
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/boundary/Login.fxml"));
		loader.setController(gcl);
		Scene scene=new Scene(loader.load());
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
