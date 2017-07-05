package edu.seminolestate.employees;
/*
* AUTHOR:	R Kaye
* DATE:	6/30/2017
* This is a service class to handle Payable objects of the Manager type.
*/	
import edu.seminolestate.exceptions.*;
import edu.seminolestate.payable.*;

public class Manager extends Employee implements Payable {
	// declare variables needed for class
	private double annualSalary;

	// constructor for creating a new Manager object
	public Manager(String newFName, String newLName, int newId, double salary) throws InvalidArgumentException {
		// call the super classes constructor to set the newFName, newLName, and newId
		super(newFName, newLName, newId);
		// set the other variables needed for the Manager object
		this.setAnnualSalary(salary);
	} // end of Manager constructor

	// override for the computeAmountToPay method
	@Override
	public double computeAmountToPay() {
		// return the amount to pay a manager employee per month (annual salary divided by 12 months)
		return annualSalary / 12;
	} // end of computertoPay method

	// override for the toString method
	@Override
	public String toString() {
		// call the super classes toString method and concatenate Manager variables on the end
		return super.toString() + "Manager [annualSalary=" + annualSalary + "]";
	} // end of toString method

	//method to get the annualSalary
	public double getAnnualSalary() {
		return annualSalary;
	} // end of getAnnualSalary

	// method to set annualSalary
	public void setAnnualSalary(double newSalary) throws InvalidArgumentException {
		// checks if newSalary is a valid number (greater than 0)
		if (newSalary > 0)
			// if newSalary is valid, set annualSalary to this value
			this.annualSalary = newSalary;
		// if not, throw InvalidArgumentException with message
		else
			throw new InvalidArgumentException("Salary must be >= 0");
	} // end of setAnnualSalary method
} // end of Manager class
