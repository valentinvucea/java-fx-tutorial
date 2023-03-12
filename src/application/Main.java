package application;
	
import java.io.IOException;

import application.models.Game;
import application.models.Player;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static Stage mainStage;
	public static Scene welcomeScreen;
	public static Scene menuScreen;
	public static Scene helpScreen;
	public static Scene battleScreen;
	public static Player player;
	public static Game game;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			mainStage = primaryStage;
			
			// Initialize scenes		
			initWelcomeScreen();
			initHelpScreen();
			initMenuScreen();
			
			// Launch WelcomeScreen
			mainStage.setScene(welcomeScreen);
			mainStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void initWelcomeScreen() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/views/WelcomeScreen.fxml"));
			welcomeScreen = new Scene(root, 800, 600);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initHelpScreen() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/views/HelpScreen.fxml"));
			helpScreen = new Scene(root, 800, 600);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initMenuScreen() {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/views/MenuScreen.fxml"));
			menuScreen = new Scene(root, 800, 600);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
