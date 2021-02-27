package edu.neu.csye6200;

import java.io.File;
import java.util.Scanner;

public class FileReader {
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
        }
    }


}
