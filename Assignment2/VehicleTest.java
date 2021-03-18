/**
 * CSYE 6200 Assignment #2 starter file
 */

import java.util.*;

/**
 * A special class used to test the Vehicle class
 * @author Aakash Shukla
 * ID: 001557554
 *
 */
public class VehicleTest {

	/**
	 * This is where your program starts
	 * @param args
	 * Enter the choice and display result based on switch statement
	 */
	public static void main(String[] args) {
		Vehicle sportsCar = new Vehicle(2, 30, 4, "Ferrari", "La Ferrari", 2020);
		Vehicle SUV = new Vehicle(7, 61, 8, "Toyota", "Land Cruiser", 2015);
		Vehicle hatchBack = new Vehicle(5, 40, 20, "Suzuki", "Swift", 2019);

		Vehicle obj[] = {sportsCar, SUV, hatchBack};

		System.out.println("Please select the category for available vehicles:");
		System.out.println("\n1. Sports Car\n2. SUV\n3. Hatchback\n4. Exit");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();

		switch (choice){
			case 1:
				System.out.println("Sports Car: " + sportsCar.toString());
				break;
			case 2:
				System.out.println("SUV: " + SUV.toString());
				break;
			case 3:
				System.out.println("Hatchback: " + hatchBack.toString());
				break;
			case 4:
				scan.close();
				System.out.println("Terminating current program");
				System.exit(0);
			default:
				System.out.println("Wrong Choice");
				break;
		}
		scan.close();
	}

}
