package edu.seminolestate.payments;
/*
* AUTHOR:	R Kaye
* DATE:	6/30/2017
* This is an application class to manage different types of Payable objects.
*/
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import edu.seminolestate.employees.*;
import edu.seminolestate.payable.*;
import edu.seminolestate.bill.*;
import edu.seminolestate.exceptions.*;
import edu.seminolestate.payments.*;
import java.text.NumberFormat;

public class ManagePayablesApplication {
	// declaring ArrayList type, initiating scanner for keyboard input, and declaring static variables
	private static ArrayList<Payable> employees;
	private static Scanner keyboard = new Scanner(System.in);
	private static final int ADD_HOURLY_EMPLOYEE = 1;
	private static final int ADD_MANAGER = 2;
	private static final int ADD_SALES_MANAGER = 3;
	private static final int ADD_BILL = 4;
	private static final int LIST_ALL_PAYABLES = 5;
	private static final int EXIT = 6;
	private static String firstName, lastName, vendorName = null;
	private static int iD = 0;
	private static double hoursWorked, payRate, annualSalary, salesAmount, commissionRate, amountOwed = 0;
	private static LocalDate dueDate = null; 
	// main method
	public static void main(String[] args) {
		// create a new ArrayList with object type of Payable called employees
		employees = new ArrayList<Payable>();
		// declare integer called response for menu
		int response = 0;
		// start of do loop
		do {
			// calls the menu method to get the response from the user
			response = menu();
			// switch to do code based on user's choice
			switch (response){
			// this will execute if the user chooses option 1
			case ADD_HOURLY_EMPLOYEE:
				// try the following code
				try {
					// calls the appropriate methods to get input from the user 
					firstName = getString("Enter the first name.");
					lastName = getString("Enter the last name.");
					iD = getInt("Enter the ID number.");
					hoursWorked = getDouble("Enter the hours worked.");
					payRate = getDouble("Enter the pay rate.");
					// creates new HourlyEmployee object using the above data
					Employee employee = new HourlyEmployee(firstName, lastName, iD, hoursWorked, payRate);
					// adds above object to ArrayList
					employees.add(employee);
				} // end of try
				// catches errors to throw InvalidArgumentException
				catch (InvalidArgumentException e) {
					System.out.println("You entered invalid Hourly Employee data");
				} // end of catch	
				break;
			// this will execute if the user chooses option 2
			case ADD_MANAGER:
				// try the following code
				try {
					// calls the appropriate methods to get input from the user 
					firstName = getString("Enter the first name.");
					lastName = getString("Enter the last name.");
					iD = getInt("Enter the ID number.");
					annualSalary = getDouble("Enter the annual salary.");
					// creates new Manager object using the above data
					Employee employee = new Manager(firstName, lastName, iD, annualSalary);
					// adds above object to ArrayList
					employees.add(employee);
				} // end of try
				// catches errors to throw InvalidArgumentException
				catch (InvalidArgumentException e) {
					System.out.println("You entered invalid Manager data");
				} // end of catch
				break;
			// this will execute if the user chooses option 3
			case ADD_SALES_MANAGER:
				// try the following code
				try {
					// calls the appropriate methods to get input from the user 
					firstName = getString("Enter the first name.");
					lastName = getString("Enter the last name.");
					iD = getInt("Enter the ID number.");
					annualSalary = getDouble("Enter the annual salary.");
					salesAmount = getDouble("Enter the sales amount.");
					commissionRate= getRate("Enter the commission rate (ex 0.05).");
					// creates new SalesManager object using the above data
					Employee employee = new SalesManager(firstName, lastName, iD, annualSalary, salesAmount, commissionRate);
					// adds above object to ArrayList
					employees.add(employee);
				} // end of try
				// catches errors to throw InvalidArgumentException
				catch (InvalidArgumentException e) {
					System.out.println("You entered invalid Sales Manager data");
				} // end of catch
				break;
			// this will execute if the user chooses option 4
			case ADD_BILL:
				// try the following code
				try {
					// calls the appropriate methods to get input from the user 
					dueDate = getDate("Enter a date (like 06/23/2016)");
					vendorName = getString("Enter the vendor name.");
					amountOwed = getDouble("Enter the bill amount.");
					// creates new Bill object using the above data
					Bill bill = new Bill(vendorName, amountOwed, dueDate);
					// adds above object to ArrayList 
					employees.add(bill);		
				} // end of try
				// catches errors to throw InvalidArgumentException
				catch (InvalidArgumentException e) {
					System.out.println("You entered invalid Bill data");
				} // end of catch
				break;
			// this will execute if the user chooses option 5
			case LIST_ALL_PAYABLES:
				// check to see if the employees ArrayList if empty.  If so, display the following
				if (employees.isEmpty()){
					System.out.println("There is no data yet, please enter employees or bills");
				} // end of if
				// Otherwise, display all info in ArrayList
				else {
					// formats data as currency with 2 decimal places
					NumberFormat currFormatter = NumberFormat.getCurrencyInstance();
					// displays all data from employees ArrayList and adds amount to pay on following line
					for (Payable e : employees){
						System.out.println(e + "\nThe amount to pay is "
							+ currFormatter.format(e.computeAmountToPay()));
					} // end of for
				} // end of else
				break;
			// this will execute if the user chooses option 6
			case EXIT:
				System.out.println("Thanks for using the employee manager.");
			} // end of switch
		// do the code inside loop as long as response from user does not equal 6 (EXIT)
		} while (response != EXIT);	
	} // end of main method
	
	// menu method for displaying menu to the user
	public static int menu(){
		// declare variables needed for this method
		int userResponse = 0;
		String userInput = null;
		// do loop for the menu
		do {
			// display the menu to the user
			System.out.println("Enter your choice: ");
			System.out.println(ADD_HOURLY_EMPLOYEE + ". Add hourly employee");
			System.out.println(ADD_MANAGER + ". Add manager");
			System.out.println(ADD_SALES_MANAGER + ". Add sales manager");
			System.out.println(ADD_BILL + ". Add bill");
			System.out.println(LIST_ALL_PAYABLES + ". List all payables");
			System.out.println(EXIT + ". Exit");
			// read the line of data that the user inputs and store in userInput
			userInput = keyboard.nextLine();
			// try the following code
			try{
				// parse the userInput String to an integer
				userResponse = Integer.parseInt(userInput);
				// check to see is the userResponse data is not valid (less than 1 of greater than 6)
				if (userResponse < ADD_HOURLY_EMPLOYEE || userResponse > EXIT){
					// display invalid value info
					System.out.println("Invalid value. Enter a value " + ADD_HOURLY_EMPLOYEE + " - " + EXIT);
				} // end of if
			} // end of try
			// catch if the value entered from the user is not a number
			catch (NumberFormatException e) {
				// display the following
				System.out.println("Enter numeric values for menu choice");
				// set the userResponse to -1 to stay in do loop
				userResponse = -1;  
			} // end of catch
		// stay in the loop until the userResponse is between 1 and 6
		} while (userResponse < ADD_HOURLY_EMPLOYEE || userResponse > EXIT);
		// return the userResponse
		return userResponse;
	} // end of menu method
	
	// getString method to get string input from the user (firstName, lastName, vendorName)
	public static  String getString(String prompt){
		// declare variables needed for this method
		String userValue = null;
		// do loop to get String input
		do {
			// display needed data to the user
			System.out.println(prompt);
			// store next line of data from user into userValue
			userValue = keyboard.nextLine();
			// if invalid data is entered do the following
			if (userValue == null || userValue.length() < 1){
				System.out.println("You must enter a value.");
			} // end of if
		// stay in loop until data is valid	
		} while (userValue == null || userValue.length() < 1);
		// return the userValue
		return userValue;
	} // end of getString method
	
	// getDouble method to get double input from the user (hoursWorked, payRate, annualSalary, salesAmount, commissionRate, amountOwed)
	public static double getDouble(String prompt){
		// declare variables needed for this method
		String userValue = null;
		double validDouble = 0;
		boolean isValidDouble = false;
		// do loop for parsing a valid double from a String
		do {
			// display info needed from user
			System.out.println(prompt);
			// try the following code to get a valid double
			try{
				// store next line of data from user into userValue
				userValue = keyboard.nextLine();
				// parse double from the userValue
				validDouble = Double.parseDouble(userValue);
				// if to determine if the double value is valid (greater than 0)
				if (validDouble > 0) {
					// set isValidDouble to true
					isValidDouble = true;
				} // end of if
				// if not, display message asking for new info
				else {
					System.out.println("Data must be > 0.");
				} // end of else
			} // end of try
			// catch for NumberFormatException if the user enters non numeric values
			catch (NumberFormatException e) {
				System.out.println("Enter only decimal numbers");
			} // end of catch
		// do the above loop until the isValidDouble value is true
		} while (! isValidDouble);
		// return the validDouble info
		return validDouble;
	} // end of getDouble method

	// getDouble method to get double input from the user (same as getDouble but new parameter to keep input between 0 and 1 (commissionRate)
	public static double getRate(String prompt){
		// declare variables needed for this method
		String userValue = null;
		double validDouble = 0;
		boolean isValidDouble = false;
		// do loop for getting a valid rate
		do {
			// display info needed from user
			System.out.println(prompt);
			// try to do the following code to get a rate between 0 and 1
			try{
				// store next line of data from user into userValue
				userValue = keyboard.nextLine();
				// parse double from the userValue
				validDouble = Double.parseDouble(userValue);
				// if to determine if the double value is valid (greater than or equal to 0)
				if (validDouble >= 0 && validDouble <= 1) {
					// set isValidDouble to true
					isValidDouble = true;
				} // end of if
				// if not, display message asking for new info
				else {
					System.out.println("Rate must be between 0 and 1.");
				} // end of else
			} // end of try
			// catch for NumberFormatException if the user enters non numeric values
			catch (NumberFormatException e) {
				System.out.println("Enter only decimal numbers");
			} // end of catch
		// do the above loop until the isValidDouble value is true
		} while (! isValidDouble);
		// return the validDouble info
		return validDouble;
	} // end of getRate method

	// getDouble method to get integer input from the user (iD)
	public static int getInt(String prompt){
		// declare variables needed for this method
		String userValue = null;
		int validInt = 0;
		boolean isValidInt = false;
		// do loop for getting a valid integer greater than 0
		do {
			// display the info needed from user
			System.out.println(prompt);
			// try the following code to get an integer greater than 0
			try{
				// store next line of data from user into userValue
				userValue = keyboard.nextLine();
				// parse integer from the userValue
				validInt = Integer.parseInt(userValue);
				// if to determine if the integer value is valid (greater than 0)
				if (validInt > 0) {
					// set isValidInt to true
					isValidInt = true;
				} // end of if
				// if not, display message asking for new info
				else {
					System.out.println("Employee ID must be > 0.");
				} // end of else
			} // end of try
			// catch for NumberFormatException if the user enters non numeric values
			catch (NumberFormatException e) {
				System.out.println("Enter only whole numbers");
			} // end of catch
		// do the above loop until the isValidInt value is true
		} while (! isValidInt);
		// return the validInt info
		return validInt;
	} // end of getInt method

	// method to get a valid LocalDate from the user
	public static LocalDate getDate(String prompt) throws DateTimeParseException{
		// declare variables needed for this method
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
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
} // end of class
