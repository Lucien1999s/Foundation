package ttu;

import ttu.animal.*;
public class Main {
    public static void main(String[] args) {
        animal[] animals ={                                             //store in an animal array
                new elephant("小飛象","elephant"),
                new elephant(),
                new tiger("虎姑婆","tiger"),
                new tiger(),
                new giraffe("長頸鹿美語","giraffe"),
                new giraffe(),
                new chicken("小畜生","chicken"),
                new chicken(),
                new brontosaurus("脖子長很酸","brontosaurus"),
                new brontosaurus(),
                new titan("進擊的巨人","titan"),
                new titan()
        };
        System.out.println("before sort:\n-----------------");         //before sort
        for(animal a:animals){
            System.out.println(a);
        }
        ttu.sort.sort.bubbleSort(animals);                            //sort
        System.out.println();
        System.out.println("after sorted:\n------------------");       //after sorted
        for(animal a:animals){
            System.out.println(a);
        }
    }
}
