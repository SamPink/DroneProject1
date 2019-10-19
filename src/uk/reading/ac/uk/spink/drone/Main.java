package uk.reading.ac.uk.spink.drone;

import org.json.simple.JSONObject;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        DroneArena d = new DroneArena(10,10);
        ConsoleCanvas c = new ConsoleCanvas(d.getSizeX(), d.getSizeY());
        ArenaStorage store = new ArenaStorage();

        for (int i = 0; i < 90; i++){
            d.addDrone();
        }

        d.moveAllDrones(d);

        JSONObject jo = store.objectToJson(d);
        if(jo != null){
            store.writeToFile(jo, "file");
        }else{
            System.out.println("File invalid");
        }
    }
}
