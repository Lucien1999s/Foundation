package ttu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int choose = 5;
        long num = 1000000000;
        System.out.println("-----------------------\nuse three threads:");
        long startTime2 = System.currentTimeMillis();
        ExecutorService executorService2 = Executors.newFixedThreadPool(choose);          //let three thread sum it respectively


        SumStation one2 = new SumStation(1,333333333);
        SumStation two2 = new SumStation(333333334,666666666);
        SumStation three2 = new SumStation(666666667,num);
        executorService2.execute(one2);
        executorService2.execute(two2);
        executorService2.execute(three2);

        executorService2.shutdown();
        long totals2 = one2.Total() + two2.Total() +three2.Total();

        long endTime2 = System.currentTimeMillis();

        System.out.println("need time:"+(endTime2 - startTime2)+" ms");
        System.out.println("total="+totals2);


        System.out.println("-----------------------\nuse five threads:");
        ExecutorService executorService = Executors.newFixedThreadPool(choose);          //let five thread sum it respectively

        long startTime1 = System.currentTimeMillis();
        SumStation one = new SumStation(1,num/5);
        SumStation two = new SumStation((num/5)+1,(num/5)*2);
        SumStation three = new SumStation((num/5)*2+1,(num/5)*3);
        SumStation four = new SumStation((num/5)*3+1,(num/5)*4);
        SumStation five = new SumStation((num/5)*4+1,num);
        executorService.execute(one);
        executorService.execute(two);
        executorService.execute(three);
        executorService.execute(four);
        executorService.execute(five);

        executorService.shutdown();
        long totals = one.Total() + two.Total() +three.Total()+ four.Total()+ five.Total();

        long endTime1 = System.currentTimeMillis();

        System.out.println("need time:"+(endTime1 - startTime1)+" ms");
        System.out.println("total="+totals);
    }
}
