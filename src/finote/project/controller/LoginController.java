package finote.project.controller;

import java.net.URL;
import java.util.ResourceBundle;

import finote.project.main.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	
	private MainApp mainApp;

	@FXML
	private TextField txtUsername;
	
	@FXML
	private PasswordField txtPassword;
	
	@FXML
	private Button btnLogin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void onLogin(){
		if(txtUsername.getText().equals("fajri") && txtPassword.getText().equals("fajri")){
			this.mainApp.getPrimaryStage().setScene(this.mainApp.getHomeScene());
		}
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	
	
}
