package edu.seminolestate.bill;
/*
* AUTHOR:	R Kaye
* DATE:	6/30/2017
* This is a service class to handle Payable objects of the Bill type.
*/
import java.time.DateTimeException;
import java.time.LocalDate;
import edu.seminolestate.exceptions.InvalidArgumentException;
import edu.seminolestate.payable.*;

public class Bill implements Payable {
	// declare variables needed for class
	private String vendorName = null;
	private double amountOwed = 0;
	private LocalDate dueDate = null;
	
	// constructor to create a new bill object , throws InvalidArgumentExeption
	public Bill(String vendor, double amount, LocalDate dueDate) throws InvalidArgumentException {
		// set the other variables needed for the Bill object
		this.setVendorName(vendor);
		this.setAmountOwed(amount);
		this.setDueDate(dueDate);
	} // end of Bill constructor
	
	// override method to computeAmountToPay (because this implements the Payable interface
	@Override
	public double computeAmountToPay() {
		// return the amountOwed
		return amountOwed;
	}// end of computeAmountToPay method
	
	// method to display toString info for variables in the Bill class
	public String toString() {
		// returns the class name followed by all variable names and their data in the Bill class
		return "Bill [dueDate=" + dueDate + ", vendorName=" + vendorName + ", amountOwed=" + amountOwed + "]";
	} // end of toString method

	// method to get the vendorName
	public String getVendorName() {
		// returns the vendorName
		return vendorName;
	} // end of getVendorName method

	// method to set the vendorName, throws InvalidArgumentException
	public void setVendorName(String newName) throws InvalidArgumentException {
		// checks to see if the newName is either null of the length is less than 1
		if (newName == null || newName.length() < 1)
			// throws exception and displays message
			throw new InvalidArgumentException("Vendor name cannot be null or empty.");
		// if newName is valid, set vendorName to this value
		else
			this.vendorName = newName;
	} // end setVendorName method

	//  method to get the amountOwed
	public double getAmountOwed() {
		// return the amountOwed
		return amountOwed;
	} // end of getAmountOwed method

	// method to set amountOwed, throw InvalidArgumentException
	public void setAmountOwed(double newAmount) throws InvalidArgumentException{
		// checks if the newAmount is greater than 0
		if (newAmount > 0)
			this.amountOwed = newAmount;
		// throws exception and displays message
		else
			throw new InvalidArgumentException("Amount owed must be greater than 0");
	} // end of setAmountOwed method

	// method to get dueDate
	public LocalDate getDueDate() {
		// returns dueDate
		return dueDate;
	} // end of getDueDate method
	
	// method to setDueDate, throws DateTimeException
	public void setDueDate(LocalDate newDueDate) throws DateTimeException{
		// checks to see if dueDate is not null
		if (newDueDate != null)
			this.dueDate = newDueDate;
		// throws exception and displays message
		else 
			throw new DateTimeException("Invalid date");
	} // end of setDueDate method

	// overloaded method to setDueDate, throws DateTimeException
	public void setDueDate(int newYear, int newMonth, int newDay) throws DateTimeException {
		// checks to see if the year, month and date are greater than 0
		if (newYear > 0 && newMonth > 0 && newDay > 0)
			this.dueDate = LocalDate.of(newYear, newMonth, newDay);
		// throws exception and displays message
		else
			throw new DateTimeException("Invalid date");
	} // end of setDueDate method
} // end of Bill class
