package application.models;

import java.util.Random;

public class Question {
	private String difficulty;
	private int multiplicand;
	private int multiplier;
	private QuestionFactors factors;

	public Question(String difficulty) {
		this.setDifficulty(difficulty);
		
		// get the list of possible options to be chose from for factors (multiplicand and multiplier)
		if (difficulty == Constants.DIFFICULTY_MODERATE) {
			factors = Constants.MODERATE_FACTORS;
		} else if (difficulty == Constants.DIFFICULTY_HARD) {
			factors = Constants.MODERATE_FACTORS;
		} else { // default difficulty
			factors = Constants.EASY_FACTORS;
		}
			
		// set the multiplicand - pick randomly between multiplicandMin and multiplicandMax of factors
		this.multiplicand = getRandomBetween(factors.getMinMultiplicand(), factors.getMaxMultiplicand());
		
		// set the multiplier - pick randomly between multiplierMin and multiplierMax of factors
		this.multiplier = getRandomBetween(factors.getMinMultiplier(), factors.getMaxMultiplier());		
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
	
	private int getRandomBetween(int minValue, int maxValue) {
		Random rnd = new Random();
		return (minValue + rnd.nextInt(maxValue - minValue + 1));
	}
}
