/*
 * Patrick Mahoney
 * Oct 24, 2019
 * Tic-Tac-Toe Game (Assignment 1)
 */

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {	

		Game_Board board = new Game_Board();
		
		boolean cats = false;
		boolean winner = false;
		
		displayWelcome();
		board.displayBoard();
		
		while(winner == false && board.checkBoard() == false && cats == false) {
			
			//obtain row and column from user
			board.userInput();
			
			//display board
			board.displayBoard();
			
			winner = board.checkBoard();
			
			//switch player
			board.switchPlayer();
			
			//check for cats game
			cats = catsGame(board);
		}
		
		//output result 
		
		// not a cats game and use whichPlayer to know who won 
		if(cats == false) {
			if(board.getWhichPlayer())
				System.out.println("Player 1 (X) Wins!");
			else

				System.out.println("Player 2 (O) Wins!");	
		}
		//output cats game
		else 
			System.out.println("Cats Game");
	}
	
	//check if cats game 
	public static boolean catsGame(Game_Board cats) {
			boolean catsGame = false;
			int count = 0;
			for(int i = 0; i <= 2; i++) {
				for(int j = 0; j <= 2; j++) {
					if (cats.getPlayerLocation(i,j) == 'X' || 
							cats.getPlayerLocation(i,j) == 'O' ) {
						count++;
					}
					//if a symbol is found at all places cats = true
					if(count == 9)
						catsGame = true;
					else
						catsGame = false;
				}
			}
			return catsGame;
	}
	
	public static void displayWelcome() {
		System.out.println("***********************");
		System.out.println("Welcome to Tic-Tac-Toe!");
		System.out.println("***********************\n");
	}

}



