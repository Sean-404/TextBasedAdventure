package adventureGame;

public class Player {
	
	private String playerName;
	private int playerHealth;
	
	public Player(String playerName, int playerHealth) {
		this.playerName = playerName;
		this.playerHealth = playerHealth;
	}
	
	public String getName() {
		return playerName;
	}
	
	public int getHealth() {
		return playerHealth;
	}

}
