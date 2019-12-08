package uk.reading.ac.uk.spink.droneSimulation.Drones;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import uk.reading.ac.uk.spink.droneSimulation.DroneObject;

public class Enemy extends DroneObject {
    public Enemy() {
        super(new Rectangle(20, 20, Color.RED), "Enemy");
        this.setVelocity(new Point2D(0,2));
    }

    @Override
    public void render(GraphicsContext gc) {

    }
}
