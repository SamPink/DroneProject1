package uk.reading.ac.uk.spink.drone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DroneArena {
    int sizeX;

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    int sizeY;

    List<Drone> drones = new ArrayList<Drone>();

    public DroneArena(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
    }

    public void addDroneMiddle(){
        Drone d1 = new Drone(this.sizeX/2, this.sizeY/2);
        drones.add(d1);
    }

    public void addDrone(){
        Random r1 = new Random();
        int xPosition = r1.nextInt(this.sizeX)+1;
        int yPosition = r1.nextInt(this.sizeY)+1;
        if(getDroneAt(xPosition, yPosition) == null
                && xPosition < this.sizeX-1 && yPosition < this.sizeY-1){
            Drone d1 = new Drone(xPosition, yPosition);
            drones.add(d1);
        }else{
             System.out.println("Done already exists here");
        }
    }

    public void addDrone(int x, int y){
        if(getDroneAt(x, y) == null){
            Drone d1 = new Drone(x, y);
            drones.add(d1);
        }else{
            System.out.println("Done already exists here");
        }
    }

    public String toString(){
        String s;
        s = "The drone area is "+this.sizeX+","+this.sizeY;
        for (int i = 0; i <drones.size() ; i++) {
            s+= "\n\t Drone "+i+" is at "+drones.get(i).positionX+","+drones.get(i).positionY;
        }
        s+="\n";

        return s;
    }

    public Drone getDroneAt(int x, int y){
        for (Drone n:drones) {
            if(n.isHere(x,y)){
                return n;
            }
        }
        return null;
    }

    public void showDrones( ConsoleCanvas c){
        for (Drone d:drones) {
            d.displayDrone(c);
        }
    }
}
