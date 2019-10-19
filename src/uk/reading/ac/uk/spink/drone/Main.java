package uk.reading.ac.uk.spink.drone;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        DroneArena d = new DroneArena(80,80);
        ConsoleCanvas c = new ConsoleCanvas(d.getSizeX(), d.getSizeY());
        ArenaStorage store = new ArenaStorage();

        for (int i = 0; i < 20; i++) d.addDrone();
        d.moveAllDrones(d);

        store.objectToJson(d);
    }
}
