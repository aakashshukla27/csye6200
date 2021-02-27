package com.neu.csye6200.Helper;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

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
                double num = 1323.526;

                NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
                String temp = defaultFormat.format(num);
                System.out.println("US: " + defaultFormat.format(num));

            }
        }

    }
}
