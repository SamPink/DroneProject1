package uk.reading.ac.uk.spink.droneSimulation;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public abstract class DroneObject {
    boolean alive;
    private Node view;
    private Point2D velocity;
    private String name;
    private boolean isColliding = false;

    public DroneObject(Node view, String name) {
        this.view = view;
        this.velocity = new Point2D(0, 1);
        this.name = name;
        this.alive = true;
    }

    public DroneObject() {
        this.view = new Rectangle(40, 20, Color.GREEN);
        this.velocity = new Point2D(0, 1);
        this.name = "Drone";
        this.alive = true;
    }

    public Node getView() {
        return view;
    }

    public void setView(Node view) {
        this.view = view;
    }

    public Point2D getVelocity() {
        return velocity;
    }

    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }

    public boolean getColliding() {
        return isColliding;
    }

    public void setColliding(boolean colliding) {
        if(isColliding){
            System.out.println(this.getName() + " has crashed");
        }
        isColliding = colliding;
    }

    public double getX() {
        return getView().getTranslateX();
    }

    public double getY() {
        return getView().getTranslateY();
    }

    public double getRotate() {
        return view.getRotate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the view position to be velocity x,y
     */
    public void update() {
        view.setTranslateX(view.getTranslateX() + velocity.getX());
        view.setTranslateY(view.getTranslateY() + velocity.getY());
    }

    public void rotateAngle(int i) {
        System.out.println("Rotating" + i);
        view.setRotate(i);
        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
    }

    public void rotateRandom() {
        Random r = new Random();

        rotateAngle(r.nextInt(360));
    }

    public boolean isColliding(Arena arena) {
        Bounds bounds = getView().getBoundsInParent();

        double x = bounds.getMaxX();
        double y = bounds.getMaxY();

        setColliding(false);

        if(x > arena.getSizeX()){
            //right wall
            this.isColliding = true;
        }
        if(x < 0){
            //left wall
            setColliding(true);
        }
        if(y > arena.getSizeY()){
            //top wall
            setColliding(true);
        }
        if(y < 0){
            //bottom wall
            setColliding(true);
        }

        for (DroneObject d: arena.getDrones()) {
            if(!this.equals(d)){
                //not the current drone
                if(getView().getBoundsInParent().intersects(d.getView().getBoundsInParent())){
                    //a drone in the arena intersects with current drone
                    setColliding(true);
                }
            }
        }

       return getColliding();
    }

    public void onCollision() {
        rotateAngle((int) (getView().getRotate() + 90));// turn 90 degrees
        setVelocity(getVelocity().multiply(2));
    }

    @Override
    public String toString() {

        String s = "DroneObject{" +
                "view=" + view +
                ", velocity=" + velocity +
                ", name='" + name + '\'' +
                ", position " + velocity.getX() +
                "," + velocity.getY()+
                '}';
        return s;
    }
}
