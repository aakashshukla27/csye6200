package com.neu.csye6200.Helper;

public class NumberAssign {
    public static void AssignNumbersToString(String ipString) {
        int fixedValueToAdd = 50;
        int[] encryptArray = new int[ipString.length()];
        //Adding 50 to ascii value of each character
        for(int i=0; i<ipString.length(); i++){
            char c = ipString.charAt(i);
            encryptArray[i] = (int) c + fixedValueToAdd;
        }
        System.out.println("Output : Each character converted to a number.");
        for (int i:encryptArray) {
            System.out.print(i + " ");
        }
    }
}
