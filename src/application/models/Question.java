package application.models;

import java.util.ArrayList;

public class Question {
	private String difficulty;
	private int multiplicand;
	private int multiplier;

	public Question(String difficulty) {
		this.setDifficulty(difficulty);
		
		// get the list of possible options to be chose from for factors (multiplicand and multiplier)
		ArrayList<Integer> factors = new ArrayList<Integer>();
		
		if (difficulty == Constants.DIFFICULTY_MODERATE) {
			factors = Constants.MODERATE_FACTORS;
		} else if (difficulty == Constants.DIFFICULTY_HARD) {
			factors = Constants.MODERATE_FACTORS;
		} else { // default difficulty
			factors = Constants.EASY_FACTORS;
		}
			
		// set the multiplicand - pick randomly an element from factors
		int multiplicandIndex = (int)(Math.random() * factors.size());
		this.multiplicand = factors.get(multiplicandIndex);
		
		// set the multiplier - pick randomly an element from factors
		int multiplierIndex = (int)(Math.random() * factors.size());
		this.multiplier = factors.get(multiplierIndex);		
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	public int correctAnswer() {
		return multiplicand * multiplier;
	}
	
	public boolean isCorrectAnswer(int answer) {
		return answer == this.correctAnswer();
	}	
	
	public String getQuestionText() {
		return String.format("%s X %s", this.multiplicand, this.multiplier);
	}	
}
