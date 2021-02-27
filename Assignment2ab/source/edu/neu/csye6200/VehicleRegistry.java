package edu.neu.csye6200;
import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private static ArrayList<String> vehicleInventory = new ArrayList<String>();
    private static HashMap<String, String> vehicleDetails = new HashMap<String, String>();

    /**
     * @param licensePlate
     * @param vehicleName
     * adds vehicle details to both arraylist and hash map.
     */
    public void AddVehicleDetails(String licensePlate, String vehicleName){
        vehicleInventory.add(licensePlate);
        vehicleDetails.put(licensePlate, vehicleName);
    }

    /**
     * @param licensePlate
     * deletes vehicle from both the arraylist vehicleInventory and Hashmap vehicleDetails
     */
    public void deleteVehicleDetails(String licensePlate){
        boolean found = false;
        for (String s: vehicleInventory ) {
            if(s.equals(licensePlate)){
                vehicleInventory.remove(licensePlate);
                vehicleDetails.remove(licensePlate);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Record not found.\n");
        }
    }

    /**
     * returns list of all license plates by iterating over arraylist
     */
    public void getListOfVehicleLicensePlates(){
        System.out.println("Vehicle Inventory: ");
        int counter = 1;
        for (String s: vehicleInventory ) {
            System.out.println(counter + ": " +s);
            counter++;
        }
    }

    /**
     * @param licensePlate - vehicle license
     * returns key, value pair vehicle registration number, vehicle name
     */
    public void getVehicleByLicense(String licensePlate){
        boolean found = false;
        for(String s : vehicleDetails.keySet()){
            if (s.equals(licensePlate)){
                System.out.println("License Plate: " + s + " Vehicle Name: " + vehicleDetails.get(s) + "\n");
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Record not found\n");
        }

        if(vehicleDetails.containsKey(licensePlate)){
            System.out.println("License Plate: " + licensePlate + " Vehicle Name: " + vehicleDetails.get(licensePlate) + "\n");
        }
        else{
            System.out.println("Record not found\n");
        }
    }
    public ArrayList<Integer> temp(){
        int n1 = 10;
        int n = (int) n1 /2;
        int ntemp[] = new int[10];
        for (int i = 0; i < ntemp.length; i++) {

        }
        return new ArrayList<Integer>();
    }


}
