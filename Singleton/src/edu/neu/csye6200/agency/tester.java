package edu.neu.csye6200.agency;

import java.io.File;
import java.io.FileWriter;

public class tester {
    public static void main(String[] args) {
        try{

            File file = new File("error.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write("\n");
            fr.write("Test123");
            fr.close();

        }
        catch(Exception Ex){

        }
    }
}
