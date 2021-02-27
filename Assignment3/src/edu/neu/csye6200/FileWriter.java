package edu.neu.csye6200;

import java.io.IOException;
import java.util.HashMap;

public class FileWriter {
    public void WriteToFile(HashMap<String, String> input, String registrationNumber) throws IOException {
        try{
            save(input, registrationNumber);
            saveData(input, registrationNumber);
        }
        catch(Exception Ex){
            System.out.println(Ex.toString());
        }

    }

    /**
     * @params input (Hashmap containing all data)
     * @params registrationNumber - vehicle registration number
     * creates files with data and description
     */

    private void save(HashMap<String, String> input, String registrationNumber) throws IOException {
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

    /**
    * @params input (Hashmap containing all data)
     * @params registrationNumber - vehicle registration number
     * creates files with only the data of vehicles
     */
    private void saveData(HashMap<String, String> input, String registrationNumber) throws IOException {
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

}
