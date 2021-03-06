package adventureGame;

import java.util.Scanner;

public class AdventureGame {
	
	private static final Scanner s = new Scanner(System.in);
	public static Player player;
	public static Monster monster;
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
		System.out.println("You can either go to the (1) bakery or the (2) blacksmith. Where do you go? ");
		int choice = Integer.valueOf(s.nextLine());
		if(choice == 1) {
			goBakery();
			chooseDirection();
		} else if(choice == 2) {
			goBlacksmith();
			chooseDirection();
		} else if(choice == 3){
			viewStatistics();
			beginning();
		} else {
			System.out.println("Invalid input");
			beginning();
		}	
	}
	
	public static void chooseDirection() {
		
		System.out.println("You see a sign facing North (1), East (2), South (3) and West (4). which way will you go? (5 for stats): ");
		int choice = Integer.valueOf(s.nextLine());
		if (choice == 1) {
			System.out.println("You decided to head North\n");
			goNorth();
		}
		else if (choice == 2) {
			System.out.println("You decided to head East\n");
			goEast();
		} else if(choice == 3) {
			System.out.println("You decided to head South\n");
			goSouth();
		} else if(choice == 4) {
			System.out.println("You decided to head West\n");
			goWest();
		} else if(choice == 5) {
			viewStatistics();
			chooseDirection();
		}
		else {
			System.out.println("Invalid input");
			chooseDirection();
		}
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
		System.out.println("You receive a piece of bread from the bakery!" +
		" (+2 max health)");
		int currentHealth = player.getPlayerHealth();
		player.setPlayerHealth(currentHealth + 2);
	}
	
	public static void goBlacksmith() {
		System.out.println("You receive a sword upgrade! (+2 attack damage)");
		Weapon currentWeapon = player.getPlayerWeapon();
		int currentDamage = currentWeapon.getWeaponDamage();
		currentWeapon.setWeaponDamage(currentDamage + 2);
		player.setPlayerWeapon(currentWeapon);
	}
	
	public static void fight() {
		System.out.println("--- FIGHT ---");
		do {
			playerAttack();
			if(monster.getMonsterHealth() > 0) {
				monsterAttack();
			}
		} while((monster.getMonsterHealth() > 0));
	}
	
	public static void playerAttack() {
		System.out.println("You hit the " + monster.getMonsterName() + " with your "
				+ player.getPlayerWeapon().getWeaponName() + " and you deal " 
				+ player.getPlayerWeapon().getWeaponDamage()
				+ " damage to them!");
		int health = monster.getMonsterHealth();
		int attack = player.getPlayerWeapon().getWeaponDamage();
		monster.setMonsterHealth(health - attack);
		if(monster.getMonsterHealth() <= 0) {
			monstersKilled +=1;
			System.out.println("You killed the " + monster.getMonsterName() + "!\n");
			return;
		}
		System.out.println(monster.getMonsterName() + "'s health: " + monster.getMonsterHealth() + "\n");
	}
	
	public static void monsterAttack() {
		System.out.println("The " + monster.getMonsterName() + " deals " + 
				monster.getMonsterAttack() + " damage to you!");
		int health = player.getPlayerHealth();
		int attack = monster.getMonsterAttack();
		player.setPlayerHealth(health - attack);
		if(player.getPlayerHealth() <= 0) {
			gameOver();
			return;
		}
		System.out.println("Your health: " + player.getPlayerHealth() +"\n");
	}
	
	public static void gameOver() {
		System.out.println("\n--- YOU DIED ---\n\nGo back to the main menu? (Y/N)");
		String choice = s.nextLine();
		if(choice.equals("Y") || choice.equals("y")) {
			main(null);
		} else {
			System.out.println("Goodbye!");
			System.exit(0);
		}
	}
	
	public static void goNorth(){
		
	}
	
	public static void goEast(){
		monster = new Monster("Goblin", 5, 3);
		System.out.println("You encounter a Goblin!\n");
		System.out.println("---BEGIN BATTLE---\n");
	}
	
	public static void goSouth() {
		System.out.println("You make your way out of the village but you suddenly get hit by a boulder!");
		gameOver();
	}
	
	public static void goWest() {
		System.out.println("You find a cookie! (+1 max health)\n");
		int currentHealth = player.getPlayerHealth();
		player.setPlayerHealth(currentHealth + 1);
		System.out.println("You encounter a Troll!\n");
		monster = new Monster("Troll",5,2);
		fight();
		goWest2();
	}
	
	public static void goWest2() {
		System.out.println("The " + monster.getMonsterName() + " dropped a spiked club! (5 attack)\n"
				+ "Do you (1) pick it up or do you (2) leave it? ");
		int choice = Integer.valueOf(s.nextLine());
		if(choice == 1) {
			System.out.println("You pick up the spiked club.");
			player.setPlayerWeapon(new Weapon("Spiked Club", 5));
		} else if(choice == 2) {
			System.out.println("You leave the spiked club.");
		} else if(choice == 3) {
			viewStatistics();
			goWest2();
		} else {
			System.out.println("Invalid input.");
			goWest2();
		}
		bridgeTunnel();
	}
	
	public static void bridgeTunnel() {
		System.out.println("You find a bridge and a tunnel."
				+ "\nDo you (1) cross the bridge or (2) go through the tunnel? ");
		int choice = Integer.valueOf(s.nextLine());
		if(choice == 1) {
			goBridge();
		} else if(choice == 2) {
			goTunnel();
		} else if(choice == 3) {
			viewStatistics();
			bridgeTunnel();
		} else {
			System.out.println("Invalid input.");
			bridgeTunnel();
		}
	}
	
	public static void goBridge() {
		System.out.println("You cross the bridge and end up outside a castle.\n\nA skeleton appears!\n");
		monster = new Monster("Skeleton",6,3);
		fight();
		System.out.println("The " + monster.getMonsterName() + " dropped a healing potion! (+5 health)\n");
		player.setPlayerHealth(player.getPlayerHealth() + 5);
		goCastle();
	}
	
	public static void goTunnel() {
		
	}
	
	public static void goCastle() {
		System.out.println("You enter the castle and encounter an Elder Dragon!\nDo you (1) fight it or (2) try to talk to it? ");
		monster = new Monster("Elder Dragon",15,4);
		int choice = Integer.valueOf(s.nextLine());
		if(choice == 1) {
			fight();
			goCastle2();
		} else if(choice == 2) {
			talkToDragon();
		} else if(choice == 3) {
			viewStatistics();
			goCastle();
		} else {
			System.out.println("Invalid input");
			goCastle();
		}
	}
	
	public static void goCastle2() {
		System.out.println("The " + monster.getMonsterName() + " dropped Dragon Claws! (10 attack)\n"
				+ "Do you (1) pick it up or do you (2) leave it? ");
		int choice = Integer.valueOf(s.nextLine());
		if(choice == 1) {
			System.out.println("You pick up the Dragon Claws");
			player.setPlayerWeapon(new Weapon("Dragon Claws",10));
		} else if(choice == 2) {
			System.out.println("You leave the Dragon Claws.");
		} else if(choice == 3) {
			viewStatistics();
			goCastle2();
		}
		System.out.println("The " + monster.getMonsterName() + " also dropped the gold ring!");
		exitCastle();
	}
	
	public static void talkToDragon() {
		System.out.println("You talk to the " + monster.getMonsterName() + 
				". He asks if you are willing to give up your weapon for him."
				+ "\nDo you (1) give him your weapon or (2) not give him your weapon: ");
		int choice = Integer.valueOf(s.nextLine());
		if(choice == 1) {
			System.out.println("The " + monster.getMonsterName() + " takes your weapon.\n"
					+ "He adds Elder Dragon scales to the weapon! (+5 attack)"
					+ "\nHe lets you exit the castle with no harm.");
			Weapon currentWeapon = player.getPlayerWeapon();
			int currentDamage = currentWeapon.getWeaponDamage();
			currentWeapon.setWeaponDamage(currentDamage + 5);
			player.setPlayerWeapon(currentWeapon);
			System.out.println("The " + monster.getMonsterName() + " also gives you the gold ring!");
			exitCastle();
		} else if(choice == 2) {
			System.out.println("The " + monster.getMonsterName() + " becomes enraged by this and gains 20 attack damage!"
					+ "\nHe won't let you leave!\nYou may not win this fight!\n");
			monster.setMonsterAttack(monster.getMonsterAttack() + 20);
			fight();
		} else if(choice == 3) {
			viewStatistics();
			talkToDragon();
		} else {
			System.out.println("Invalid input");
			talkToDragon();
		}
	}

	public static void exitCastle() {
		System.out.println("\nYou exit the castle with the gold ring and return back to the village"
				+ ".\nDo you (1) give the gold ring to the village or (2) keep the ring for yourself: ");
		int choice = Integer.valueOf(s.nextLine());
		if(choice == 1) {
			System.out.println("--- GOOD ENDING ----\nYou give the gold ring to the people of the village" +
					" and they all use it to thrive and protect themselves!"
					+ "\nYou become an Elder Knight and have respect from everyone in the village.");
			ending();
		} else if(choice == 2) {
			System.out.println("--- BAD ENDING ---\nYou take the gold ring for yourself! The gold ring "
					+ "gives you immense power,\nwhich eventually corrupts you and causes the destruction of the village!"
					+ "\nBetter luck next time!");
			ending();
		}
	}
	
	public static void ending() {
		System.out.println("\n--- GAME OVER ---\n\nThanks for playing!\nYour final player statistics:\n");
		viewStatistics();
		System.exit(0);
	}
	
}
