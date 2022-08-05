package ttu;

public class Assistant {
    private boolean unprocessedData = false;
    private int count;
    private String name;
    public synchronized void reportCount(String name,int count){
        while (unprocessedData){
            try{
                wait();
            }catch (InterruptedException e){}
        }
        System.out.println(name +"開票所新增"+count+"票");
        this.count=count;
        this.name=name;
        unprocessedData = true;
        notify();
    }
    public synchronized int getCount(){
        while (!unprocessedData){
            try{
                wait();
            }catch (InterruptedException e){}
        }
        int value = count;
        unprocessedData = false;
        notify();
        return value;
    }
}
