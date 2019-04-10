package TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TicTac {

	public static final int X = 1, O = -1;
	public static final int EMPTY = 0;
	private int board[][] = new int [3][3];
	private int player;

	public TicTac() {
		clearBoard();
	}

	private void clearBoard() {
		for (int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				board[i][j] = EMPTY;
		player = X;
	}

	public void setMark(int i, int j) throws IllegalArgumentException{
		if((i<0)||(i>2)||(j<0)||(j>2)) 
			throw new IllegalArgumentException("out of board");
		if (board[i][j]!=EMPTY)
			throw new IllegalArgumentException("position taken");
		board[i][j] = player;
		player= -player;
	}

	public boolean checkWin(int mark) {
		return ((board[0][0]+board[0][1]+board[0][2]==mark*3)
				||(board[1][0]+board[1][1]+board[1][2]==mark*3)
				||(board[2][0]+board[2][1]+board[2][2]==mark*3)
				||(board[0][0]+board[1][1]+board[2][2]==mark*3)
				||(board[0][1]+board[1][1]+board[2][1]==mark*3)
				||(board[0][2]+board[1][2]+board[2][2]==mark*3)
				||(board[0][0]+board[1][1]+board[2][2]==mark*3)
				||(board[2][0]+board[1][1]+board[0][2]==mark*3));

	}

	public int winner() {
		if(checkWin(X))
			return (X);
		else if (checkWin(O))
			return (O);
		else 
			return (0);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				switch (board[i][j]) {
				case X:			sb.append("X");break;
				case O:			sb.append("O");break;
				case EMPTY:		sb.append(" ");break;
				}
				if (j<2) sb.append("|");
			}
			if (i<2) sb.append("\n------\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		TicTac game = new TicTac();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("-------------------------");
		System.out.println("      Tic Tac Toe");
		System.out.println("-------------------------");
		System.out.println("A|B|C     Choose a square");
		System.out.println("-|-|-");
		System.out.println("D|E|F     and press enter!");
		System.out.println("-|-|-");
		System.out.println("G|H|I     'exit' to quit");
		System.out.println("------------------------\n");	

		while(true) {

			try {
				String input=br.readLine().toUpperCase();
				if(input.equalsIgnoreCase("exit")) {
					System.out.println("done");
					System.exit(0);
				}
				else 
					switch(input) {
					case "A": game.setMark(0,0);
					break;
					case "B": game.setMark(0,1);
					break;
					case "C": game.setMark(0,2);
					break;
					case "D": game.setMark(1,0);
					break;
					case "E": game.setMark(1,1);
					break;
					case "F": game.setMark(1,2);
					break;
					case "G": game.setMark(2,0);
					break;
					case "H": game.setMark(2,1);
					break;
					case "I": game.setMark(2,2);	
					break;
					}
				System.out.println(game);
				int winner = game.winner();
				String[]result= {"O wins","Tie","X wins"};
				System.out.println(result[1+winner]);
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

}
