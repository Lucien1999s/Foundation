package example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    void merge(int[] arr, int l, int m, int r)               //method of merge sorting
    {
        int n1 = m - l + 1;
        int n2 = r- m;

        int[] L =new int[n1];
        int[] R =new int[n2];

        System.arraycopy(arr, l, L, 0, n1);
        for(int j=0;j<n2;++j)
            R[j] = arr[m+1+j];
        int i = 0,j = 0;
        int k=l;
        while(i<n1&&j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }
            else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }
    void sort(int[] arr, int l, int r){                 //sort
        if(l<r){
            int m=l+(r-l)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    static void printArray(int[] arr){                    //print the array
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
    public static void main(String[] args) {       //InputMismatchException
        try {
            while(true){
                int[] arr = new int[6];
                Scanner sc = new Scanner(System.in);

                System.out.print("enter 6 number>>");
                for (int i = 0; i <= 5; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println("choose 1 increase 2 decrease ->") ;
                int choose = sc.nextInt();
                System.out.println("Given Array");
                printArray(arr);
                if(choose==1){
                    Main ob = new Main();
                    ob.sort(arr,0,arr.length -1);
                    System.out.println("\nSorted array");
                    printArray(arr);
                }
                else{
                    for(int i=0;i<arr.length;i++){
                        for(int j=0;j<arr.length-1;j++){
                            if(arr[i]>arr[j]){
                                int temp=arr[i];
                                arr[i]=arr[j];
                                arr[j]=temp;
                            }
                        }
                    }
                    System.out.println("\nSorted array");
                    for (int j : arr) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
            }
        }catch (InputMismatchException e) {
            System.out.println(e);
        }
    }
}
