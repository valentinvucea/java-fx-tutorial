package application.models;

public class Player {
	private int health = 100;
	private int maxHealth = 100;	
	private String difficultyUnlocked = Constants.DIFFICULTY_EASY;
	private int attackPoints = 10;
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

	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
}
