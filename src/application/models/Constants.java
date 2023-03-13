package application.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {
	private Constants() { }  // Prevents instantiation

    public static final String DIFFICULTY_EASY = "easy";
    public static final String DIFFICULTY_MODERATE = "moderate";
    public static final String DIFFICULTY_HARD = "Hard";
    
    public static final ArrayList<Integer> EASY_FACTORS = new ArrayList<Integer>(Arrays.asList(1,2,3));
    public static final ArrayList<Integer> MODERATE_FACTORS = new ArrayList<Integer>(Arrays.asList(4,5,6));
    public static final ArrayList<Integer> HARD_FACTORS = new ArrayList<Integer>(Arrays.asList(7,8,9));
}
