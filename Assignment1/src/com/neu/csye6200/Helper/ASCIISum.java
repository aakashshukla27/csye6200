package com.neu.csye6200.Helper;

import java.util.Scanner;

public class ASCIISum {
    public static void returnASCIISum(String  ipString){
        int sum = 0;
        int[] asciiArray = new int[ipString.length()];
        for (int i=0; i<ipString.length(); i++){
            //Getting ascii value and storing in array
            char c = ipString.charAt(i);
            asciiArray[i] = (int)c;
        }

        for (int i:asciiArray ) {
            sum+=i;
        }

        System.out.println("The ASCII sum is: " + sum);
    }
}
