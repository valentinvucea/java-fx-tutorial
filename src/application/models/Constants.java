package application.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {
	private Constants() { }  // Prevents instantiation

    public static final String DIFFICULTY_EASY = "easy";
    public static final String DIFFICULTY_MODERATE = "moderate";
    public static final String DIFFICULTY_HARD = "Hard";
    
    public static final QuestionFactors EASY_FACTORS = new QuestionFactors(0,5,0,5); // multiplicands: 1-3, multipliers: 1-9
    public static final QuestionFactors MODERATE_FACTORS = new QuestionFactors(5,10,5,10); // multiplicands: 4-6, multipliers: 1-9
    public static final QuestionFactors HARD_FACTORS = new QuestionFactors(10,15,10,15); // multiplicands: 7-9, multipliers: 1-9
    public static final QuestionFactors ALL_FACTORS = new QuestionFactors(1,9,1,9); // multiplicands: 1-9, multipliers: 1-9
}
