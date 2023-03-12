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
import application.models.Game;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class BattleScreen implements Initializable {
	
	@FXML
	private Label battleScreenTitle;
	
	@FXML
	private Button btnBack;
				
	@FXML
	protected void onBtnBackClicked(ActionEvent event) {	
		Scene menuScreen = Main.menuScreen;
		Main.mainStage.setScene(menuScreen);
		Main.mainStage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO
	}
	
	public void updateScreen() {
		battleScreenTitle.setText(Main.game.getPlayer().getName() + " vs. " + Main.game.getEnemy().getName());
	}
}
