package uk.reading.ac.uk.spink.drone;

public class Main {

    public static void main(String[] args) {
        Drone d1 = new Drone(1,1);
        d1.ID = 1;

        System.out.println(d1.isHere(2,1));

        System.out.println(d1.toString());

        DroneArena d = new DroneArena(10,20);

        d.addDrone();
        d.addDrone(10,10);
        d.addDrone();
        System.out.println(d.toString());
    }
}
