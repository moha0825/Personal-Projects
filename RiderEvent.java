//Written by Diana and Lubna
// Will reschedule itself(agenda)
//create a Rider(one every 120 sec)
//place the Rider in correct stop queue.

import java.util.Random;

public class RiderEvent implements Event {
    private int stop;
    private Rider rider;
    private Random r=new Random(); //assigns destination stop using Parameter class
    public RiderEvent(int busStop){
        stop=busStop;
        int destination;
        if(stop>=15){             //westbound passenger destination
            destination = r.nextInt(36);
            while((Parameters.stopSelect[destination] <stop && Parameters.stopSelect[destination]!=0) || Parameters.stopSelect[destination]==stop){
                destination= r.nextInt(36);
            }
        }
        else{                    //eastbound passenger destination
            destination = r.nextInt(36);
            while((Parameters.stopSelect[destination] <stop && Parameters.stopSelect[destination]==stop) || Parameters.stopSelect[destination]>= 16){
                destination= r.nextInt(36);
            }
            rider=new Rider(stop, Parameters.stopSelect[destination], (int) BusSim.agenda.getCurrentTime());
        }
    }
    public void run(){
        BusSim.stops[stop].add(rider);
        double time=Parameters.riderRate+Parameters.riderRate*(Parameters.arrivalPercents[r.nextInt(20)]);
        int nextStop = Parameters.stopSelect[r.nextInt(36)];
        BusSim.agenda.add(new RiderEvent(nextStop), time);                        //adds rider to stop, and generates next stop
    }

}