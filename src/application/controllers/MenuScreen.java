package application.controllers;

import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MenuScreen {

	@FXML
	private Button btnExitGame;
	
	@FXML
	protected void onBtnExitGameClicked(ActionEvent event) {
		Platform.exit();
	}
}
