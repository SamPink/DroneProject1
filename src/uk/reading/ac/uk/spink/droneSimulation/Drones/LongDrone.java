package uk.reading.ac.uk.spink.droneSimulation.Drones;

import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import uk.reading.ac.uk.spink.droneSimulation.DroneObject;

public class LongDrone extends DroneObject {
    public LongDrone() {
        super(new Rectangle(20, 50, Color.BLUE), "Long drone");
    }

    @Override
    public void render(GraphicsContext gc) {

    }
}
