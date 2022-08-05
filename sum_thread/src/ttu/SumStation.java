package ttu;

public class SumStation extends Thread{
    private long from,to,total;

    public SumStation(long from, long to){
        this.from = from;
        this.to = to;
        total = 0;
    }

    public synchronized void run(){
        for(long i=from;i<=to;i++){
            total += i;
        }
    }
    public synchronized long Total(){
        return this.total;
    }
}
