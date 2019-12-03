package uk.reading.ac.uk.spink.droneSimulation.Drones;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import uk.reading.ac.uk.spink.droneSimulation.DroneObject;

public class Enemy extends DroneObject {
    public Enemy() {
        super(new Rectangle(20, 20, Color.RED), "Enemy");
        this.goFaster();
    }

    public void goFaster() {
        this.setVelocity(getVelocity().multiply(2));
    }

}
