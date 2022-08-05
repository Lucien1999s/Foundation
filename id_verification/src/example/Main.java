package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader sr =                                                   //verify identity
                new BufferedReader(new InputStreamReader(System.in));
        String str;
        boolean isID;
        do {                                                                //make sure if id is wrong
            isID = true;
            System.out.println("Enter your identity card:");
            str = sr.readLine();
            if (!str.matches("[a-zA-Z]\\d{9}")) {
                System.out.println("Identity card's first char should be a English alphabet and plus nine numbers");
                isID = false;
            }
        }while (!isID);

        int[] letterNum = {10,11,12,13,14,15,16,17,34,18,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33};   //the list A~Z
        str = str.toUpperCase();                                                             //convert to uppercase
        char letter = str.charAt(0);                                              //got first case
        str = letterNum[letter - 'A'] + str.substring(1);                         //after check the first case from table,substitute to number
        int total1 = str.charAt(0)-'0';                                            //to sum up
        for(int i=1;i<10;i++){
            total1+=(str.charAt(i)-'0')*(10-i);
        }
        int checkNum = (10 - total1 % 10) % 10;                                 // 10 minus the digits of total ,then got digit

        if (checkNum == (str.charAt(10)-'0')){                                   //and compare the last number of our identity number with the check number
            System.out.println("Authentication succeeded");
        }else {
            System.out.println("Check error, has jumped out of the system");
            System.exit(0);
        }
    }
}
