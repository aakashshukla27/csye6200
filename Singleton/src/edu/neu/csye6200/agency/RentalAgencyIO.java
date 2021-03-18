package edu.neu.csye6200.agency;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RentalAgencyIO {

    Logger log = new Logger();

    public void WriteFile(Vehicle data) throws IOException {
        HashMap<String, String> vehicleDetailsHelper = new HashMap<String, String>();
        vehicleDetailsHelper.put("Make", data.make);
        vehicleDetailsHelper.put("Model", data.model);
        vehicleDetailsHelper.put("Year",String.valueOf(data.modelYear));
        vehicleDetailsHelper.put("Capacity", String.valueOf(data.passengers));
        vehicleDetailsHelper.put("Tank", String.valueOf(data.fuelCap));
        vehicleDetailsHelper.put("Mileage", String.valueOf(data.kpl));
        vehicleDetailsHelper.put("Range", String.valueOf(data.range));
        vehicleDetailsHelper.put("License", data.licensePlate);
        //RentalAgencyIO fw = new RentalAgencyIO();
        try{
            WriteToFile(vehicleDetailsHelper, data.licensePlate);
        }
        catch(Exception ex){
            log.WriteLog(ex);
        }

    }

    /**
     *
     * @param input - Hashmap vehicle data
     * @param registrationNumber - string registration number
     * @throws IOException
     */

    private void WriteToFile(HashMap<String, String> input, String registrationNumber) throws IOException {
        try{
            save(input, registrationNumber);
            saveData(input, registrationNumber);
        }
        catch(Exception Ex){
            System.out.println(Ex.toString());
            log.WriteLog(Ex);
        }

    }

    /**
     *
     * @param input - hash map containing vehicle data
     * @param registrationNumber - string registration number
     * @throws IOException
     */


    private void save(HashMap<String, String> input, String registrationNumber) throws IOException {
        try{
            String fileName = registrationNumber;
            java.io.FileWriter fw = new java.io.FileWriter(fileName + ".txt");
            fw.write("Make:");
            fw.write(input.get("Make"));
            fw.write("\n");
            fw.write("Model:");
            fw.write(input.get("Model"));
            fw.write("\n");
            fw.write("Year:");
            fw.write(input.get("Year"));
            fw.write("\n");
            fw.write("Capacity:");
            fw.write(input.get("Capacity"));
            fw.write("\n");
            fw.write("Tank:");
            fw.write(input.get("Tank"));
            fw.write("\n");
            fw.write("Mileage:");
            fw.write(input.get("Mileage"));
            fw.write("\n");
            fw.write("Range:");
            fw.write(input.get("Range"));
            fw.write("\n");
            fw.write("License:");
            fw.write(input.get("License"));
            fw.write("\n");
            fw.close();
        }
        catch(Exception ex){
            System.out.println(ex.toString());
            log.WriteLog(ex);
        }

    }

    /**
     * @params input (Hashmap containing all data)
     * @params registrationNumber - vehicle registration number
     * creates files with only the data of vehicles
     */
    private void saveData(HashMap<String, String> input, String registrationNumber) throws IOException {
        try{
            String fileName = registrationNumber;
            java.io.FileWriter fw = new java.io.FileWriter(fileName + "_meta.txt");
            fw.write(input.get("Make"));
            fw.write("\n");
            fw.write(input.get("Model"));
            fw.write("\n");
            fw.write(input.get("Year"));
            fw.write("\n");
            fw.write(input.get("Capacity"));
            fw.write("\n");
            fw.write(input.get("Tank"));
            fw.write("\n");
            fw.write(input.get("Mileage"));
            fw.write("\n");
            fw.write(input.get("Range"));
            fw.write("\n");
            fw.write(input.get("License"));
            fw.write("\n");
            fw.close();
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            log.WriteLog(ex);
        }

    }

    /**
     *
     * @param LicenseNumber - read file corresponding to license number
     */

    public void readFile(String LicenseNumber){
        try{
            File myObj = new File(LicenseNumber + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch(Exception ex){
            System.out.println(ex.toString());
            log.WriteLog(ex);
        }
    }

    /**
     @params licenseNumber - returns an array list with details of vehicle based on the registration number
     */
    public ArrayList<String> load(String LicenseNumber){
        ArrayList<String> vehicleData = new ArrayList<String>();
        try{
            File myObj = new File(LicenseNumber);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                vehicleData.add(data);
            }
            myReader.close();
        }
        catch(Exception ex){
            System.out.println(ex.toString());
            log.WriteLog(ex);
        }
        return vehicleData;
    }
}
