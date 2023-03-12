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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

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
	private Button btnPlayerAttack;
	
	@FXML
	private Button btnEnemyAttack;	
	
	@FXML
	private Button btnBack;
				
	@FXML
	protected void onBtnBackClicked(ActionEvent event) {	
		Scene menuScreen = Main.menuScreen;
		Main.mainStage.setScene(menuScreen);
		Main.mainStage.show();
	}
	
	@FXML
	protected void onPlayerAttack(ActionEvent event) {	
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "Player attack started!");
		alert.show();
	}
	
	@FXML
	protected void onEnemyAttack(ActionEvent event) {	
		Alert alert = new Alert(Alert.AlertType.WARNING, "Enemy attack started!");
		alert.show();
	}		

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO
	}
	
	public void updateScreen() {
		// Player
		lblPlayerName.setText(Main.game.getPlayer().getName());
		playerImage.setImage(new Image((getClass().getResource("/application/resources/elGato.png").toExternalForm())));
		playerHealthBar.setProgress(1);
		lblPlayerHealth.setText("100/100");
		
		// Enemy
		lblEnemyName.setText(Main.game.getEnemy().getName());
		String path = "/application/resources/" + Main.game.getEnemy().getImage();
		enemyImage.setImage(new Image((getClass().getResource("/application/resources/" + Main.game.getEnemy().getImage()).toExternalForm())));
		enemyHealthBar.setProgress(1);
		int enemyMaxHealth = Main.game.getEnemy().getHealth();
		lblEnemyHealth.setText(enemyMaxHealth + "/" + enemyMaxHealth);
		
	}
}
