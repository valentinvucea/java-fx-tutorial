package application.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.models.Question;
import application.models.QuestionsHistory;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChallengeScreen implements Initializable {
	
	@FXML
	private Label lblQuestion;
	
	@FXML
	private Label lblMessage;
	
	@FXML
	private TextField txtAnswer;
		
	@FXML
	private ImageView imgResult;
	
	@FXML
	private Button btnContinue;
	
	@FXML
	private Button btnCheck;
	
	private Question question;
	private BattleScreen parent;
	private int answer;
	
	private static final String CORRECT_ICON = "correctIcon.png";
	private static final String WRONG_ICON = "wrongIcon.png";
	
	@FXML
	protected void onBtnContinueClicked(ActionEvent event) {
		boolean isCorrectAnswer = this.question.isCorrectAnswer(this.answer);
		
		// Add challenge to game history
		QuestionsHistory record = new QuestionsHistory(
			this.question.getQuestionText(),
			this.answer,
			isCorrectAnswer,
			Main.player.getName(),
			this.question.getDifficulty()
		);
		Main.questionsHistory.add(record);
		
		// TODO: update game
		parent.updateGameByPlayer(isCorrectAnswer);
		
		// TODO: update BattleScreen
		
		// Get a handle to the stage using the button and close it
	    Stage challengeStage = (Stage) btnContinue.getScene().getWindow();
	    challengeStage.close();
	}
	
	@FXML
	protected void onBtnCheckClicked(ActionEvent event) {
		try {
			// validate for the correct input - force the input into a integer that will throw errors
			this.answer = Integer.parseInt(txtAnswer.getText().trim());

			// Evaluate the answer and show labels, buttons, etc
			if (false == question.isCorrectAnswer(this.answer)) {
				imgResult.setImage(new Image((getClass().getResource("/application/resources/" + WRONG_ICON).toExternalForm())));
				String message = "Sorry... your answer is wrong!\n"
						+ "The correct answer is " + question.correctAnswer() + "\n" 
						+ "You did not earn any points for this attack.\n"
						+ "Click Continue to return to the Battle";
				lblMessage.setText(message);
				lblMessage.setTextFill(Color.color(1, 0, 0));
			} else {
				imgResult.setImage(new Image((getClass().getResource("/application/resources/" + CORRECT_ICON).toExternalForm())));
				String message = "Good Job! Your answer is correct.\n"
						+ "You earned 10 points for this attack.\n"
						+ "Click Continue to return to the Battle"; // change here to use the player attack points 
				lblMessage.setText(message);
				lblMessage.setTextFill(Color.color(0, 1, 0));
			}
			
			imgResult.setVisible(true);
			lblMessage.setVisible(true);
			btnContinue.setVisible(true);
			btnCheck.setDisable(true);
			
		} catch (NumberFormatException ex){
			// Show an alert if the number entered is not an integer
			Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a number for your answer");
			alert.show();
        }	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO
	}
	
	public void initScreen(Question q, BattleScreen parentController) {
		this.question = q;
		this.parent = parentController;
		
		lblQuestion.setText(question.getQuestionText());
		txtAnswer.setText(null);
		imgResult.setVisible(false);
		lblMessage.setVisible(false);
		lblMessage.setText(null);
		btnContinue.setVisible(false);
		btnCheck.setDisable(false);
	}
}
