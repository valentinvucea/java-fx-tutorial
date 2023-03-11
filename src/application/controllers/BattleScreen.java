package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class BattleScreen {
	
	@FXML
	private Button btnBack;
	
	@FXML
	private Button btnGameRules;
	
	@FXML
	private Text txtGameRules;
		
	@FXML
	protected void onBtnBackClicked(ActionEvent event) {	
		Scene menuScreen = Main.menuScreen;
		Main.mainStage.setScene(menuScreen);
		Main.mainStage.show();
	}
}
