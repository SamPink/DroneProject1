package uk.reading.ac.uk.spink.drone;

public class Drone {
    int positionX;
    int positionY;

    int ID;
    int Direction;

    //Drone constructor
    public Drone(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }
    public Drone(){

    }

    public boolean isHere(int x, int y){
        return this.positionX == x && this.positionY == y;
    }

    public void displayDrone(){
        //SomeCode
    }

    public String toString(){
        return "Drone " + this.ID + " is at " + this.positionX + " X and " + this.positionY + " Y";
    }

    public void displayDrone(ConsoleCanvas c){
        c.showIt(this.positionX, this.positionY, "d");
    }

}
