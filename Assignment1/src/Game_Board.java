/*
 * Patrick Mahoney
 * Oct 24, 2019
 * Tic-Tac-Toe Game board class
 */
import java.util.Scanner;

public class Game_Board {

	//Player Icons
	private final char BLANK = ' ';
	private final char P1 = 'X';
	private final char P2 = 'O';
	
	//Player Information
	private int playerNum;
	private boolean whichPlayer;
	private char playerIcon;
	
	//Board Locations
	private int row_; 
	private int column_;
	
	//char Game Board
	private char[][] playerLocation = new char[3][3];
	
	//default Game Board
	Game_Board() {
		playerIcon = P1;
		playerNum = 1;
		for(int i = 0; i < playerLocation.length; i++)
			for(int j = 0; j < playerLocation[i].length; j++) {
				playerLocation[i][j] = BLANK;
			}
	}
	
	// set player controlled by switchPlayer()
	public void setPlayerOne() {
		playerIcon = P1;
		playerNum = 1;
		whichPlayer = false;
	}
	
	public void setPlayerTwo() {
		playerIcon = P2;
		playerNum = 2;
		whichPlayer = true;
	}
	//**
	
	public void setPlayerIcon(char icon) {
		playerIcon = icon;
	}	
	
	public void setPlayerNum(int player) {
		playerNum = player;
	}
	
	//setting the player icon to the row and column entered 
	public void setPlayerMark() {
		playerLocation[row_][column_] = playerIcon;
	}

	//getters
	
	// return the playerIcon at given location 
	public char getPlayerLocation(int i, int j) {
		return playerLocation[i][j];
	}
	
	public char getPlayerIcon() {
		return playerIcon;
	}
	
	public int getPlayerNum() {
		return playerNum;
	}
	
	public boolean getWhichPlayer() {
		return whichPlayer;
	}

	//*********************************
	
	//takes in row and column from user
	public void userInput() {
		Scanner input = new Scanner(System.in);	
		row_ = 0;
		column_ = 0;
		
		//output player turn message
		System.out.println("Player " + playerNum + " (" + playerIcon + ") "
				+ "Turn: ");
		
		//row
		System.out.println("Which Row would you like?"); 
		try {	
			row_  = input.nextInt() - 1;
		}
		//if not an integer
		catch(Exception someException){	
			System.out.println("Invalid Mark: Insert a Number \ntry again...");
			userInput();
		}
		
		//column
		try {	
		System.out.println("Which Column would you like?"); 
			column_  = input.nextInt() - 1;	
		}
		catch(Exception someException){	
			System.out.println("Invalid Mark: Insert a Number \ntry again...");
			userInput();
		}
		if(column_ <=2 && row_ <=2 && playerLocation[row_][column_] == BLANK ){
			playerLocation [row_][column_] = playerIcon;
		}
		else {
			System.out.println("Invalid Mark: Not a valid position \n"
					+ "try again...");
			userInput();
		}
	}

	//switch player turn 
	public void switchPlayer() {
		if(playerNum == 1) {
			setPlayerTwo();
		}
		else {
			setPlayerOne();
		}
	}
	
	//check if a player has won the game
	public boolean checkBoard() {
		
		boolean win = false;

		int count = 0;
		
		// check columns
		
		for(int i = 0; i <= 2; i++) {
			count = 0;
			for(int j = 0; j <= 2; j++) {
				if (playerLocation[i] [j] == playerIcon) {
					//System.out.println(playerLocation[i][j]);
					count++;
				}
				if(count == 3)
					win = true;
			}
		}
		
		//check rows
		
		for(int j = 0; j <= 2; j++) {
			count = 0;
			for(int i = 0; i <= 2; i++) {
				if (playerLocation[i] [j] == playerIcon) {
					count++;
				}
				if(count == 3)
					win = true;
			}
		}

		//check diagonal \

		count = 0;
		for(int i = 0; i <= 2; i++) {
			if(playerLocation[i][i] == playerIcon)
				count++;
			if(count == 3)
				win = true;
		}
		
		//check diagonal /
		
		count = 0;
		int i = 0;
		for(int j = 2; j >= 0; j--) {
			if (playerLocation[i][j] == playerIcon) {
				count++;
			}
			i++;
			if(count == 3)
				win = true;
		}
		return win;
	}

	// display the board 
	public void displayBoard() {			
		
		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j <= 2; j++) {
				//not outputing the right variable 
				if (j == 0) 
					System.out.print(" " + playerLocation[i][j] + " ");
				if(j == 1) 
					System.out.print("| " + playerLocation[i][j] + " |" );
				if (j == 2) 
					System.out.print(" " + playerLocation[i][j] + " " );
			}
			if(i < 2)
				System.out.print("\n--- --- ---\n");
		}
		System.out.print("\n\n");
	}
}