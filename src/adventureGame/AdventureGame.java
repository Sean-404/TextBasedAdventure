package adventureGame;

import java.util.Scanner;

public class AdventureGame {
	
	private static final Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Welcome to this text-based adventure game!" + 
		"\nPlease enter your player name: ");
		String name = s.nextLine();
		Player player = new Player(name, 10, new Weapon("Plastic Sword",2));
		
		System.out.println("Welcome " + player.getPlayerName() + "!" +
		"\nIn this journey, you have choices to make.\nThese choices will influence the story and progression " +
		"of the game.\nYou must make the correct choices to survive." +
		"\n\nYour starting character has 10 HP and a Plastic Sword as your starting weapon." +
		"\nUse these wisely.");
		
		System.out.println("--- TOWN OF BEGINNINGS---");
		
	}

}
