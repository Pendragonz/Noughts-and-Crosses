
public class Display {
	private String[] board;
	
	public Display() {
		board = new String[9];
		for(int i = 0; i < board.length; i++ ) {
			board[i] = "" + i;
		}
		show();
	}
	
	public void update(Integer position, char xo) {
		board[position] = "" + xo;
		show();
	}
	
	public String getWinner() {
		//horizontal
		if(board[0].equals(board[1]) && board[1].equals(board[2])) { //top
			return board[0];
		} else if(board[3].equals(board[4]) && board[4].equals(board[5])) {//middle
			return board[3];
		} else if(board[6].equals(board[7]) && board[7].equals(board[8])) {//bottom
			return board[6];
		//vertical
		} else if(board[0].equals(board[3]) && board[3].equals(board[6])) {//left
			return board[0];
		} else if(board[1].equals(board[4]) && board[4].equals(board[7])) {//middle
			return board[1];
		} else if(board[2].equals(board[5]) && board[5].equals(board[8])) {//right
			return board[2];
		//diagonal
		} else if(board[6] == board[4] && board[4] == board[2]) {//bottom -> top
			return board[6];
		} else if(board[0] == board[4] && board[4] == board[8]) {//top -> bottom
			return board[0];
		} else {
			return null;
		}
		
	}
	
	
	private void show() {
		String str = new String();
		
		str += " " + board[0] + " | " + board[1] + " | " + board[2] + "\n";
		str += " " + board[3] + " | " + board[4] + " | " + board[5] + "\n";
		str += " " + board[6] + " | " + board[7] + " | " + board[8] + "\n";
		
		System.out.println(str);
	}
	
	
	
}
