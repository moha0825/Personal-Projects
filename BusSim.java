//
public class BusSim {

    public static PQ agenda = new PQ();
    public static Stop[] stops = new Stop[30];
    //static priority queue and an array of Stops

    public static void main(String[] args) {
        double[][] avgWait = new double[Parameters.busQuantity][Parameters.busQuantity];
        double[][] avgCapacity = new double[Parameters.busQuantity][Parameters.busQuantity];
        double[][] maxWait = new double[Parameters.busQuantity][Parameters.busQuantity];
        double[][] avgQueueLength = new double[Parameters.busQuantity][Parameters.busQuantity];
        //set of arrays to store statistics from the series of bus simulations

        for(int j = 1; j < Parameters.busQuantity+1; j++)
            for(int k = 0; k < j; k++) {
                Parameters.initBusNum = j -k;
                Parameters.initExpressNum = k;
                //assigns number of express and regular buses

                for (int i = 0; i < stops.length; i++) {
                    stops[i] = new Stop(i);
                }
                //generates stops and places into static array

                RiderEvent RiderMaker = new RiderEvent(0);
                agenda.add(RiderMaker, 0);
                //makes the singular RiderMaker

                int totalBuses = Parameters.initExpressNum + Parameters.initBusNum;
                BusEvent[] bus = new BusEvent[totalBuses];
                for (int i = 0; i < totalBuses; i++) {
                    if (i < Parameters.initBusNum) {
                        bus[i] = new BusEvent(new Bus(0, i + 1));
                        agenda.add(bus[i], 100 * i);
                    } else {
                        bus[i] = new BusEvent(new ExpressBus(0, i + 1));
                        agenda.add(bus[i], 100 * i);
                    }
                }
                //creates the specified number of buses and divides between express and regular

                while (agenda.getCurrentTime() < Parameters.simulationTime) {
                    agenda.remove().run();
                }
                //runs agenda items from the PQ until simulation time is reached

                double totalqueued = 0;
                for(int i = 0; i < stops.length; i++){
                    totalqueued+=stops[i].numPassengers();
                }
                double avgLength = totalqueued/stops.length;
                //computes average queue length


                System.out.println("\nExpress Buses: " + Parameters.initExpressNum + "  Regular Buses: " + Parameters.initBusNum);
                System.out.println("Riders arrive in the system every " + Parameters.riderRate + " seconds");

                System.out.print("Average Bus Capacity: ");
                System.out.println((Statistics.ridersAfterStop / Statistics.totalStops) + " riders");
                avgCapacity[j-1][k] = (Statistics.ridersAfterStop / Statistics.totalStops);

                System.out.print("Average Wait Time: ");
                System.out.println((Statistics.totalWaitTime / Statistics.ridersTotal) + " seconds");
                avgWait[j-1][k] = (Statistics.totalWaitTime / Statistics.ridersTotal);

                System.out.print("Average Queue Length: ");
                System.out.println(avgLength + " Riders");
                avgQueueLength[j-1][k] = avgLength;

                System.out.print("Max Wait Time: ");
                System.out.println(Statistics.maxWaitTime + " seconds\n");
                maxWait[j-1][k] = Statistics.maxWaitTime;
                //statistics summary for each bus composition simulation, writes into array

                agenda = new PQ();
                Statistics.maxWaitTime = 0;
                Statistics.ridersTotal = 0;
                Statistics.totalStops = 0;
                Statistics.ridersAfterStop = 0;
                Statistics.totalWaitTime = 0;
                //resets all statistics and the PQ for another simulation run
            }
        System.out.println("\n\nMax Wait Time:");
        for(int i = 0; i < maxWait.length; i++) {
            System.out.print(i+1+ " Buses Total \t");
            for (int j = 0; j < maxWait[i].length; j++) {
                if (maxWait[i][j] == 0)
                    System.out.print(0+"\t");
                else
                    System.out.print((int)maxWait[i][j]+"\t");

            }
           System.out.println();
        }
        System.out.println("Express Buses: \t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t");
        //table of max wait times

        System.out.println("\n\nAverage Utilized Capacity:");
        for(int i = 0; i < avgCapacity.length; i++) {
            System.out.print(i+1+ " Buses Total \t");
            for (int j = 0; j < avgCapacity[i].length; j++) {
                if (avgCapacity[i][j] == 0)
                    System.out.print(0+"\t");
                else
                    System.out.print((int)avgCapacity[i][j]+"\t");

            }
            System.out.println();
        }
        System.out.println("Express Buses: \t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t");
        //table of average bus capacities used

        System.out.println("\n\nAverage Queue Length:");
        for(int i = 0; i < avgQueueLength.length; i++) {
            System.out.print(i+1+ " Buses Total \t");
            for (int j = 0; j < avgQueueLength[i].length; j++) {
                if (avgQueueLength[i][j] == 0)
                    System.out.print(0+"\t");
                else
                    System.out.print((int)avgQueueLength[i][j]+"\t\t");

            }
            System.out.println();
        }
        System.out.println("Express Buses: \t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t");
        //table of average queue lengths at the end of the simulation

        System.out.println("\n\nAverage Wait Time:");
        for(int i = 0; i < avgWait.length; i++) {
            System.out.print(i+1+ " Buses Total \t");
            for (int j = 0; j < avgWait[i].length; j++) {
                if (avgWait[i][j] == 0)
                    System.out.print(0+"\t");
                else
                    System.out.print((int)avgWait[i][j]+"\t");

            }
            System.out.println();
        }
        System.out.println("Express Buses: \t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t");
        //table of average wait times for the simulation

        //prints out all relevant statistics in table format
    }

}