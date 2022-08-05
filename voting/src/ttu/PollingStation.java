package ttu;

public class PollingStation extends Thread{
    static int reportTimes = 5;
    int total = 0;
    Assistant a;
    String name;

    public PollingStation (Assistant a,String name){
        this.a = a;
        this.name = name;
    }
    public void run(){
        for (int i=0;i<reportTimes;i++){
            int count = (int) (Math.random()*500);
            a.reportCount(name,count);
            total+=count;
        }
    }
}
