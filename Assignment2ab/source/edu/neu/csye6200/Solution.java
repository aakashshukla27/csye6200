package edu.neu.csye6200;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        returnCount(n);
        scanner.close();
    }
    public static void returnCount(int n){
        int returnList[] = new int[n];
        int counter = 0;
        while(n > 0){
            returnList[counter] = n%2;
            n = (int)n/2;
        }
        int count = 0;
        int max = 0;
        for(int i=0;i<returnList.length; i++){
            if(returnList[i] == 0){
                count = 0;
            }
            else{
                count++;
            }
            max = count > max ? count : max;
        }
        System.out.println(max);


    }
}
