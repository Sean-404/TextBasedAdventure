package adventureGame;

public class Player {
	
	private String playerName;
	private int playerHealth;
	private Weapon playerWeapon;
	
	public Player(String playerName, int playerHealth, Weapon weapon) {
		this.playerName = playerName;
		this.playerHealth = playerHealth;
		this.playerWeapon = weapon;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getPlayerHealth() {
		return playerHealth;
	}

	public void setPlayerHealth(int playerHealth) {
		this.playerHealth = playerHealth;
	}

	public Weapon getPlayerWeapon() {
		return playerWeapon;
	}

	public void setPlayerWeapon(Weapon playerWeapon) {
		this.playerWeapon = playerWeapon;
	}

}
