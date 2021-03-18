package edu.neu.csye6200.agency;

import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistrySingleton {
    private static VehicleRegistrySingleton instance = null;
    public static ArrayList<String> vehicleInventory = new ArrayList<String>();
    public static HashMap<String, String> vehicleDetails = new HashMap<String, String>();

    private VehicleRegistrySingleton(){

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

    public static VehicleRegistrySingleton getInstance(){
        if(instance == null){
            instance = new VehicleRegistrySingleton();
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

}
