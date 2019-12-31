//Written by Diana and Lubna
// makes a new rider, pickupstop, dropoffstop, and time
public class Rider{
    private int pickupStop;
    private int dropoffStop;
    private double arrivaltime;
    public Rider(int start, int destination, int time){
        pickupStop=start;
        dropoffStop=destination;
        arrivaltime=time;
    }
    public int getPickupStop(){
        return pickupStop;
    }
    public double getArrivaltime(){
        return arrivaltime;
    }
    public int getDropoffStop(){
        return dropoffStop;
    }
    public String toString(){
        String s="Rider Pickup Stop: "+pickupStop+" Rider Dropoff Stop: "+ dropoffStop + " Time: "+ arrivaltime;
        return s;
    }

}