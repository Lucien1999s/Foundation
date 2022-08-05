package example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String key1,key2;
        Scanner sc = new Scanner(System.in);
        System.out.print("建立密碼:");
        String pwd = sc.next();

        data data1 = new data(pwd);
        for (int i=0;i<3;i++){
            try {
                System.out.print("1:");
                key1 = sc.next();
                System.out.print("2:");
                key2 = sc.next();
                data1.check(key1,key2);
            }catch (dataError | InputMismatchException error){
                System.out.println(error);
            }
        }
    }
}
