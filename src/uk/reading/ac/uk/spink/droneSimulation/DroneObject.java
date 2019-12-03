package uk.reading.ac.uk.spink.droneSimulation;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class DroneObject {
    boolean alive;
    private Node view;
    private Point2D velocity;
    private String name;

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

    public boolean isInBounds(Arena arena) {
        return !(getX() + 20 > arena.getSizeX())
                && !(getY() + 20 > arena.getSizeX())
                && !(getX() - 20 < 0)
                && !(getY() - 20 < 0);
    }

    /**
     * sets the view position to be velocity x,y
     */
    public void update() {
        view.setTranslateX(view.getTranslateX() + velocity.getX());
        view.setTranslateY(view.getTranslateY() + velocity.getY());
    }

    public void rotateAngle(int i) {
        view.setRotate(i);
        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
    }

    public boolean isColliding(DroneObject other) {
        return getView().getBoundsInParent().intersects(other.getView().getBoundsInParent());
    }

    @Override
    public String toString() {

        String s = "DroneObject{" +
                "view=" + view +
                ", velocity=" + velocity +
                ", name='" + name + '\'' +
                '}';
        return s;
    }
}
