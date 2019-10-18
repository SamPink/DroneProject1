package uk.reading.ac.uk.spink.drone;

public class Drone {
    int positionX;
    int positionY;

    int ID;
    Direction direction;

    //Drone constructor
    public Drone(int x, int y, Direction d){
        this.positionX = x;
        this.positionY = y;
        this.direction = Direction.getRandom();
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
        return "Drone " + this.ID +
                " is at " + this.positionX +" X and " +this.positionY +" Y"+
                " and is facing";
    }

    public void displayDrone(ConsoleCanvas c){
        c.showIt(this.positionX, this.positionY, "d");
    }

}
