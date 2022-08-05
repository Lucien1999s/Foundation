package example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<animal> animals = new ArrayList<>();                 //build 3 arrays
        ArrayList<swimmer>swimmers = new ArrayList<>();
        ArrayList<flyer> flyers = new ArrayList<>();

        animals.add(new bird("Tom","bird"));                 //store animals
        animals.add(new bird());
        animals.add(new eagle("Echo","eagle"));
        animals.add(new eagle());
        animals.add(new fish("Paul","fish"));
        animals.add(new fish());
        animals.add(new flyfish("Sharon","flyfish"));
        animals.add(new flyfish());

        swimmers.add(new fish("Paul","fish"));                //store swimmers
        swimmers.add(new fish());
        swimmers.add(new flyfish("Sharon","flyfish"));
        swimmers.add(new flyfish());
        swimmers.add(new waterplane("Caproni","waterplane"));
        swimmers.add(new waterplane());

        flyers.add(new bird("Tom","bird"));                    //store flyers
        flyers.add(new bird());
        flyers.add(new eagle("Echo","eagle"));
        flyers.add(new eagle());
        flyers.add(new waterplane("Caproni","waterplane"));
        flyers.add(new waterplane());

        System.out.println("animals display:\n-----------------");         //show animals
        for(animal a:animals){
            System.out.println(a);
        }
        System.out.println("-----------------\nLet's move");
        for(animal a:animals){
            a.move();
        }
        System.out.println("\n-------------------------------------------");

        System.out.println("swimmers display:\n-----------------");        //show swimmers
        for(swimmer b:swimmers){
            System.out.println(b);
        }
        System.out.println("-----------------");
        for(swimmer b:swimmers){
            b.swim();
        }
        System.out.println("\n-------------------------------------------");

        System.out.println("flyers display:\n-----------------");        //show flyers
        for(flyer c:flyers){
            System.out.println(c);
        }
        System.out.println("-----------------");
        for(flyer c:flyers){
            c.fly();
        }
    }
}
