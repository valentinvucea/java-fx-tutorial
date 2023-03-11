package application.models;

public class Player {
	private int health = 100;
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
}
