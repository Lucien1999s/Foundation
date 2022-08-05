package ttu;

public class Main {
    static int total = 0;
    static int numOfStations = 2;
    static PollingStation[] stations;
    public static void main(String[] args) {
        Assistant a = new Assistant();

        stations = new PollingStation[numOfStations];
        for (int i=1;i<=numOfStations;i++){
            stations[i-1] = new PollingStation(a,i+"號");
        }
        for(int i=0;i<numOfStations;i++){
            stations[i].start();
        }
        for (int i=0;i<numOfStations*PollingStation.reportTimes;i++){
            total+=a.getCount();
            System.out.println("目前總票數:"+total);
        }
        System.out.println("最後投票結果:");

        for (int i=0;i<numOfStations;i++){
            System.out.println(stations[i].name+":"+stations[i].total);
        }
        System.out.println("總票數:"+total);
    }
}
