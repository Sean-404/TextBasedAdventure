package adventureGame;

import java.util.Scanner;

public class AdventureGame {
	
	private static final Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to this text based adventure game!" +
		"\nPlease enter your player name: ");
		String name = s.nextLine();
		Player player = new Player(name, 10);
		
	}

}
