package uk.reading.ac.uk.spink.drone;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        DroneArena d = new DroneArena(10,20);
        ConsoleCanvas c = new ConsoleCanvas(10, 20);

        for (int i = 0; i < 3; i++) {
            d.addDrone();
        }

        System.out.println(d.toString());
        d.showDrones(c);
        System.out.println(c.toString());

        d.showDrones(c);
        d.moveAllDrones(d);
        d.showDrones(c);
    }
}
