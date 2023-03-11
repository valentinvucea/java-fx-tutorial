package application.controllers;

import javafx.fxml.FXML;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class MenuScreen {

	@FXML
	private Button btnExitGame;
	
	@FXML
	private Button btnStartGame;
	
	@FXML
	protected void onBtnExitGameClicked(ActionEvent event) {
		Platform.exit();
	}
	
	@FXML
	protected void onBtnGameRulesClicked(ActionEvent event) {
		Scene helpScreen = Main.helpScreen;
		Main.mainStage.setScene(helpScreen);
		Main.mainStage.show();
	}
	
	@FXML
	protected void onBtnStartGameClicked(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "This will open the BattleScreen");
		alert.show();
	}
}
