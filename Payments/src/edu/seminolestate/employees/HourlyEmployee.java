package edu.seminolestate.employees;
/*
* AUTHOR:	R Kaye
* DATE:	6/30/2017
* This is a service class to handle Payable objects of the HourlyEmployee type.
*/	
import edu.seminolestate.exceptions.*;
import edu.seminolestate.payable.*;

public class HourlyEmployee extends Employee implements Payable {
	// declare variables needed for class
	private double hoursWorked;
	private double payRate;
	
	// constructor for creating a new HourlyEmployee object
	public HourlyEmployee (String newFName, String newLName, int newId, double newHours, double newRate) throws InvalidArgumentException {
		// call the super classes constructor to set the newFName, newLName, and newId
		super(newFName, newLName, newId);
		// set the other variables needed for the HourlyEmployee object
		this.setHoursWorked(newHours);
		this.setPayRate(newRate);
	} // end of HourlyEmployee constructor
		
	// override for the computeAmountToPay method
	@Override
	public double computeAmountToPay() {
		// return the amount to pay an hourly employee (hours worked multiplied by the pay rate)
		return hoursWorked * payRate;
	} // end of computeAmountToPay method

	// override for the toString method
	@Override
	public String toString() {
		// call the super classes toString method and concatenate HourlyEmployee variables on the end 
		return super.toString() + "HourlyEmployee [hoursWorked=" + hoursWorked + ", payRate=" + payRate + "]";
	} // end of toString method
	
	// method to get the hoursWorked
	public double getHoursWorked() {
		return hoursWorked;
	} // end of getHoursWorked method
	
	// method to set the hoursWorked, throws InvalidArgumentException
	public void setHoursWorked(double newHours) throws InvalidArgumentException {
		// checks if newHours is a valid number (greater than 0)
		if (newHours > 0)
			// if newHours is valid, set hoursWorked to this value
			this.hoursWorked = newHours;
		// if not, throw InvalidArgumentException with message
		else
			throw new InvalidArgumentException("Hours worked must be > 0");
	} // end of setHoursWorked method
	
	// method to get the payRate
	public double getPayRate() {
		return payRate;
	} // end of getPayRate method
	
	// method to set the payRate
	public void setPayRate(double newRate) throws InvalidArgumentException {
		// checks if newRate is a valid number (greater than 0)
		if (newRate > 0)
			// if newRate is valid, set payRate to this value
			this.payRate = newRate;
		// if not, thrown InvalidArgumentException with message
		else
			throw new InvalidArgumentException("Pay rate must be > 0");
	} // end of setPayRate method
} // end of HourlyEmployee class
