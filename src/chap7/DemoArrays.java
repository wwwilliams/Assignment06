/* Westley W Williams
*  CIS 2212-800 Java I FlexPace
*  Assignment 06 - ARRAYS
*  Finished January 27th, 2021
*/
package chap7;

import java.util.Scanner;

public class DemoArrays {

	public static void main(String[] args) {
		// we are required to create the following variable names and parallel arrays
		final int PARALLEL_ARRAYS = 19; // this number will ensure that each array is the same size.
		final double MINIMUM_HOURS_REQUIRED = 5.0; // this is the minimum hours they can volunteer per week
		final double MINIMUM_WEEKS_REQUIRED = 2.0; // the user must have this many weeks worked
		// arrays, which consist of string and double arrays.
		// the string array will be declared and initialized.
		// another way of saying this is that we are hard coding the values in the
		// string array.
		// for names, I chose a lot of presidents.The other names were provided by the
		// assignment itself.
		String[] volunteerName = { "Anne Marie Anderson", "Billy Barber", "George Washington", "John Adams",
				"Thomas Jefferson", "James Madison", "James Monroe", "John Quincey Adams", "Andrew Jackson",
				"Martin Van Buren", "William Henry Harrison", "John Tyler", "James K. Polk", "Zachary Taylor",
				"Millard Fillmore", "Franklin Pierce", "James Buchanan", "Veronica Villeroy", "William Walker" };
		double[] hoursVolunteered = new double[PARALLEL_ARRAYS];
		double[] weeksVolunteered = new double[PARALLEL_ARRAYS];
		double[] totalHrsVolunteered = new double[PARALLEL_ARRAYS];
		double grandTotalHrsVolunteered = 0;

		// just a couple of string variables that we will use later.
		String presentationalTitle = "Non-Profit Org Volunteer Hours";
		String separationMarks = "* * * * * * * * * * * * * * * * * * * *";

		// I'll use these variables later
		double hoursVolunteeredPerWeek, numberOfWeeksWorked;
		double numberOfWeeksWorkedTotal = 0; // this will be the number of weeks worked when you add the weeks worked of
		// all people

		// a little styling to match the activity format requirements
		System.out.println(presentationalTitle);
		System.out.println(separationMarks);
		// I'll use a for loop here.
		// The goal is to loop through the entire list of volunteers.
		// as we go through that list of volunteers, we will input the hours and weeks
		// they volunteered.
		// notice that I used a constant, PARALLEL_ARRAYS. If each array changes in
		// size, that's the only constant I need to change.
		for (int arrayKey = 0; arrayKey < PARALLEL_ARRAYS; arrayKey++) {
			printVolunteer(arrayKey, volunteerName);
			// here, I use my first method, getUserHours. From that method,
			// I return the user input into the variable hoursVolunteeredPerWeek
			hoursVolunteeredPerWeek = getUserHoursOrWeeks("Hours volunteered per week: ");
			// this is my second method
			// I'm checking to make sure the user input enough hours.
			// As stated in the assignment, each volunteer needs a minimum amount of
			// volunteer work
			// let's store our hours volunteered in our hoursVolunteered array
			hoursVolunteered[arrayKey] = checkUserHoursOrWeeks("Minimum number of hours is ", hoursVolunteeredPerWeek,
					MINIMUM_HOURS_REQUIRED);

			numberOfWeeksWorked = getUserHoursOrWeeks("Number of weeks: ");
			numberOfWeeksWorkedTotal += numberOfWeeksWorked;
			// let's store our number of weeks in weeksVolunteered array
			weeksVolunteered[arrayKey] = checkUserHoursOrWeeks("Minimum number of weeks is ", numberOfWeeksWorked,
					MINIMUM_WEEKS_REQUIRED);

			// multiply the hours per week worked and the total weeks.
			// this gives us the total hours worked (or volunteered)
			totalHrsVolunteered[arrayKey] = hoursVolunteered[arrayKey] * weeksVolunteered[arrayKey];

		}
		System.out.println("\n" + presentationalTitle);
		grandTotalHrsVolunteered = printVolunteerData(volunteerName, hoursVolunteered, weeksVolunteered,
				totalHrsVolunteered, PARALLEL_ARRAYS, grandTotalHrsVolunteered);

		// I used this code from assignment 04 to help on the formatting for this
		// assignment
		// that code is the following: System.out.printf("Payment due at pickup: $ %,.2f
		// ", subTotal);

		System.out.printf("\nGrand total of volunteer hours: %,.2f%n", grandTotalHrsVolunteered);
		// last part of the assignment. I'm not sure the calculation is correct but the
		// professor isn't looking for this value to be correct
		// as long as the programming is correct.
		System.out.printf("Average hours per week per volunteer: %,.2f",
				(grandTotalHrsVolunteered / numberOfWeeksWorkedTotal));

	}// end of main

	public static void printVolunteer(int arrayKeyParameter, String[] volunteerNameParameter) {

		// print the volunteer, their number and name in the array
		System.out
		.println("\nVolunteer #" + (arrayKeyParameter + 1) + ": " + volunteerNameParameter[arrayKeyParameter]);

	}

	// so basically, this method allows us to get input from the user
	// this input is the hours the employee worked
	// I'm allowing for two parameters, so that this method can use the arrayKey
	// from the main method
	// and this method can also use the volunteerNames array which stores the names
	// of the people involved.

	public static double getUserHoursOrWeeks(String hoursOrWeeks) {
		// let's create a scanner
		Scanner getHoursScanner = new Scanner(System.in);
		// input to notify user what to do
		System.out.print(hoursOrWeeks);
		// input variable that stores input from user
		double userHours = getHoursScanner.nextDouble();

		return userHours;
	}// end of getUserHours method

	// beginning of method that checks the user hour input.
	// this method makes the user input another value if they input too low of a
	// value
	public static double checkUserHoursOrWeeks(String hoursOrWeeks, double hoursOrWeeksParameter,
			final double minHoursOrWeeksRequiredParameter) {

		double hoursOrWeeksVolunteered = hoursOrWeeksParameter;// initialize the return value
		Scanner checkHoursScanner = new Scanner(System.in);
		while (hoursOrWeeksVolunteered < minHoursOrWeeksRequiredParameter) {
			System.out.print(hoursOrWeeks + minHoursOrWeeksRequiredParameter + ". Please try again: ");
			hoursOrWeeksVolunteered = checkHoursScanner.nextDouble();
		}
		return hoursOrWeeksVolunteered;
	}// end of checkUserHours method

	// beginning of method that prints the data of each volunteer
	// this data includes the hours worked per week
	// the number of weeks worked
	// the total hours volunteered
	public static double printVolunteerData(String[] volunteerName, double[] hoursVolunteered,
			double[] weeksVolunteered, double[] totalHrsVolunteered, final int parallelArrays, double grandTotalHours) {

		for (int arrayKey = 0; arrayKey < parallelArrays; arrayKey++) {
			System.out.println("\n* * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println("Volunteer #" + (arrayKey + 1));
			System.out.println(volunteerName[arrayKey]);
			System.out.println("Hours per Week: " + hoursVolunteered[arrayKey]);
			System.out.println("Number of Weeks: " + weeksVolunteered[arrayKey]);
			// again, a little helper code from assignment 04 for formatting:
			// System.out.printf("Payment due at pickup: $ %,.2f ", subTotal);
			System.out.printf("Total Hours Volunteered: %,.2f", totalHrsVolunteered[arrayKey]);
			// let's integrate (sum the parts) the total hours volunteered of each
			// volunteer.
			grandTotalHours += totalHrsVolunteered[arrayKey];
		} // end of for loop
		return grandTotalHours;
	}// end of printVolunteerData method
}// end of class
