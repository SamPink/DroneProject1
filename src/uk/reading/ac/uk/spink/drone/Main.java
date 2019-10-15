package uk.reading.ac.uk.spink.drone;

public class Main {

    public static void main(String[] args) {
        Drone d1 = new Drone(1,1);
        d1.ID = 1;

        System.out.println(d1.toString());

        System.out.println(d1.isHere());

        DroneArea d = new DroneArea(10,20);
        d.addDrone() ;
        d.addDrone();
        d.addDrone();
        System.out.println(d.toString());
    }
}
