package application.models;

public class EnemySettings {
	private String name;
	private int health;
	private int attackPoints;
	private String image;
	
	public EnemySettings(String name, int health, int attackPoints, String image) {
		this.setName(name);
		this.setHealth(health);
		this.setAttackPoints(attackPoints);
		this.setImage(image);		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
