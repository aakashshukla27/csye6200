package edu.neu.csye6200.agency;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class VehicleTest {
    public static void main(String[] args) throws IOException {
        run();
    }

    static void run() throws IOException {
        RentalAgencyIO io = new RentalAgencyIO();
        Scanner scan = new Scanner(System.in);
        Vehicle v1 = new Vehicle(2, 30, 4, "Ferrari", "La Ferrari", 2020, "VBG 984");
        VehicleRegistry s = VehicleRegistry.getInstance();
        s.AddVehicleDetails(v1.licensePlate, v1.model);
        io.WriteFile(v1);



        Vehicle v2 = new Vehicle(7, 61, 8, "Toyota", "Land Cruiser", 2015, "IF ELSE");
        s.AddVehicleDetails(v2.licensePlate, v2.model);
        io.WriteFile(v2);
        Vehicle v3 = new Vehicle(5, 40, 20, "Suzuki", "Swift", 2019, "AB 12345");
        s.AddVehicleDetails(v3.licensePlate, v3.model);
        io.WriteFile(v3);

        TruckVehicle test1 = new TruckVehicle(2, 100, 2, "Volvo", "Model1",2010, "12 ABCD", 100, 50, 50);
        s.AddVehicleDetails(test1.licensePlate, test1.model);
        io.WriteFile(test1);
        Vehicle v4 = new Vehicle(2, 30, 4, "Ferrari", "La Ferrari", 2020, "VBG 123");
        s.AddVehicleDetails(v4.licensePlate, v4.model);
        io.WriteFile(v4);

        Vehicle v5 = new Vehicle(7, 61, 8, "Toyota", "Land Cruiser", 2015, "IF 123");
        s.AddVehicleDetails(v5.licensePlate, v5.model);
        io.WriteFile(v5);
        Vehicle v6 = new Vehicle(5, 40, 20, "Suzuki", "Swift", 2019, "AB 6789");
        s.AddVehicleDetails(v6.licensePlate, v6.model);
        io.WriteFile(v6);
        Vehicle v7 = new Vehicle(2, 30, 4, "Ferrari", "La Ferrari", 2020, "VBG 345");
        s.AddVehicleDetails(v7.licensePlate, v7.model);
        io.WriteFile(v7);
        Vehicle v8 = new Vehicle(7, 61, 8, "Toyota", "Land Cruiser", 2015, "IF 345");
        s.AddVehicleDetails(v8.licensePlate, v8.model);
        io.WriteFile(v8);
        Vehicle v9 = new Vehicle(5, 40, 20, "Suzuki", "Swift", 2019, "ABC 123");
        s.AddVehicleDetails(v9.licensePlate, v9.model);
        io.WriteFile(v9);

        v1.toString();
        printEquals();
        System.out.println(v1.toString());
        System.out.println("\nSearch Vehicle By Registration Number:");
        System.out.println("Enter Vehicle Number:");
        String vehicleNumber = scan.nextLine();
        printEquals();
        s.getVehicleByLicense(vehicleNumber);

        System.out.println("Printing List of Vehicles");
        printEquals();
        s.getListOfVehicleLicensePlates();

        //Delete vehicle - requires license number
        System.out.println("\nDelete Vehicle");
        System.out.println("Enter the vehicle number to delete");
        String number = scan.nextLine();
        s.deleteVehicleDetails(number);

        //Load Vehicle from file
        System.out.println("\nLoad Vehicle From File");
        System.out.println("Enter vehicle number");
        String fileNumber = scan.nextLine();
        printEquals();
        io.readFile(fileNumber);
        printEquals();
        //Display unsorted list of vehicles
        s.displayAllVehicles();

        printEquals();
        //Display sorted list of vehicles
        s.sortVehicles();
    }

    public static void printEquals(){
        System.out.println("\n");
        for (int i = 0; i < 35; i++) {
            System.out.print("=");
        }
        System.out.println("\n\tABC Rental Agency\n");
    }


}
