package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene menuScreen;
		
		try {
			BorderPane rootTwo = (BorderPane)FXMLLoader.load(getClass().getResource("/application/views/MenuScreen.fxml"));
			menuScreen = new Scene(rootTwo, 800, 600);
			menuScreen.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			window.setScene(menuScreen);
			window.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
}
