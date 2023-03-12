package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.models.Constants;
import application.models.Game;
import application.models.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class MenuScreen implements Initializable {

	@FXML
	private TextField txtYourName;
	
	@FXML
	private RadioButton radioEasy;
	
	@FXML
	private RadioButton radioModerate;
	
	@FXML
	private RadioButton radioHard;
	
	@FXML
	private Button btnExitGame;
	
	@FXML
	private Button btnStartGame;
	
	@FXML
	private Button btnGameRules;
	
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
	protected void onBtnStartGameClicked(ActionEvent event) throws IOException {
		// validate if all inputs were added
		ArrayList<String> validationErrors = this.validate();
		
		// if not valid, show alert
		if (validationErrors.size() > 0) {
			this.showAlert(Alert.AlertType.ERROR, validationErrors);
		// else initialize the GameScreen and go there 
		} else {	
			// Get player
			String playerName = txtYourName.getText().trim();
			if (Main.player == null || Main.player.getName() != playerName) {
				Main.player = new Player(playerName);
			}
			
			// Create new game
			Main.game = new Game(Main.player, getDifficulty());
			
			// Setup BattleScene
			Scene battleScreen;
			BattleScreen battleScreenController;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/BattleScreen.fxml"));
			BorderPane root = loader.load();
			battleScreenController = loader.getController();
			
			if (Main.battleScreen == null) {
				battleScreen = new Scene(root, 800, 600);
				Main.battleScreen = battleScreen;
			}
			
			battleScreenController.updateScreen();
			Main.mainStage.setScene(Main.battleScreen);
			Main.mainStage.show();
		}
	}
	
	private String getDifficulty() {
		if (radioModerate.isSelected() == true) {
			return Constants.DIFFICULTY_MODERATE;
		} else if (radioHard.isSelected() == true) {
			return Constants.DIFFICULTY_HARD;
		} else {
			return Constants.DIFFICULTY_EASY;
		}
	}
	
	private ArrayList<String> validate() {
		ArrayList<String> errors = new ArrayList<String>();
		
		// check is user name was added
		String user = txtYourName.getText().trim();
		if (user == "" || user.length() < 4) {
			errors.add("User name not added or too short");
		}
		
		// check if a difficulty level was selected
		if (!radioEasy.isSelected() && !radioModerate.isSelected() && !radioHard.isSelected()) {
			errors.add("You need to select a difficulty level");
		}
		
		return errors;
	}
	
	private void showAlert(Alert.AlertType type, ArrayList<String> errors) {
		Alert alert = new Alert(type);

	    String message = String.join("\n", errors);
	    Label t = new Label(message);
	    alert.getDialogPane().setContent(t);
	    alert.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (Main.player != null) {
			txtYourName.setText(Main.player.getName());
			
			String difficultyUnlocked = Main.player.getDifficultyUnlocked();
			if (difficultyUnlocked == Constants.DIFFICULTY_MODERATE) {
				radioModerate.setDisable(false);
				radioModerate.setSelected(true);
			} else if (difficultyUnlocked == Constants.DIFFICULTY_HARD) {
				radioModerate.setDisable(false);
				radioModerate.setSelected(false);
				radioHard.setDisable(false);
				radioHard.setSelected(true);
			}
		}
	}
}
