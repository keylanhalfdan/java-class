package edu.seminolestate.volunteers;
import java.time.LocalDate;
/*
 * Author:	Robert Kaye
 * Date:	5/18/2017
 * Purpose:	An application class to test the Volunteer class
 */
public class ManageVolunteer {

	public static void main(String[] args) {

		// Instantiate an object using all variables
		Volunteer volunteer_1 = new Volunteer("John", "Doe", LocalDate.of(2015, 10, 31), 45.5);
		
		// Display Volunteer 1's info
		System.out.println("Volunteer 1\n" + volunteer_1 + "\n");
		
		// Instantiate an object with default values
		Volunteer volunteer_2 = new Volunteer();
		
		// Display Volunteer 2's info
		System.out.println("Volunteer 2\n" + volunteer_2 + "\n");
		
		// Instantiate an object with just a first and last name
		Volunteer volunteer_3 = new Volunteer("Sally", "Johnson");
		
		// Display Volunteer 3's info
		System.out.println("Volunteer 3\n" + volunteer_3 + "\n");		
		
		// Change Volunteer 1's hours and start date
		volunteer_1.updateVolunteerHours(20);
		volunteer_1.setStartDate(2016, 12, 16);
				
		// Display Volunteer 1's info after updating start date and hours
		System.out.println("Volunteer 1 after updating hours and start date\n" + volunteer_1);
		
	}
}
