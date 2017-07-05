package edu.seminolestate.managepurchases;
/*
 * Author:	Robert Kaye
 * Date:	6/24/2017
 * Purpose:	An exception class for handling invalid arguments
 */
public class InvalidArgumentException extends Exception {
	public InvalidArgumentException() {
		super("Invalid values sent to method");
	}
	public InvalidArgumentException(String message) {
		super(message);
	}
}
