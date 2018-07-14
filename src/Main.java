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
	
	public Main() {
		usedNumbers = new ArrayList<Integer>();
		scanner = new Scanner(System.in);
		
		setup();
		instructions();
		display = new Display();
		play();
	}
	
	private void setup() {
		System.out.println("Enter your name, player one!");
		p1 = scanner.next();
		System.out.println("Enter your name, player two!");
		p2 = scanner.next();
		
		System.out.println("Welcome, " + p1 + " and " + p2 + "!");
		System.out.println(p1 + " will go first and will play as 'X' ");
	}
	
	private void instructions() {
		System.out.println("Please choose a number between 1 and 9 which corresponds to the position on the board!");
	}
	
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
			int pos = scanner.nextInt();
			
			display.update(pos, PLAYER_CHARACTERS[player-1]);
			
			
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
	
	private boolean noWinner() {
		if(display.getWinner()==null) {
			return false;
		} else {
			
			return true;
		}
	}
	
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

