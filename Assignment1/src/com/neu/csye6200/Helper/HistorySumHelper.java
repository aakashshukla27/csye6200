package com.neu.csye6200.Helper;

import java.util.ArrayList;

public class HistorySumHelper {
    public static void historyPrinter(ArrayList<String> ipArray) {
        if(ipArray.size() < 3){
            System.out.println("Please make another choice as insufficient passwords are currently stored in the system.");
            System.out.println("\n");
        }
        else{
            System.out.println("Last 3 passwords are shown below:");
            for(int i= ipArray.size()-1; i>ipArray.size()-4; i--){
                System.out.println(ipArray.get(i));
                ASCIISum asciisum = new ASCIISum();
                asciisum.returnASCIISum(ipArray.get(i));
                System.out.println("\n");
            }
        }

    }
}
