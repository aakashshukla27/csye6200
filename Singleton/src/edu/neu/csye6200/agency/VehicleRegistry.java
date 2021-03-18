package edu.neu.csye6200.agency;

import java.util.*;

public class VehicleRegistry {
    private static VehicleRegistry instance = null;
    private static ArrayList<String> vehicleInventory = new ArrayList<String>();
    private static HashMap<String, String> vehicleDetails = new HashMap<String, String>();
    private VehicleRegistry(){

    }

    public static VehicleRegistry getInstance(){
        if(instance == null){
            instance = new VehicleRegistry();
        }
        return instance;
    }
    public void getVehicleByLicense(String licensePlate){
        if(vehicleDetails.containsKey(licensePlate)){
            System.out.println("License Plate: " + licensePlate + " Vehicle Name: " + vehicleDetails.get(licensePlate) + "\n");
        }
        else{
            System.out.println("Record not found\n");
        }
    }

    public void AddVehicleDetails(String licensePlate, String vehicleName){
        vehicleInventory.add(licensePlate);
        vehicleDetails.put(licensePlate, vehicleName);
    }
    public void getListOfVehicleLicensePlates(){
        System.out.println("Vehicle Inventory: ");
        int counter = 1;
        for (String s: vehicleInventory ) {
            System.out.println(counter + ": " +s);
            counter++;
        }
    }

    public void deleteVehicleDetails(String licensePlate){
        boolean found = false;
        for (String s: vehicleInventory ) {
            if(s.equals(licensePlate)){
                vehicleInventory.remove(licensePlate);
                vehicleDetails.remove(licensePlate);
                found = true;
                System.out.println("Deleted Vehicle: " + licensePlate);
                break;
            }
        }
        if(!found){
            System.out.println("Record not found.\n");
        }
    }

    public void displayAllVehicles(){
        System.out.println("Unsorted list of vehicles");
        for(String key: vehicleDetails.keySet()){
            System.out.println(key + " : " + vehicleDetails.get(key) );
        }
    }

    public void sortVehicles(){
        SortedSet<String> keys = new TreeSet<>(vehicleDetails.keySet());
        System.out.println("Sorted list of Vehicles");
        for(String key : keys){
            String value = vehicleDetails.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
