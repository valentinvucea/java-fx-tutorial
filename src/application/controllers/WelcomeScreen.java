package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WelcomeScreen {

	@FXML
	private Button btnStart;
	
	@FXML
	private Button btnShowAlert;
		
	@FXML
	protected void onShowAlertClicked(ActionEvent event) {
		Alert popup = new Alert(Alert.AlertType.INFORMATION, "This button works!");
		popup.show();
	}
	
	@FXML
	protected void onBtnStartClicked(ActionEvent event) {
		Scene menuScreen = Main.menuScreen;
		Main.mainStage.setScene(menuScreen);
		Main.mainStage.show();
	}
	
}
