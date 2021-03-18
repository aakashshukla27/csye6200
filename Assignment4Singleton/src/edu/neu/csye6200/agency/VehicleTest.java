package edu.neu.csye6200.agency;

/**
 * CSYE 6200 Assignment #2 starter file
 */

import java.io.FileReader;
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
        RentalAgencyIO fw = new RentalAgencyIO();
        Scanner scan = new Scanner(System.in);
        Vehicle sportsCar = new Vehicle(2, 30, 4, "Ferrari", "La Ferrari", 2020, "VBG 984");
        Vehicle SUV = new Vehicle(7, 61, 8, "Toyota", "Land Cruiser", 2015, "IF ELSE");
        Vehicle hatchBack = new Vehicle(5, 40, 20, "Suzuki", "Swift", 2019, "AB 12345");
        TruckVehicle test1 = new TruckVehicle(2, 100, 2, "Volvo", "Model1",
                2010, "12 ABCD", 100, 50, 50);

//        fw.printEquals();
//        System.out.println(sportsCar.toString());
//        fw.printEquals();
//        System.out.println(SUV.toString());
//        fw.printEquals();
//        System.out.println(hatchBack.toString());
//        fw.printEquals();
//        System.out.println(test1.printDetails());

        //Vehicle Details based on license

//        System.out.println("\nSearch Vehicle By Registration Number:");
//        VehicleRegistry vr = new VehicleRegistry();
//        fw.printEquals();
//        System.out.println("Enter Vehicle Number:");
//        String vehicleNumber = scan.nextLine();
//        fw.printEquals();
//        vr.getVehicleByLicense(vehicleNumber);

        //List all vehicles
//        fw.printEquals();
//        System.out.println("Printing all vehicles");
//        vr.getListOfVehicleLicensePlates();
//        fw.printEquals();

        //Delete vehicle - requires license number
//        fw.printEquals();
//        System.out.println("\nDelete Vehicle");
//        System.out.println("Enter the vehicle number to delete");
//        String number = scan.nextLine();
//        vr.deleteVehicleDetails(number);
//        fw.printEquals();
//        //Load vehicle details from file
//        System.out.println("\nLoad Vehicle From File");

//        System.out.println("Enter vehicle number");
//        String fileNumber = scan.nextLine();
//        fw.printEquals();
//        fw.readFile(fileNumber);

//        fw.printEquals();
        //Create object from file
//        System.out.println("\nCreating new object of both vehicle and truck vehicle class from file");
//        var temp = fw.load("12 ABCD_meta.txt");
//        Vehicle newVehicle = new Vehicle(Integer.parseInt(temp.get(3)),Integer.parseInt(temp.get(4)),Double.parseDouble(temp.get(5)), temp.get(0), temp.get(1), Integer.parseInt(temp.get(2)), "New_number1234");
//        TruckVehicle newTruckVehicle = new TruckVehicle(Integer.parseInt(temp.get(3)),Integer.parseInt(temp.get(4)),Double.parseDouble(temp.get(5)), temp.get(0), temp.get(1), Integer.parseInt(temp.get(2)), "New_number12345", 100, 200, 300);

//        System.out.println("\nPrinting newly created vehicles:");
//        fw.printEquals();
//        System.out.println(newTruckVehicle.printDetails());
        VehicleRegistrySingleton s = VehicleRegistrySingleton.getInstance();

        s.getVehicleByLicense("12 ABCD");


        //VehicleRegistrySingleton t = VehicleRegistrySingleton.getInstance(String licensePlate, String vehicleName);
    }

}
