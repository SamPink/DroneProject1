package uk.reading.ac.uk.spink.drone;

import javax.swing.*;
import java.util.Random;

public class Drone {
    private int positionX;
    private int positionY;
    private int ID;
    private static int UID;
    Direction direction;

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getUID() {
        return UID;
    }

    public static void setUID(int UID) {
        Drone.UID = UID;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    //Drone constructor
    public Drone(int x, int y, Direction d){
        this.positionX = x;
        this.positionY = y;
        this.direction = d;
        UID++;
        this.ID = UID;
    }

    public Drone(){
    }

    //Checks to see if there is a drone in current location
    boolean isHere(int x, int y){
        return this.positionX == x && this.positionY == y;
    }

    //toString override to display drones location
    public String toString(){
        return "Drone " + this.ID +
                " is at " + this.positionX +","+this.positionY+
                " and is facing " +this.direction;
    }

    //shows location on drone on ConsoleCanvas
    void displayDrone(ConsoleCanvas c){
        c.showIt(this.positionX, this.positionY, "d");
    }

    //try to move drone 1 position in current direction
    boolean tryToMove(DroneArena area){
        int nx = this.positionX;
        int ny = this.positionY;

        //puts the drone in next position
        if(this.direction == Direction.North){
            ny++;
        }else if(this.direction == Direction.East){
            nx++;
        }else if(this.direction == Direction.South){
            ny--;
        }else if(this.direction == Direction.West){
            nx--;
        }

        //looks to see if drone can be moved here
        if(area.canMoveHere(nx, ny)){
            //moves drone to new position
            this.positionX = nx;
            this.positionY = ny;
            return true;
        }else{
            //if drone cant be moved, turn the direction round one
            this.direction = direction.next(this.direction);
            return false;
        }
    }
}
