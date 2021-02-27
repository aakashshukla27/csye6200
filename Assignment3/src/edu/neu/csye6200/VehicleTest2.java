package edu.neu.csye6200;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleTest2 {
    /**
    Reading data from file
    -- Ensure that you have the file present - sample files are added
    -- We take the data from the files, create an object and create new elements of both Vehicle and Truck Vehicle class
     NOTE: This creates new files too with new class data
     */
    public static void main(String[] args) throws IOException {
        var temp = load("12 ABCD_meta.txt");

        Vehicle newVehicle = new Vehicle(Integer.parseInt(temp.get(3)),Integer.parseInt(temp.get(4)),Double.parseDouble(temp.get(5)), temp.get(0), temp.get(1), Integer.parseInt(temp.get(2)), "New_number1234");

        TruckVehicle newTruckVehicle = new TruckVehicle(Integer.parseInt(temp.get(3)),Integer.parseInt(temp.get(4)),Double.parseDouble(temp.get(5)), temp.get(0), temp.get(1), Integer.parseInt(temp.get(2)), "New_number12345", 100, 200, 300);


    }

    /**
    @params licenseNumber - returns an array list with details of vehicle based on the registration number
     */
    public static ArrayList<String> load(String LicenseNumber){
        ArrayList<String> vehicleData = new ArrayList<String>();
        try{
            File myObj = new File(LicenseNumber);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                vehicleData.add(data);
                //System.out.println(data);
            }
            myReader.close();
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        return vehicleData;
    }
}
