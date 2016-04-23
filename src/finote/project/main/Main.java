package finote.project.main;

import finote.project.controller.TransactionController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
	private Stage primaryStage;
	
	private Scene scene;
	private Scene scene2;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/PerFinote.fxml"));
		AnchorPane pane = loader.load();
		scene = new Scene(pane);
		
		TransactionController transactionController = loader.getController();
		transactionController.setMainApp(this);
		
		loader = new FXMLLoader(getClass().getResource("../view/TransactionEdit.fxml"));
		Pane transactionEditPane = loader.load();
		scene2 = new Scene(transactionEditPane);
		
		primaryStage.setTitle("Personal Finote");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args){
		launch(args);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public Scene getScene() {
		return scene;
	}

	public Scene getScene2() {
		return scene2;
	}
	
	
	
	
	
}
