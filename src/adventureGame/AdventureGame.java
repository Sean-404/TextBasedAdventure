package adventureGame;

import java.util.Scanner;

public class AdventureGame {
	
	private static final Scanner s = new Scanner(System.in);
	public static Player player;
	private static int monstersKilled;
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to this text-based adventure game!" + 
		"\nPlease enter your player name: ");
		String name = s.nextLine();
		player = new Player(name, 10, new Weapon("Plastic Sword",2));
		
		System.out.println("Welcome " + player.getPlayerName() + "!" +
		"\nIn this journey, you have choices to make.\nThese choices will influence the story and progression " +
		"of the game.\nYou must make the correct choices to survive." +
		"\n\nYour starting character has 10 HP and a Plastic Sword as your starting weapon." +
		"\nUse these wisely.");
		System.out.println("You can type (3) to view your statistics at any time.\n");
		beginning();
	}
	
	public static void beginning() {
		
		System.out.println("--- TOWN OF BEGINNINGS---\n");
		System.out.println("You can either go to the (1) bakery or the (2) blacksmith. Where do you go (1 or 2)? ");
		int choice = Integer.valueOf(s.nextLine());
		if(choice == 1) {
			goBakery();
		} else if(choice == 2) {
			goBlacksmith();
		} else if(choice == 3){
			viewStatistics();
			beginning();
		} else {
			System.out.println("Invalid input");
			beginning();
		}
		
		//Monster goblin = new Monster("Goblin", 4, 2);
	}
	
	public static void viewStatistics() {
		System.out.println("--- Player Statistics ---\n");
		String name = player.getPlayerName();
		int health = player.getPlayerHealth();
		Weapon weapon = player.getPlayerWeapon();
		String weaponName = weapon.getWeaponName();
		int weaponDamage = weapon.getWeaponDamage();
		System.out.println("Player name: " + name +
		" | Player health: " + health +
		" | Weapon name: " + weaponName +
		" | Weapon damage: " + weaponDamage +
		" | Monsters killed: " + monstersKilled);
	}
	
	public static void goBakery() {
		System.out.println("You receive a piece of break from the bakery!" +
		" (+2 max health)");
		int currentHealth = player.getPlayerHealth();
		player.setPlayerHealth(currentHealth + 2);
	}
	
	public static void goBlacksmith() {
		System.out.println("You receive a wooden sword! (+2 attack damage)");
		Weapon currentWeapon = player.getPlayerWeapon();
		int currentDamage = currentWeapon.getWeaponDamage();
		currentWeapon.setWeaponDamage(currentDamage + 2);
		player.setPlayerWeapon(currentWeapon);
		System.out.println(player.getPlayerWeapon().getWeaponDamage());
	}

}
