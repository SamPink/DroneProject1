package uk.reading.ac.uk.spink.droneSimulation;

import com.sun.jdi.LongValue;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uk.reading.ac.uk.spink.drone.DroneArena;
import uk.reading.ac.uk.spink.droneSimulation.Drones.ImageDrone;


public class DroneGame extends Application {
    Arena arena;
    GraphicsContext gc;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws Exception {
        theStage.setTitle("Drone Game");

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 512, 512 );
        root.getChildren().add( canvas );

        gc = canvas.getGraphicsContext2D();

        arena = new Arena();

        arena.addGameObject(new ImageDrone("C:\\ImageDrone.png"),300,200 );


        AnimationTimer timer = new AnimationTimer() {
            Long lastNanoTime = System.nanoTime();

            @Override
            public void handle(long l) {

                double elapsedTime = (l - lastNanoTime.intValue()) / 1000000000.0;
                lastNanoTime  = (Long) l;

                onUpdate();
            }
        };
        timer.start();

        theStage.show();
    }

    private void onUpdate() {
        gc.clearRect(0,0,512,520);
       arena.getDrones().forEach(droneObject -> droneObject.render(gc));
    }
}
