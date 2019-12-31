//Written by Diana and Lubna
// the queue of Riders waiting for bus.
// Each location on the route will have a queue and name and number for bus stop.
// The array for choosing an arrival stop will have twice as much downtown bus stops and not-downtown.
import java.util.Queue;
import java.util.LinkedList;

public class Stop {
    private Queue<Rider> waiting = new LinkedList<>();
    private int ridersWaiting = 0;
    private int stop;

    public Stop(int stopNumber){
        stop = stopNumber;
    }

    public void add(Rider rider){
        waiting.add(rider);
        ridersWaiting++;
    }

    public Queue<Rider> removeRiders(boolean expressBus, int capacityAvailable) {
        Queue<Rider> q = new LinkedList<>();
        Queue<Rider> temp = new LinkedList<>();
        int count = 0;

        if(expressBus) {
            while (waiting.size() > 0) {
                if (count >= capacityAvailable)
                    temp.add(waiting.remove());
                else {
                    int x = waiting.peek().getDropoffStop();
                    if (x % 4 == 0) {
                        q.add(waiting.remove());
                        count++;
                        ridersWaiting--;
                    } else {
                        switch (x) {
                            case 0:
                            case 1:
                            case 14:
                            case 15:
                            case 16:
                            case 29:
                                q.add(waiting.remove());
                                count++;
                                ridersWaiting--;
                                break;
                            default:
                                temp.add(waiting.remove());
                                break;
                        }
                    }
                }
            }
        }
        //For express, removes rider from stop and places into queue

        else{
            while (waiting.size() > 0) {
                if (count >= capacityAvailable)
                    temp.add(waiting.remove());
                else {
                    q.add(waiting.remove());
                    count++;
                    ridersWaiting--;
                }
            }
        }
        //FOr regular busses, removes rider from the stop and places into a queue
        waiting = temp;
        return q;
    }
    //removes riders from stop and returns a queue of the riders to be added to the bus


    public void listPassengers(){
        System.out.println("\nPassengers at stop "+ stop + ": ");
        Rider temprider;
        Queue<Rider> temp = new LinkedList<>();
        while(waiting.size() < 0){
            temprider = waiting.remove();
            System.out.println(temprider.toString());
            temp.add(temprider);
        }
        System.out.println("There are "+ridersWaiting+" waiting at stop "+stop+" total");
        waiting = temp;
    }
    //list of passengers on stop

    public int numPassengers(){
        return waiting.size();
    }
    //Returns the number of riders waiting at the stop
}