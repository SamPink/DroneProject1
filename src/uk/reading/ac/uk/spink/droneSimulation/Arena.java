package uk.reading.ac.uk.spink.droneSimulation;

import javafx.scene.layout.Pane;
import uk.reading.ac.uk.spink.droneSimulation.Drones.Drone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int sizeX, SizeY;

    private List<DroneObject> drones = new ArrayList<>();

    /**
     * Constructor
     *
     * @param sizeX length of
     * @param sizeY
     */
    public Arena(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.SizeY = sizeY;
    }

    public Arena() {
        this.sizeX = 600;
        this.SizeY = 600;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return SizeY;
    }

    public void setSizeY(int sizeY) {
        SizeY = sizeY;
    }

    public List<DroneObject> getDrones() {
        return drones;
    }

    public void setDrones(List<DroneObject> drones) {
        this.drones = drones;
    }

    public void addDrone() {
        Drone d = new Drone();
        drones.add(d);
    }

    void addGameObject(DroneObject object, double x, double y) {
        object.getView().setTranslateX(x);
        object.getView().setTranslateY(y);
        drones.add(object);
    }

    public void update(Pane root) {
        root.getChildren().clear();

        for (DroneObject d : drones) { //loop through drones to check on bounds
            if (!d.isInBounds(this)) {
                d.rotateAngle((int) (d.getView().getRotate() + 90));//if not in bounds rotate 90 degrees
                d.update();
            }
            for (DroneObject dr : drones) {//loop through each drone again to check collisions
                if (!dr.equals(d) && dr.isColliding(d)) {// of drone is not current drone
                    d.rotateAngle((int) (d.getView().getRotate() + 90));// turn 90 degrees
                    d.setVelocity(d.getVelocity().multiply(2));
                    d.update();
                }
            }
            root.getChildren().add(d.getView());
            d.update();
        }
    }

    public void moveDrones() {
        for (DroneObject drone : drones) {
            Random r = new Random();
            drone.rotateAngle(r.nextInt(360));
        }
    }

    @Override
    public String toString() {
        return "Arena{" +
                "sizeX=" + sizeX +
                ", SizeY=" + SizeY +
                ", drones=" + drones +
                '}';
    }
}