package edu.seminolestate.employees;
/*
* AUTHOR:	R Kaye
* DATE:	6/30/2017
* This is a service class to handle Payable objects of the SalesManager type.
*/	
import edu.seminolestate.exceptions.*;
import edu.seminolestate.payable.*;

public class SalesManager extends Manager implements Payable {
	// declare variables needed for class
	private double salesAmount;
	private double commissionRate;

	// constructor for creating a new Sales Manager object
	public SalesManager(String newFName, String newLName, int newId, double salary, double sales, double rate) throws InvalidArgumentException {
		// call the super classes constructor to set the newFName, newLName, and newId
		super(newFName, newLName, newId, salary);
		// set the other variables needed for the Manager object
		this.setSalesAmount(sales);
		this.setCommissionRate(rate);
	} // end of SalesManager constructor

	// override for the computeAmountToPay method
	@Override
	public double computeAmountToPay() {
		// return the amount to pay a sales manager employee per month:
		//(annual salary divided by 12 months + amount of sales multiplied by the commission rate)
		return super.computeAmountToPay() + (salesAmount * commissionRate); 
	} // end of computeAmoutToPay method

	// override for the toString method
	@Override
	public String toString() {
		// call the super classes toString method and concatenate SalesManager variables on the end
		return super.toString() + "SalesManager [commissionRate=" + commissionRate + ", salesAmount=" + salesAmount + "]";
	} // end of toString method

	// method to get the salesAmount
	public double getSalesAmount() {
		return salesAmount;
	} // end of getSalesAmount method

	// method to set the salesAmount, throws InvalidArgumentException
	public void setSalesAmount(double newSales) throws InvalidArgumentException {
		// checks if newSales is a valid number (greater than 0)
		if (newSales > 0)
			// if so, set salesAmount to this value
			this.salesAmount = newSales;
		// if not, throw InvalidArgumentException with message
		else
			throw new InvalidArgumentException("Sales amount must be > 0");
	} // end of setSalesAmount method

	// method to get the commissionRate
	public double getCommissionRate() {
		return commissionRate;
	} // end of getCommissionRate method
	
	/* method to set the commissionRate, throws InvalidArgumentException (the UML diagram listed the info as newRateL,
	 * not sure why the L at the end, but I made it match the UML diagram*/
	public void setCommissionRate(double newRateL) throws InvalidArgumentException {
		// checks if the newRateL is a valid entry (greater than or equal to 0 and less than or equal to 1)
		if (newRateL >= 0 && newRateL <= 1)
			// if so, set commissionRate to this value
			this.commissionRate = newRateL;
		// if not, throw InvalidArgumentException with message
		else
			throw new InvalidArgumentException("Commission rate must be between 0 and 1");
	} // end of setCommissionRate method
} // end of SalesManager class