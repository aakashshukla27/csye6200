package edu.neu.csye6200;

/**
 * CSYE 6200 Assignment #2 starter file
 */

import java.io.IOException;
import java.util.*;

/**
 * A special class used to test the Vehicle class
 *
 * @author Aakash Shukla
 * ID: 001557554
 */
public class VehicleTest {

    /**
     * This is where your program starts
     * Refer to VehicleTest2.java class for part 3 of the assignment - create class object from file data
     *
     * @param args Enter the choice and display result based on switch statement
     */
    public static void main(String[] args) throws IOException {
        run();
    }

    static void run() throws IOException {

            Vehicle sportsCar = new Vehicle(2, 30, 4, "Ferrari", "La Ferrari", 2020, "VBG 984");
            Vehicle SUV = new Vehicle(7, 61, 8, "Toyota", "Land Cruiser", 2015, "IF ELSE");
            Vehicle hatchBack = new Vehicle(5, 40, 20, "Suzuki", "Swift", 2019, "AB 12345");
            TruckVehicle test1 = new TruckVehicle(2, 100, 2, "Volvo", "Model1",
                    2010, "12 ABCD", 100, 50, 50);

        int i = 100;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Refer to VehicleTest2.java class for part 3 of the assignment - create class object from file data");
            System.out.println("Please enter your choice");
            System.out.println("1. Sports Car\n2. SUV\n3. Hatchback");
            System.out.println("4. List of Vehicles by License Plate\n5. List of Vehicle Licenses");
            System.out.println("6. Delete Vehicle by license plate\n7. Load from file");
            System.out.println("8. Truck\n9. Exit");

            int choice = scan.nextInt();
            VehicleRegistry vr = new VehicleRegistry();
            switch (choice) {
                case 1:
                    //Prints sports car
                    System.out.println("Sports Car: " + sportsCar.toString());
                    break;
                case 2:
                    //Prints SUV
                    System.out.println("SUV: " + SUV.toString());
                    break;
                case 3:
                    //Prints hatchback
                    System.out.println("Hatchback: " + hatchBack.toString());
                    break;
                case 4:
                    //Vehicle Details based on number
                    scan.nextLine();
                    System.out.println("Enter Vehicle Number");
                    String vehicleNumber = scan.nextLine();
                    vr.getVehicleByLicense(vehicleNumber);
                    break;
                case 5:
                    //List all vehicles
                    vr.getListOfVehicleLicensePlates();
                    break;
                case 6:
                    //Delete vehicle - requires license number
                    scan.nextLine();
                    System.out.println("Enter the vehicle number to delete");
                    String number = scan.nextLine();
                    vr.deleteVehicleDetails(number);
                    break;
                case 7:
                    //Load vehicle details from file
                    scan.nextLine();
                    System.out.println("Enter vehicle number");
                    String fileNumber = scan.nextLine();
                    FileReader fw = new FileReader();
                    fw.readFile(fileNumber);
                    break;
                case 8:
                    //Prints truck details
                    System.out.println("Truck: " + test1.printDetails());
                    break;
                case 9:
                    //Closes the current program
                    scan.close();
                    System.out.println("Terminating current program");
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice");
                    break;
            }

        }
        while (i == 100);

    }

}
