package edu.neu.csye6200;

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
        run();
    }

    static void run(){
        Vehicle sportsCar = new Vehicle(2, 30, 4, "Ferrari", "La Ferrari",2020, "VBG 984");
        Vehicle SUV = new Vehicle(7, 61, 8, "Toyota", "Land Cruiser", 2015, "IF ELSE");
        Vehicle hatchBack = new Vehicle(5, 40, 20, "Suzuki", "Swift", 2019, "AB 12345");
        int i = 10;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("Please enter your choice");
            System.out.println("1. Sports Car\n2. SUV\n3. Hatchback");
            System.out.println("4. List of Vehicles by License Plate\n5. List of Vehicle Licenses");
            System.out.println("6. Delete Vehicle by license plate\n7. Exit");

            int choice = scan.nextInt();
            VehicleRegistry vr = new VehicleRegistry();
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
                    scan.nextLine();
                    System.out.println("Enter Vehicle Number");
                    String vehicleNumber = scan.nextLine();
                    vr.getVehicleByLicense(vehicleNumber);
                    break;
                case 5:
                    vr.getListOfVehicleLicensePlates();
                    break;
                case 6:
                    scan.nextLine();
                    System.out.println("Enter the vehicle number to delete");
                    String number = scan.nextLine();
                    vr.deleteVehicleDetails(number);

                    break;
                case 7:
                    scan.close();
                    System.out.println("Terminating current program");
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice");
                    break;
            }

        }
        while(i == 10);

    }

}
