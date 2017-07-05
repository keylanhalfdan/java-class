package edu.seminolestate.manageparts;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
/*
 * Author:	Robert Kaye
 * Date:	6/15/2017
 * Purpose:	An application class for managing purchased and manufactured parts
 */
public class ManageParts {
	// open instance of scanner to get input from keyboard
	static Scanner keyboard = new Scanner(System.in);
	// code taken from canvas lesson on displaying data in dollars and cents
	static NumberFormat nfCurrencyFormat = NumberFormat.getCurrencyInstance();
	// main method
	public static void main(String[] args) {
		// create a new ArrayList called parts to store purchased and manufactured parts
		ArrayList<Part> parts = new ArrayList<>();
	
		// declare variables
		int partID = 0;
		String description = "";
		double sellPrice = 0.0;
		double purchasePrice = 0.0;
		double handlingCost = 0.0;
		String vendor = "";
		double laborCost = 0;
		double materialCost = 0;
		NumberFormat nfCurrencyFormat = NumberFormat.getCurrencyInstance();
		int response = 0;
		int result = 0;
	
		// loop to display the menu over and over again
		do {
			// called the getUserChoice method to find out which option was chosen (1-5)
			response = getUserChoice();
			// switch statement to chose different cases depending on which option was chosen above
			switch (response) {
			// this code runs when option 1 is chosen
			case 1:
				// loop to run for entering the part ID
				do {
					// displays text to user to ask for part ID 
					System.out.println("Enter a part number");
					partID = keyboard.nextInt();
					keyboard.nextLine(); // clears the input for the String coming up next
					// checks the result to make sure that the part ID is not already in the ArrayList
					result = searchPart(parts, partID);
					// displays message if the part ID already exists, then jumps back into loop to display "Enter a part number" again
					if (result >= 0){
						System.out.println("That ID is already used");
					}
					else { 
						// displays message id the user enters a part ID that is less than or equal to 0
						// (the instructions said the partID could be greater than or equal to 0
						// but I don't feel a part ID should be 0)
						if (partID < 1) {
							System.out.println("The part number must be greater than 0");
						}
					}
				}
				// ends the loop if the result (new part ID) is greater than or equal to 0 and the part ID is not in the ArrayList already  
				while (result >= 0 || partID < 1);
				// asks the user for input data and stores it to appropriate variables
				System.out.println("Enter a description");
				description = keyboard.nextLine();
				System.out.println("Enter a sell price");
				sellPrice = keyboard.nextDouble();
				System.out.println("Enter a purchase price");
				purchasePrice = keyboard.nextDouble();
				System.out.println("Enter the handling cost");
				handlingCost = keyboard.nextDouble();
				keyboard.nextLine();
				System.out.println("Enter the vendor name");
				vendor = keyboard.nextLine();

				// creates new PurchasedPart object with the above info
				PurchasedPart newPPart = new PurchasedPart(partID, description, sellPrice, purchasePrice, handlingCost, vendor);
				
				// adds the PurchasedPart object above to the ArrayList
				parts.add(newPPart);

				// breaks back to the main menu
				break;
			// this code runs when option 2 is chosen
			case 2:
				// loop to run for entering the part ID
				do {
					// displays text to user to ask for part ID
					System.out.println("Enter a part number");
					partID = keyboard.nextInt();
					keyboard.nextLine();// clears the input for the String coming up next
					// checks the result to make sure that the part ID is not already in the ArrayList
					result = searchPart(parts, partID);
					// displays message if the part ID already exists, then jumps back into loop to display "Enter a part number" again
					if (result >= 0){
						System.out.println("That ID is already used");
					}
					else { 
						// displays message id the user enters a part ID that is less than or equal to 0
						// (the instructions said the partID could be greater than or equal to 0
						// but I don't feel a part ID should be 0)
						if (partID < 1) {
							System.out.println("The part number must be greater than 0");
						}
					}
				}
				// ends the loop if the result (new part ID) is greater than or equal to 0 and the part ID is not in the ArrayList already  
				while (result >= 0 || partID < 1);
				// asks the user for input data and stores it to appropriate variables
				System.out.println("Enter a description");
				description = keyboard.nextLine();
				System.out.println("Enter a sell price");
				sellPrice = keyboard.nextDouble();
				System.out.println("Enter a labor cost");
				laborCost = keyboard.nextDouble();
				System.out.println("Enter the material cost");
				materialCost = keyboard.nextDouble();
				keyboard.nextLine();
				 
				//creates new ManufacturedPart object with the above info
				ManufacturedPart newMPart = new ManufacturedPart(partID, description, sellPrice, laborCost, materialCost);
				// adds the ManufacturedPart object above to the ArrayList
				parts.add(newMPart);
				// breaks back to the main menu
				break;
			// this code runs when option 3 is chosen
			case 3:
				// asks user for a part ID to search in the ArrayList
				System.out.println("Enter a part ID");
				int searchID = keyboard.nextInt();
				keyboard.nextLine();
				// checks the result to make sure that the part ID is not already in the ArrayList
				result = searchPart(parts, searchID);
				// if resulting index is greater than 1, displays the toString for the data on one line then the part cost on the next line
				if (result >=0) {
					System.out.println(parts.get(result).toString()); // .toString() can be left off, as println defaults to this
					System.out.println("Part cost: " + nfCurrencyFormat.format(((Part) parts.get(result)).getTotalCost()));
				}
				// if resulting index is -1, item was not found in ArrayList, display part ID not found
				else {
					System.out.println(searchID + " was not found");
				}
				// breaks back to the main menu			
				break;
			// this code runs when option 4 is chosen
			case 4:
				// checks to see if the ArrayList is empty, if so, displays the message below, otherwise continues to for loop
				if (parts.isEmpty()) {
					System.out.println("There are no parts to list");
				}
				// loop to display the toString data for each item in the ArrayList, followed by its part cost on the next line for every item in the ArrayList
				for (int idx = 0; idx < parts.size(); idx++) {
					System.out.println(parts.get(idx).toString()); // .toString() can be left off, as println defaults to this
					// prints out part cost by calculating it in getTotalCost() method and formatting to dollars and cents
					System.out.println("Part cost: " + nfCurrencyFormat.format(parts.get(idx).getTotalCost()));
				}
				// breaks back to the main menu
				break;
			// // this code runs when option 5 is chosen
			case 5:
				System.out.println("Thanks for using the parts manager!");
				// breaks back to the main menu, this one actually ends the program because response is 5, causing the loop to terminate
				break;
			// displays when the user picks something other than the cases above (options 1-5)
			default:
				System.out.println("Invalid value. Enter a value 1-5");
				// breaks back to the main menu
				break;
			}
		}
		// ends loop when option 5 is chosen
		while (response != 5);
	}
	
	// method to get the users choice (modified from the hangman application from Prof. Grant)
	public static int getUserChoice() {
		System.out.println("Enter your choice:");
		System.out.println("1. Create Purchased Part");
		System.out.println("2. Create Manufactured Part");
		System.out.println("3. List a part");
		System.out.println("4. List all parts");
		System.out.println("5. Exit");
		return Integer.parseInt(keyboard.nextLine());
	}
	
	// method to search the array for a part ID (used to determine if the part ID is already in the ArrayList (in option 1 or 2)
	// and also in option 3 to search for a part) returns the index of the searched item if found
	public static int searchPart(ArrayList<Part> parts, int searchID) {
		for (int idx = 0; idx < parts.size(); idx++) {
			if (searchID == ((Part) parts.get(idx)).getPartID()){
				return idx;
			}
		}
		return -1;
	}
}
