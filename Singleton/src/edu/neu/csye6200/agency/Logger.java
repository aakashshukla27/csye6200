package edu.neu.csye6200.agency;

import java.io.File;
import java.io.FileWriter;

public class Logger {

    public void WriteLog(Exception ex){
        try{
            File file = new File("error.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write("\n");
            fr.write(ex.toString());
            fr.close();

        }
        catch(Exception Ex){

        }



    }

}
