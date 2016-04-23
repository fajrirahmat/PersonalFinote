package finote.project.main;

import finote.project.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private FXMLLoader loader;
	private Scene scene;
	private Stage primaryStage;
	
	private Scene homeScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		
		loader = new FXMLLoader(MainApp.class.getResource("../view/login.fxml"));
		AnchorPane loginPane = loader.load();
		this.scene = new Scene(loginPane);
		LoginController loginController = loader.getController();
		loginController.setMainApp(this);
		
		//load moveon.fxml
		loader = new FXMLLoader(MainApp.class.getResource("../view/moveon.fxml"));
		AnchorPane homePane = loader.load();
		this.homeScene = new Scene(homePane);
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("LOGIN");
		primaryStage.show();
		
	}
	
	public static void main(String[] args){
		launch(args);
	}

	public Scene getScene() {
		return scene;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public Scene getHomeScene() {
		return homeScene;
	}
}
