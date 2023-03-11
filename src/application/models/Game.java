package application.models;

public class Game {
	private Player player;
	private Enemy enemy;
	
	public Game() {
		player = new Player("Daria");
		enemy = new Enemy();
	}
	
}
