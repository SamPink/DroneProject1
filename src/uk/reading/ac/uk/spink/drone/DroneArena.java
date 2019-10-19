package uk.reading.ac.uk.spink.drone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DroneArena {
    int sizeX, sizeY;
    List<Drone> drones = new ArrayList<Drone>();

    public int getSizeX() {
        return sizeX;
    }

    public int maxPossibleDrones() {
        return (getSizeX()-2) * (getSizeY()-2);
    }

    public boolean canAddDrone() {
        if(getDronesCount() < maxPossibleDrones()) {
            return true;
        }else{
            return false;
        }
    }

    public int getDronesCount() {
        return drones.size();
    }

    public int getSizeY() {
        return sizeY;
    }

    public DroneArena(){
       new DroneArena(10,20);
    }

    public DroneArena(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
    }

    public void addDroneMiddle(){
        Drone d1 = new Drone(this.sizeX/2, this.sizeY/2, Direction.getRandom(),this.getDronesCount()+1);
        drones.add(d1);
    }

    public void addDrone(){
        Random r1 = new Random();
        int xPosition = r1.nextInt(this.sizeX)+1;
        int yPosition = r1.nextInt(this.sizeY)+1;

        addDrone(xPosition, yPosition);
    }

    public void addDrone(int x, int y){
        if(getDroneAt(x, y) == null && x < this.sizeX-1 && y < this.sizeY-1){
            Drone d1 = new Drone(x, y, Direction.getRandom(),this.getDronesCount()+1);
            drones.add(d1);
        }else{
            try{
                if(canAddDrone()){
                    addDrone();
                }else{
                    throw new Exception("Arena is full!");
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public String toString(){
        String s;
        s = "The drone area is "+this.sizeX+","+this.sizeY;
        for (int i = 0; i <drones.size() ; i++) {
            s+= "\n\t Drone "+i+" is at "+drones.get(i).positionX+","+drones.get(i).positionY+
                    ", facing "+drones.get(i).direction;
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

    public boolean canMoveHere(int x, int y){
       if( x < this.sizeX-1 && y < this.sizeY-1
               && x != 0 && y != 0
               && getDroneAt(x,y) ==  null){
           return true;
       }else{
           return false;
       }
    }

    public void moveAllDrones(DroneArena area){
        for (Drone d:drones) {
           d.tryToMove(this);
        }
    }

    public void moveAllDrones(DroneArena area, int times){
        for (Drone d:drones) {
            for (int i = 0; i < times; i++) {
                try{
                    d.tryToMove(this);
                }catch (Exception es){
                    es.printStackTrace();
                }
            }
        }
    }

}
