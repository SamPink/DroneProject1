package uk.reading.ac.uk.spink.drone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DroneArea {
    int sizeX;
    int sizeY;

    List<Drone> drones = new ArrayList<Drone>();

    public DroneArea(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
    }

    public void addDroneMiddle(){
        Drone d1 = new Drone(this.sizeX/2, this.sizeY/2);
        drones.add(d1);
    }

    public void  addDrone(){
        Random r1 = new Random();
        int xPosition = r1.nextInt(this.sizeX)+1;
        int yPosition = r1.nextInt(this.sizeY)+1;
        Drone d1 = new Drone(xPosition, yPosition);
        drones.add(d1);
    }

    public String toString(){
        String s;
        s = "The drone area is "+this.sizeX+","+this.sizeY;
        for (int i = 0; i <drones.size() ; i++) {
            s+= "\n\t Drone "+i+" is at "+drones.get(i).positionX+","+drones.get(i).positionY;
        }

        return s;
    }
}
