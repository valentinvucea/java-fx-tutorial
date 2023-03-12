package application.models;

public class Game {
	private Player player;
	private Enemy enemy;
	private String difficulty;
	private boolean gameStarted = false;
	private boolean gameEnded = true;
	
	public Game(Player player, String difficulty) {
		this.player = player;
		this.difficulty = difficulty;
		this.enemy = new Enemy(difficulty);
	}
	
	public boolean isGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}

	public boolean isGameEnded() {
		return gameEnded;
	}

	public void setGameEnded(boolean gameEnded) {
		this.gameEnded = gameEnded;
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Enemy getEnemy() {
		return enemy;
	}
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
}
