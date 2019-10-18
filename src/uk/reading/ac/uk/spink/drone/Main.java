package uk.reading.ac.uk.spink.drone;

public class Main {

    public static void main(String[] args) {

        DroneArena d = new DroneArena(10,20);
        ConsoleCanvas c = new ConsoleCanvas(10, 20);

        d.addDrone(3,4);
        d.addDrone(5,4);

        d.showDrones(c);
        System.out.println(c.toString());

        //c.showIt(4,3,"d");
       // System.out.println(c.toString());

    }
}
