package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import application.models.Game;
import application.models.Player;
import application.models.Question;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BattleScreen implements Initializable {
	
	@FXML
	private Label battleScreenTitle;
	
	@FXML
	private Label lblPlayerName;
	
	@FXML
	private Label lblPlayerHealth;	
	
	@FXML
	private Label lblEnemyName;
	
	@FXML
	private Label lblEnemyHealth;		
	
	@FXML
	private ProgressBar playerHealthBar;

	@FXML
	private ProgressBar enemyHealthBar;
	
	@FXML
	private ImageView playerImage;
	
	@FXML
	private ImageView enemyImage;
	
	@FXML
	private Button btnContinue;
	
	@FXML
	private Button btnBack;
	
	// modal window
	private Stage challengeStage;
	
	// question screen that will run in the modal window
	private Scene challengeScreen;
				
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO
	}
	
	public void updateScreen() {
		// Player name, image and progress bar
		lblPlayerName.setText(Main.game.getPlayer().getName());
		playerImage.setImage(new Image((getClass().getResource("/application/resources/elGato.png").toExternalForm())));
		int playerHealth = Main.game.getPlayer().getHealth();
		int playerMaxHealth = Main.game.getPlayer().getMaxHealth();
		// cast integers to double otherwise the division will be 0
		playerHealthBar.setProgress((double) playerHealth / (double) playerMaxHealth);
		lblPlayerHealth.setText(playerHealth + "/" + playerMaxHealth);
		
		// Enemy name, image and progress bar
		lblEnemyName.setText(Main.game.getEnemy().getName());
		enemyImage.setImage(new Image((getClass().getResource("/application/resources/" + Main.game.getEnemy().getImage()).toExternalForm())));
		int enemyHealth = Main.game.getEnemy().getHealth();
		int enemyMaxHealth = Main.game.getEnemy().getMaxHealth();
		// cast integers to double otherwise the division will be 0
		enemyHealthBar.setProgress((double) enemyHealth / (double) enemyMaxHealth);
		lblEnemyHealth.setText(enemyHealth + "/" + enemyMaxHealth);
	}
	
	public void updateGameByPlayer(boolean isCorrectAnswer) {
		// Update Enemy health
		int enemyHealth = Main.game.getEnemy().getHealth();
		if (isCorrectAnswer == true) {
			enemyHealth = enemyHealth - Main.game.getPlayer().getAttackPoints();
			if (enemyHealth < 0) {
				enemyHealth = 0;
			}
		}
		Main.game.getEnemy().setHealth(enemyHealth);
		
		// Update screen elements & game
		int enemyMaxHealth = Main.game.getEnemy().getMaxHealth();
		enemyHealthBar.setProgress((double) enemyHealth / (double) enemyMaxHealth);
		lblEnemyHealth.setText(enemyHealth + "/" + enemyMaxHealth);
			
		// TODO: If health is 0, run VICTORY procedure: show a screen, update the message, show Quit button
	}
	
	@FXML
	protected void onBtnBackClicked(ActionEvent event) {	
		Scene menuScreen = Main.menuScreen;
		Main.mainStage.setScene(menuScreen);
		Main.mainStage.show();
	}
	
	@FXML
	protected void onContinueClicked(ActionEvent event) throws IOException {					
		// Get ChallengeScreen controller from FXML
		ChallengeScreen challengeScreenController;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/ChallengeScreen.fxml"));
		BorderPane root = loader.load();
		challengeScreenController = loader.getController();
		
		// Create a new stage that will run inside the main stage
		setChallengeStage();
		
		// Create or set the challenge scene that will run inside the new stage
		setChallengeScene(root);
		
		// generate a new question
		Question question = new Question(Main.game.getDifficulty());
		
		// Update the challenge scene with updated question
		challengeScreenController.initScreen(question, this);
		
		// Finally, set the scene to the new stage and show it
		challengeStage.setScene(challengeScreen);
		challengeStage.show();
	}
	
	private void setChallengeStage() {		
		// create a new stage and remove minimize and maximize buttons - UTILITY
		this.challengeStage = new Stage(StageStyle.UTILITY);
		
		// disable close button
		this.challengeStage.setOnCloseRequest((event) -> event.consume());
		
		// position the new stage (in center of the main stage)
		this.challengeStage.setX(Main.mainStage.getX() + 80); // mainStage position X + ((800 - 640) / 2)
		this.challengeStage.setY(Main.mainStage.getY() + 60); // mainStage position X + ((600 - 480) / 2)
		
		// set the new stage as WINDOW_MODAL (when opened the users cannot interact with other stages in the application)
		this.challengeStage.initModality(Modality.WINDOW_MODAL);
		
		// set the owner of the new stage - the primary stage
		this.challengeStage.initOwner(Main.mainStage); 
	}
	
	private void setChallengeScene(BorderPane root) {
		this.challengeScreen = null;
		
		// Set the background to root first
		Image battleBackground = new Image((getClass().getResource("/application/resources/challengeBackground.png").toExternalForm()));
		BackgroundSize bSize = new BackgroundSize(640, 480, false, false, true, false);
		root.setBackground(new Background(new BackgroundImage(battleBackground,
			BackgroundRepeat.NO_REPEAT,
		    BackgroundRepeat.NO_REPEAT,
		    BackgroundPosition.CENTER,
		    bSize
	    )));
		
		// Add some borders too
		root.setStyle("-fx-border-color: black");
		root.setStyle("-fx-border-size: 3");
		    
		// Create the scene
		challengeScreen = new Scene(root, 640, 480);
	}

}
