import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	private static final char[] PLAYER_CHARACTERS= {'X', 'O'};
	
	private Display display;
	
	private Scanner scanner;
	
	private String p1;
	private String p2;
	
	private ArrayList<Integer> usedNumbers;

	
	public static void main(String[] args) {
		Main main = new Main();
	}	
	/**
	 * Constructor,
	 * Initialises the usedNumbers ArrayList, calls setup, instructions, and play.
	 */
	public Main() {
		usedNumbers = new ArrayList<Integer>();
		scanner = new Scanner(System.in);
		
		setup();
		instructions();
		display = new Display();
		play();
	}
	
	/**
	 * Gets the player's names and stores them. Tells the players whom is going first.
	 */
	private void setup() {
		System.out.println("Enter your name, player one!");
		p1 = scanner.next();
		System.out.println("Enter your name, player two!");
		p2 = scanner.next();
		
		System.out.println("Welcome, " + p1 + " and " + p2 + "!");
		System.out.println(p1 + " will go first and will play as 'X' ");
	}
	/**
	 * prints the instructions to the console.
	 */
	private void instructions() {
		System.out.println("Please choose a number between 1 and 9 which corresponds to the position on the board!");
	}
	
	/**
	 * Main game loop. Prompts players for actions until there is a winner
	 */
	private void play() {
		int player = 1;
		
		while (noWinner() == false) {
			String str = new String();
			str += "It is your turn, ";
			if(player == 1) {
				str += p1;
			} else {
				str += p2;
			}
			
			System.out.println(str += " choose where you would like to play.");
			int position = scanner.nextInt();
			
			while(usedNumbers.contains(position)) {
				System.out.println(str = "That position has already been taken, choose a new spot please.");
				position = scanner.nextInt();
			}
			
			usedNumbers.add(position);
			display.update(position, PLAYER_CHARACTERS[player-1]);
			
			
			player = flip(player);
		}
		
		player = flip(player);
		String winner = "" + player;
		String winnerString ="";
		
		if (winner.equals("1")) {
			winnerString = p1;
		} else {
			winnerString = p2;
		}
		
		System.out.println("Congratulations, " + winnerString + " you have won!");
		
	}
	
	/**
	 * checks if there is a winner
	 * @return true if there is a winner
	 */
	private boolean noWinner() {
		if(display.getWinner()==null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * alternates the player's turns
	 * @param player
	 * @return
	 */
	private int flip(int player) {
		switch (player) {
		case 1: player = 2;
			break;
		case 2: player = 1;
			break;
		}
		return player;
		
	}
	
}

