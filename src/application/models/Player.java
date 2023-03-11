package application.models;

public class Player {
	private int health = 100;
	private String difficultyUnlocked = Constants.DIFFICULTY_EASY;
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
	}

	public String getDifficultyUnlocked() {
		return difficultyUnlocked;
	}

	public void setDifficultyUnlocked(String difficultyUnlocked) {
		this.difficultyUnlocked = difficultyUnlocked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
