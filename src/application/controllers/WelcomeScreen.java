package application.controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class WelcomeScreen {

	@FXML
	private Button btnStart;
	
	@FXML
	protected void onBtnStartClicked(ActionEvent event) {
		Alert popup = new Alert(Alert.AlertType.INFORMATION, "This button works!");
		popup.show();
	}
}
