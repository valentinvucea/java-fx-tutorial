package application;
	
import java.io.IOException;
import java.util.ArrayList;

import application.models.Game;
import application.models.Player;
import application.models.QuestionsHistory;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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
	public static ArrayList<QuestionsHistory> questionsHistory = new ArrayList<QuestionsHistory>();
	
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
			BorderPane rootTwo = (BorderPane)FXMLLoader.load(getClass().getResource("/application/views/WelcomeScreen.fxml"));
			Image welcomeBackground = new Image((getClass().getResource("/application/resources/welcome.jpg").toExternalForm()));
		    BackgroundSize bSize = new BackgroundSize(800, 600, false, false, true, false);
		    rootTwo.setBackground(new Background(new BackgroundImage(welcomeBackground,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundRepeat.NO_REPEAT,
		            BackgroundPosition.CENTER,
		            bSize)));
		    
		    welcomeScreen = new Scene(rootTwo, 800, 600);
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
