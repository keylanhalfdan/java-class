package edu.seminolestate.employees;
/*
* AUTHOR:	R Kaye
* DATE:	6/30/2017
* This is a service class to handle Payable objects of the Employee type.
*/
import edu.seminolestate.exceptions.*;
import edu.seminolestate.payable.*;

public abstract class Employee implements Payable{
	// declare variables needed for class
	private String firstName = null;
	private String lastName = null;
	private int iD = 0;

	// constructor to create a new Employee object , throws InvalidArgumentExeption
	public Employee(String newFName, String newLName, int newId) throws InvalidArgumentException {
		// set the variables needed for the Employee object
		this.setFirstName(newFName);
		this.setLastName(newLName);
		this.setId(newId);
	} // end of constructor

	// method to display toString info for variables in the Employee class 
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", employeeID=" + iD + "]";
	} // end of toString method

	// method to get the firstName
	public String getFirstName() {
		return firstName;
	} // end of getFirstName

	// method to set the firstName
	public void setFirstName(String newFName) throws InvalidArgumentException {
		// check if the newFName is null or length is less than 1
		if (newFName == null || newFName.length() < 1)
			throw new InvalidArgumentException("First name cannot be null or empty.");
		// if newFName is valid, set firstName to this value
		else
			this.firstName = newFName;
	} // end of setFirstName method

	// method to get the lastName
	public String getLastName() {
		return lastName;
	} // end of getLastName method

	public void setLastName(String newLName) throws InvalidArgumentException {
		// check if the newLName is null or length is less than 1
		if (newLName == null || newLName.length() < 1)
			throw new InvalidArgumentException("Last name cannot be null or empty.");
		// if newLName is valid, set lastName to this value
		else
			this.lastName = newLName;
	} // end of setLastName method

	// method to get the iD
	public int getId() {
		return iD;
	} // end of getId method

	// method to set the iD
	public void setId(int newId) throws InvalidArgumentException {
		// check if newId is valid (greater than 0)
		if (newId > 0)
			// if newId is valid, set iD to this value
			this.iD = newId;
		// if not valid, throw InvalidArgumentException
		else
			throw new InvalidArgumentException("ID must be >= 0");
	}// end of setId method
} // end of Employee class