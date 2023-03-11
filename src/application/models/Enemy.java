package application.models;

import java.util.Hashtable;

public class Enemy {
	private String name;
	private int health = 100;
	private int attackPoints = 100;
	private Hashtable<String, EnemySettings> defaultValues = new Hashtable<String, EnemySettings>();
	
	public Enemy(String difficulty) {
		populateDefaultSettings();
		this.name = defaultValues.get(difficulty).getName();
		this.attackPoints = defaultValues.get(difficulty).getAttackPoints();
		this.health = defaultValues.get(difficulty).getHealth();
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
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
	
	private void populateDefaultSettings() {
		defaultValues.put(Constants.DIFFICULTY_EASY, new EnemySettings("Boss One", 100, 5));
		defaultValues.put(Constants.DIFFICULTY_MODERATE, new EnemySettings("Boss Two", 200, 10));
		defaultValues.put(Constants.DIFFICULTY_HARD, new EnemySettings("Boss Three", 300, 20));
	}
}
