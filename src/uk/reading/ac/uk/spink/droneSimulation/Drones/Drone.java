package uk.reading.ac.uk.spink.droneSimulation.Drones;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import uk.reading.ac.uk.spink.droneSimulation.DroneObject;

public class Drone extends DroneObject {
    public Drone() {
        super(new Circle(20, 20, 20, Color.RED), "Drone");
    }

    @Override
    public void render(GraphicsContext gc) {

    }


}
