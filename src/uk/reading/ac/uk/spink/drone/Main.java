package uk.reading.ac.uk.spink.drone;

public class Main {

    public static void main(String[] args) {


        DroneArena d = new DroneArena(10,20);
        ConsoleCanvas c = new ConsoleCanvas(10, 20);

        //for (int i = 0; i < 40; i++) d.addDrone();
        d.addDrone(3,5,Direction.North);
        System.out.println(d.toString());
        d.showDrones(c);
        System.out.println(c.toString());

        //c.showIt(4,3,"d");
       // System.out.println(c.toString());

    }
}
