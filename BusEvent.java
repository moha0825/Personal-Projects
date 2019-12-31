////Written by Diana and Lubna
//Deboard(2 sec per rider), and board(3 sec to get on bus).
//Update time for the agenda.(240 sec to travel between stops+15 wait time)
//If the bus arrives at Union Depot, it will then leave westbound.
import java.util.Queue;

public class BusEvent implements Event {
    private Bus bus;

    public BusEvent(Bus oldBus){
        bus = oldBus;
        bus.setCurrentStop((bus.getCurrentStop()+1)%30);
        //sets next stop for regular bus line
    }

    public BusEvent(ExpressBus oldBus, boolean ExBus){
        bus = oldBus;
        switch(bus.getCurrentStop()){
            case 0:
                bus.setCurrentStop(1);
                break;
            case 1:
                bus.setCurrentStop(4);
                break;
            case 4:
                bus.setCurrentStop(8);
                break;
            case 8:
                bus.setCurrentStop(12);
                break;
            case 12:
                bus.setCurrentStop(14);
                break;
            case 14:
            case 15:
                bus.setCurrentStop(bus.getCurrentStop()+1);
                break;
            case 16:
                bus.setCurrentStop(20);
                break;
            case 20:
                bus.setCurrentStop(24);
                break;
            case 24:
                bus.setCurrentStop(28);
                break;
            case 28:
            case 29:
                bus.setCurrentStop((bus.getCurrentStop()+1)%30);
                break;
            default:
                System.out.println("Express bus is off course");
                break;
            //sets next stop for express bus line
        }
    }

    public void run(){
        int numRemoved = bus.removeRiders(bus.getCurrentStop());
        Queue<Rider> added;
        Rider temp;
        if(bus instanceof ExpressBus){
            added = BusSim.stops[bus.getCurrentStop()].removeRiders(true, bus.getCapacity());
        }
        else {
            added = BusSim.stops[bus.getCurrentStop()].removeRiders(false, bus.getCapacity());
        }
        int numAdded = 0;
        for(int i = 0; i< added.size(); i++){
            temp = added.remove();
            Statistics.totalWaitTime += (BusSim.agenda.getCurrentTime() - temp.getArrivaltime());
            Statistics.ridersTotal++;
            if(Statistics.maxWaitTime < (BusSim.agenda.getCurrentTime() - temp.getArrivaltime()))
                Statistics.maxWaitTime = (BusSim.agenda.getCurrentTime() - temp.getArrivaltime());
            bus.addRider(temp);
            numAdded++;
        }
        //removes riders from bus and adds to express and regular

        double time;
        if((numAdded*3 + numRemoved*2) < 15)
            time = 240 + 15;
        else
            time = 240 + (numAdded*3) + (numRemoved*2);
        //assigns time either by 15 second wait or passenger addition

        if(bus instanceof ExpressBus){
            switch(bus.getCurrentStop()){
                case 0:
                case 29:
                case 28:
                case 14:
                case 15:
                    time += 0;
                    //stops that are one away, does nothing
                    break;
                case 1:
                    time += 2*240;
                    //stop that is three away, adds 2*240
                    break;
                case 12:
                    time += 240;
                    //stop that is two away, adds 1*240
                    break;
                default:
                    time += (3*240);
                    //stops that are four away, adds 3*240
                    break;
            }
        }
        //assigns inter-stop time for express buses, switch statement for each stop

        if(bus instanceof ExpressBus) {
            BusSim.agenda.add(new BusEvent((ExpressBus) bus, true), time);
        }
        else{
            BusSim.agenda.add(new BusEvent(bus), time);
        }
        //splits scheduling for normal and express buses

        Statistics.totalStops++;
        Statistics.ridersAfterStop += bus.getCurrentPassengers();
        //adjusts pickup statistics
    }
}