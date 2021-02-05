package com.neu.csye6200.Helper;

import java.util.ArrayList;
import java.util.Scanner;

public class InputHelper {
    public static void InputHandler() {
        int tempGlobal = 10;
        Scanner scan = new Scanner(System.in);
        //passwords are stored in this list
        ArrayList<String> passwordHistory = new ArrayList<String>();
        do{
            //User input options
            System.out.println("\nSelect your option: ");
            System.out.println("1. Print sum of ASCII values.");
            System.out.println("2. Convert Password to number.");
            System.out.println("3. Print password history and ASCII sum.");
            System.out.println("4. Quit");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                    System.out.println("\nEnter your password");
                    String s1 = scan.nextLine();
                    passwordHistory.add(s1);
                    //Returning ascii sum
                    ASCIISum asciisum = new ASCIISum();
                    asciisum.returnASCIISum(s1);
                    break;
                case 2:
                    System.out.println("\nEnter your password");
                    s1 = scan.nextLine();
                    passwordHistory.add(s1);
                    s1 = s1.toUpperCase();
                    //Special Password Condition
                    if(s1.equals("AAKASHSH")){
                        System.out.println("\nSpecial password accepted.");
                    }
                    else{
                        NumberAssign encryptNumber = new NumberAssign();
                        encryptNumber.AssignNumbersToString(s1);
                    }
                    break;
                case 3:
                    HistorySumHelper hsHelper = new HistorySumHelper();
                    //printing password history
                    hsHelper.historyPrinter(passwordHistory);
                    break;
                case 4:
                    System.out.println("Terminating current program");
                    System.exit(0);
                default:
                    System.out.println("Wrong input - Terminating current ");
                    System.exit(0);
            }
        }
        while(tempGlobal == 10);

    }
}
