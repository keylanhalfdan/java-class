package edu.seminolestate.hangman;
import java.util.Scanner;
/*
 * Author:	Robert Kaye
 * Date:	6/3/2017
 * Purpose:	An application class to play a hangman game
 */
public class HangmanApplication {

	public static void main(String[] args) {
		// initialize Scanner for future user input
		Scanner keyboard = new Scanner(System.in);
		// create new instance of the hangman game
		Hangman game = new Hangman();
		// do the following code forever, until told to stop
		do {
			// displays the mysteryWordWithDashes variable as well as the menu
			System.out.println("Mystery word: " + game.getMysteryWordWithDashes()
				+ "\nChoose an option."
				+ "\n1. Guess a letter"
				+ "\n2. Guess the word"
				+ "\n3. Quit");
			// takes the next line of input, and truncates it to the first character (this is useful for avoiding the nextInt() followed by nextLine() error)
			char choice = keyboard.nextLine().charAt(0);
				// if the user chose option 1, runs Enter a letter code
				if (choice == '1') {
					System.out.println("Enter a letter:");
					// takes the next line of input from the user, converts it to lower case (to take either capital or lower case letters, R = r) and truncates to 1 character
					char guessedLetter = keyboard.nextLine().toLowerCase().charAt(0);
					// calls the isCorrectLetter method from this game instance to check the letter against the mysteryWord variable
					if (game.isCorrectLetter(guessedLetter)) {
						// calls the isWinner method from this game instance to check to see if all the letters have been guessed
						if (game.isWinner()){
							// displays winning message
							System.out.println("You Win!!");
							// starts new game with new mysteryWord
							game = new Hangman();
						}
						// displays the letter found info, number of guesses left, and the incorrectly guessed letters
						else {
							System.out.println("That letter is in the word"
								+ "\nYou have " + game.getNumberOfGuessesLeft() + " guess(es) left");
							System.out.println("Letters used: " + game.getIncorrectLetters());
						}
					}
					// options for when the letter guessed is not in the mysteryWord variable
					else {
						// if there are still guesses left, displays letter not found info, number of guesses left, and the incorrectly guessed letters
						if (game.getNumberOfGuessesLeft() > 0) {
							System.out.println("\nSorry, that letter is not in the word."
							+ "\nYou have " + game.getNumberOfGuessesLeft() + " guess(es) left");
							System.out.println("Letters used: " + game.getIncorrectLetters());
						}
						// this is displayed if the number of guesses left is 0 and the user loses, starts new game
						else {
							System.out.println("You lose! The word was " + game.getMysteryWord());
							game = new Hangman();
						}
					}
				}
				// if the user chose option 2 from the menu, runs Enter the word code
				else if (choice == '2') {
					System.out.println("Enter the word:");
					// converts the guessed word to lower case for easy matching (TINDER or tinDER = tinder)
					String guessedWord = keyboard.nextLine().toLowerCase();
					// calls the isCorrectWord method to check to see if the guessed word is correct, if true, runs the "you win" dialog and starts a new game
					if (game.isCorrectWord(guessedWord)) {
						System.out.println("You win!!");
						game = new Hangman();
					}
					// if isCorrectWord is false
					else { 
						// if there are still guesses left, displays the word not correct dialog, and number of guesses left
						if (game.getNumberOfGuessesLeft() > 0) {
							System.out.println("\nSorry, that is not the word."
							+ "\nYou have " + game.getNumberOfGuessesLeft() + " guess(es) left");
						}
						// this is displayed if the number of guesses left is 0 and the user loses, starts new game
						else {
							System.out.println("You lose! The word was " + game.getMysteryWord());
							game = new Hangman();
						}
					}	 
				}
				// if the user chose option 3 from the menu, runs the Quit game code
				else if (choice == '3') {
					System.out.println("Thank you for playing Hangman!");
					// closes Scanner
					keyboard.close();
					// exits program
					System.exit(0);
				}
				// This is displayed if the user enters anything other than 1, 2 or 3 in the menu (i.e. negative number, number greater than 3, or a character)
				else {
					System.out.println("Please try again, choose an option between 1 and 3");
				}
		}
		// this makes the do loop run forever until the user quits (option 3, which runs the System.exit(0); code)
		while (true);
	}
}