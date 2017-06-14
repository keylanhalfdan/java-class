package edu.seminolestate.hangman;
/*
 * Author:	Robert Kaye
 * Date:	6/3/2017
 * Purpose:	A service class to run a hangman game
 */
public class Hangman {

	// declaring variables
	public static final int NUMBER_WRONG_GUESSES_ALLOWED = 7;
	private static String[] dictionary = {"trouble", "copyright", "problem", "form", "mythical", "discover", "consume",
		"document", "flame", "flow", "chart", "magnetic", "working",
		"predict", "subordinate", "making", "copy", "troublemaking",
		"uncopyrighted", "unmaledictory", "unpredictably"};
	private String mysteryWord;
	private StringBuilder mysteryWordWithDashes = new StringBuilder();
	private int numberOfIncorrectGuesses;
	private int numberOfCorrectGuesses; // This was put into the code because of the UML and the instructions, but I did not need to implement it for the game to work
	private char[] incorrectLettersGuessed = new char[7];

	/* Main game constructor, resets numberOfIncorrect and numberOfCorrectGuesses to 0,
	 * as well as new mysteryWord and mysteryWordWithDashes for initial run and new games
	 */
	public Hangman() {
		numberOfIncorrectGuesses = 0;
		numberOfCorrectGuesses = 0;
		mysteryWord = setNewMysteryWord();
		mysteryWordWithDashes = setNewMysteryWordWithDashes();
	}

	// method to populate character array with incorrect letters guessed
	public String getIncorrectLetters() {
		String output = new String(incorrectLettersGuessed);
		return output;
	}

	// method to randomly choose new mystery word
	public String setNewMysteryWord() {
		int random = (int) (Math.random() * dictionary.length);
		mysteryWord = dictionary[random];
		return mysteryWord;
	}
	
	// method used to get mysteryWord variable from another class
	public String getMysteryWord() {
		return mysteryWord;
	}

	// method used to figure out how many guesses are left
	public int getNumberOfGuessesLeft() {
		return NUMBER_WRONG_GUESSES_ALLOWED - numberOfIncorrectGuesses;
	}

	// method to set mystery word with dashes to be "-" for the same length of mystery word
	public StringBuilder setNewMysteryWordWithDashes() {
		mysteryWordWithDashes.setLength(0);
		for (int i = 0; i < mysteryWord.length(); i++)
			mysteryWordWithDashes.append("-");
		return mysteryWordWithDashes;
	}
	
	// method to get mysteryWordWithDashes variable from another class
	public String getMysteryWordWithDashes() {
		return mysteryWordWithDashes.toString();
	}

	// method to check if the guessed letter is in the mystery word
	public boolean isCorrectLetter(char guessedLetter) {
		// checks the mysteryWord variable for guessedLetter from the user
		int location = mysteryWord.indexOf(guessedLetter);
		// converts guessedLetter from char to String
		String guessedLetterToString = Character.toString(guessedLetter);
		// if the guessedLetter is not in the mysteryWord variable, returns false, numberOfIncorrectGuesses increments
		if (location < 0) {
			incorrectLettersGuessed[numberOfIncorrectGuesses++] = guessedLetter;
			return false;
		}
		/* if the user has guessed a letter correctly, this increments numberOfCorrectGuesses
		 * also replaces the appropriate dash in mysteryWordWithDashes with the correct letter from mysteryWord 
		 */
		else {
			numberOfCorrectGuesses++;
			mysteryWordWithDashes.replace(location, location + 1, guessedLetterToString);
			return true;
		}
	}

	// method to check if the guessed word matches the mystery word
	public boolean isCorrectWord(String guessedWord) {
		// checks the guessedWord variable to the mysteryWord variable to see if it matches
		int location = mysteryWord.indexOf(guessedWord);
		// if the user has guessed the word incorrectly, returns false, numberOfIncorrectGuesses increments
		if (location < 0) {
			numberOfIncorrectGuesses++;
			return false;		
		}
		// if the user has guessed the word correctly, returns true
		else {
			return true;
		}	
	}

	// method to check if the user wins after guessing all of the letters 
	public boolean isWinner() {
		// checks if the mysteryWord matches the mysteryWordWithDashes variable
		int location = mysteryWord.indexOf(getMysteryWordWithDashes());
		// if the user has not guessed all of the letters, returns false for isWinner variable
		if (location < 0) {
			return false;		
		}
		// if the user has guessed all of the letters, returns true for isWinner variable
		else {
			return true;
		}	
	
	}
}