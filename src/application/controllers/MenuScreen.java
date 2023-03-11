package application.controllers;

import javafx.fxml.FXML;

import java.util.ArrayList;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MenuScreen {

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
	protected void onBtnStartGameClicked(ActionEvent event) {
		// validate if all inputs were added
		ArrayList<String> validationErrors = this.validate();
		
		// if not valid, show alert
		if (validationErrors.size() > 0) {
			this.showAlert(Alert.AlertType.ERROR, validationErrors);
		// else initialize the GameScreen and go there 
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION, "Here comes the start Game code");
		    alert.show();
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
}
