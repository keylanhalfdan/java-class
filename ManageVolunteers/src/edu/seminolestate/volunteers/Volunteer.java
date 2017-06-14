package edu.seminolestate.volunteers;
import java.time.LocalDate;
/*
 * Author:	Robert Kaye
 * Date:	5/18/2017
 * Purpose:	A service class representing a volunteer
 */
public class Volunteer {
	// Declare private variables (data fields)
	private String firstName;
	private String lastName;
	private LocalDate startDate;
	private double volunteerHours;
	
	// Declare public constants
	public static final String DEFAULT_FIRST_NAME = "no first name assigned";
	public static final String DEFAULT_LAST_NAME = "no last name assigned";
	public static final LocalDate DEFAULT_START_DATE = LocalDate.now();
	public static final double DEFAULT_VOLUNTEER_HOURS = 0;
	
	// Constructor for all variables
	public Volunteer(String newFirstName, String newLastName, LocalDate newStartDate, double newVolunteerHours){
		setFirstName(newFirstName);
		setLastName(newLastName);
		setStartDate(newStartDate);
		setVolunteerHours(newVolunteerHours);
	}
	
	// Default Constructor
	public Volunteer() {
		this.firstName = DEFAULT_FIRST_NAME;
		this.lastName = DEFAULT_LAST_NAME;
		this.startDate = DEFAULT_START_DATE;
		this.volunteerHours = DEFAULT_VOLUNTEER_HOURS;
	}
	
	// Constructor for just First and Last names
	public Volunteer(String newFirstName, String newLastName) {
		this.setFirstName(newFirstName);
		this.setLastName(newLastName);
		this.startDate = DEFAULT_START_DATE;
		this.volunteerHours = DEFAULT_VOLUNTEER_HOURS;
	}
	
	// Method to update volunteer hours
	public void updateVolunteerHours (double newVolunteerHours) {
		this.volunteerHours = volunteerHours + newVolunteerHours;
	}
	
	//getters and setters (accessors and mutators)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String newFirstName) {
		if (newFirstName != null && newFirstName.length() > 0)
			this.firstName = newFirstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String newLastName) {
		if (newLastName != null && newLastName.length() > 0)
			this.lastName = newLastName;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	 public void setStartDate(LocalDate newStartDate){
		if (newStartDate != null)
			this.startDate = newStartDate;
	 }
	
	public void setStartDate(int year, int month, int day) {
		this.startDate = LocalDate.of(year,  month, day);
		}
	 
	 public double getVolunteerHours() {
		return volunteerHours;
	}
	
	public void setVolunteerHours(double newVolunteerHours) {
		this.volunteerHours = volunteerHours + newVolunteerHours;
	}

	public String toString() {
		return
			"Volunteer [firstName=" + this.firstName +
			", lastName=" + this.lastName +
			", startDate=" + this.startDate +
			", volunteerHours=" +this.volunteerHours + "]";
	}
}