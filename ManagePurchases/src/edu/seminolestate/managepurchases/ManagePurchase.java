package edu.seminolestate.managepurchases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Author:	Robert Kaye
 * Date:	6/24/2017
 * Purpose:	An application class for managing purchases
 */
public class ManagePurchase{

	// declare variables
	static final String FILE = "purchases.txt";
	static Scanner keyboard = new Scanner(System.in);
	static File file = new File(FILE);
	static int response = 0;
	static String productName = null;
	static String storeName = null;
	static LocalDate purchaseDate = null;
	static double cost = 0;
	static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
	static boolean inputIsNotValid = true;
	
	// main method
	public static void main(String[] args) throws InvalidArgumentException, FileNotFoundException {
		
		// initiate ArrayList named purchases
		ArrayList<Purchase> purchases = new ArrayList<>();

		// try with resources for file read
		try (Scanner input = new Scanner(file);) {
			// if file exists, read data from file into purchases ArrayList
			if (file.exists()) {
				// read from file until End Of File is reached
				while (input.hasNext()) {
					// read line by line and put into variables for array building
					/* The instructions say to to read and write in the following order:
					 * productName, storeName, purchaseDate, cost
					 * but the example video Prof. Grant did had it in the following order:
					 * storeName, productName, purchaseDate, cost
					 * storeName and productName are switched in the purchases.txt file. I went with the way that matched the video
					 */
					storeName = input.nextLine();
					productName = input.nextLine();
					String tempDate = input.nextLine();
					purchaseDate = LocalDate.parse(tempDate, dateFormatter);
					String tempCost = input.nextLine();
					cost = Double.parseDouble(tempCost);
					// create newPurchase object
					Purchase newPurchase = new Purchase(productName, storeName, purchaseDate, cost);
					// add newPurchase object to purchases ArrayList
					purchases.add(newPurchase);
				} // end while loop
			} // end if
		} // end try
		// catch for FileNotFound
		catch (FileNotFoundException e) {
		}
		// do loop, to do the following while the user doesn't choose option 3
		do {
			// call the getUserChoice method to display menu and get the user's choice
			response = getUserChoice();
			// switch to do code based on response from user's choice
			switch (response) {
			// this will execute if user chooses option 1
			case 1:
				// uses the getString, getDate and getDouble methods to get info for the variables from the user
				productName = getString("Enter the product name");
				storeName = getString("Enter the store name");
				purchaseDate = getDate("Enter a date (like 6/23/2016)");
				cost = getDouble("Enter the cost (like 1.99)");
				// creates a Purchase object called newPurchase using the above data collected from the user 
				Purchase newPurchase = new Purchase(productName, storeName, purchaseDate, cost);
				// adds the newPurchase object to the purchases ArrayList
				purchases.add(newPurchase);
				break;
			// this will execute if user chooses option 2					
			case 2:
				// checks to see if the purchases ArrayList is empty.  if so, displays "There are no purchases"
				if (purchases.isEmpty()){
					System.out.println("There are no purchases");
				} // end if
				// if there is data in the purchases ArrayList, display all contents using toString method
				else {
					for (int idx = 0; idx < purchases.size(); idx++) {
						System.out.println(purchases.get(idx).toString());
					} // end for
				} // end else
				break;
			// this will execute if user chooses option 3
			case 3:
				// displays "thank you for using the Purchase Tracker
				System.out.println("Thank you for using the Purchase Tracker");
				// close input from keyboard
				keyboard.close();
				// checks to see if the purchases ArrayList is empty, if so, do nothing
				if (purchases.isEmpty()){
				} // end if
				// if the purchases ArrayList has data in it, do the following
				else {
					// write to file using try with resources
					try (PrintWriter output = new PrintWriter(file);) {
						for (int idx = 0; idx < purchases.size(); idx++) {
							output.println(purchases.get(idx).getStoreName());
							output.println(purchases.get(idx).getProductName());
							output.println(purchases.get(idx).getPurchaseDate().format(dateFormatter));
							output.println(purchases.get(idx).getCost());
						} // end for
					} // end try
				} // end else
				break;
			} // End of Switch
		} // End of do
		while (response != 3);
	} // end main

	// method to display menu and get user's choice
	public static int getUserChoice() {
		// do as long as user inputs data that is not 1 - 3
		do {
			// display menu options
			System.out.println("Enter your choice:");
			System.out.println("1. Add a purchase");
			System.out.println("2. List purchases");
			System.out.println("3. Exit");
			// read next line of input and try to parse it to an integer
			try {
				response = Integer.parseInt(keyboard.nextLine());
				// if user input is between 1 and 3, mark as valid
				if (response > 0 && response < 4) {
					inputIsNotValid = false;
				} // end if
				// if user input is a number not between 1 and 3
				else {
					System.out.println("Invalid value. Enter a value 1 - 3");
				} // end else
			} // end try
			// catches the exception if the user entered non numbers
			catch (NumberFormatException e) {
				System.out.println("Invalid value. Enter a value 1 - 3");
			} // end catch
		} // end do
		// ends the do loop if the input from user is valid (false for not valid)
		while (inputIsNotValid);
		// returns the response (between 1 and 3)
		return response;
	} // end getUserChoice method
	
	// method to get a positive double from the keyboard
	public static double getDouble(String prompt) {
		// variables for method
		String userValue = null;
		double validDbl = 0;
		boolean isValidDbl = false;
		// do the following, repeats until the user inputs a valid double
		do {
			// displays the string is passed to the method
			System.out.println(prompt);
			// try to parse the next line of input to a double
			try {
				userValue = keyboard.nextLine();
				validDbl = Double.parseDouble(userValue);
				// if the double is greater than or equal to 0, change isValidDbl to true
				if (validDbl >= 0) {
					isValidDbl = true;
				} // end if
				// if double is not greater than or equal to 0, display message
				else {
					System.out.println("Cost must be >= 0");
				} // end else
			} // end try
			// catch for when user input is not able to be parsed into a double
			catch (NumberFormatException e) {
				// displays message asking for decimal numbers
				System.out.println("Enter only decimal numbers");
			} // end catch
		} // end do
		// ends the do loop if the input from user is valid (true for valid)
		while (! isValidDbl);
		// returns double value which is valid
		return validDbl;
	} // end getDouble method
	
	//method to get a valid String from a user
	public static String getString(String prompt){
		// variables for method
		String userValue = null;
		boolean isValid = false;
		// do the following, repeats until the user enters a valid String
		do {
			// displays the string is passed to the method
			System.out.println(prompt);
			// takes the next line of input and stores it in the userValue String
			userValue  = keyboard.nextLine();
			// if userValue is not null and as a length greater than 0, set isValid to true
			if (userValue != null && userValue.length() > 0){
				isValid = true;}
			// else tell the user to input a value
			else
				System.out.println("You must enter a value");
		} // end
		// repeats loop until the user input is a valid String
		while (! isValid);
		// returns the valid String
		return userValue;
	} // end getString method
	
	// method to get a valid LocalDate from the user
	public static LocalDate getDate(String prompt) throws DateTimeParseException{
		// variables for method
		String userValue = null;
		LocalDate validDate = null;
		boolean isValid = false;
		// do the following, repeats until the user enters a valid date
		do {
			// displays the string is passed to the method
			System.out.println(prompt);
			// takes the next line of input and stores it in the userValue String
			userValue = keyboard.nextLine();
			// try to parse the userValue String to a LocalDate variable
			try {
				// parse the userValue into a LocalDate variable using the dateFormatter, changes isValid to true if a valid date in entered
				validDate = LocalDate.parse(userValue, dateFormatter);
				isValid = true;
			} // end try
			// catches if a non valid date it entered
			catch (DateTimeParseException e) {
				// display the following if an invalid date is entered
				System.out.println("You entered an invalid date");
			} // end
		} // end
		// repeats the loop until the user input is a valid LocalDate
		while (! isValid);
		// returns the valid LocalDate
		return validDate;
	} // end getDate method
} // end ManagePurchase Class
