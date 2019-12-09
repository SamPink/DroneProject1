package uk.reading.ac.uk.spink.droneSimulation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import uk.reading.ac.uk.spink.droneSimulation.Drones.Drone;
import uk.reading.ac.uk.spink.droneSimulation.Drones.Enemy;
import uk.reading.ac.uk.spink.droneSimulation.Drones.ImageDrone;
import uk.reading.ac.uk.spink.droneSimulation.Drones.LongDrone;

import java.util.Random;

/**
 * Creates simulation UI for drone arena
 */
public class DroneSimulation extends Application {
    Arena arena;
    BorderPane bp;
    Pane simulation;
    GraphicsContext gc;

    /**
     * Creates animation timer
     */
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            onUpdate();
        }
    };

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * called on every frame
     */
    private void onUpdate() {
        //arena.update(simulation);
        gc.clearRect(0,0,512,520);
        arena.getDrones().forEach(droneObject -> droneObject.render(gc));
    }

    /**
     * @param stage root stage
     */
    @Override
    public void start(Stage stage) {
        bp = new BorderPane();

        bp.setPrefSize(600, 600);

        Scene scene = new Scene(bp);

        stage.setScene(scene);

        startSimulation();

        HBox hBox = new HBox();
        Button button = new Button("Add drone");
        button.setOnAction((ActionEvent click) -> {
            Random r = new Random();
            arena.addGameObject(new Drone(), r.nextInt(600), r.nextInt(600));
        });
        hBox.getChildren().add(button);
        bp.setTop(hBox);

       // arena.addGameObject(new Drone(), 300, 300);
        //arena.addGameObject(new Enemy(), 100, 100);
        //arena.addGameObject(new LongDrone(), 30,50);
        arena.addGameObject(new ImageDrone("C:\\ImageDrone.png"),300,200 );

       // arena.moveDrones();

        stage.show();
    }

   /* private Node logToScreen() {
        Label label = new Label(arena.logToScreen());

        return label;
    }*/

    private void startSimulation() {
        arena = new Arena();

        Canvas canvas = new Canvas( 512, 512 );


        gc = canvas.getGraphicsContext2D();

        bp.setCenter(canvas);

        timer.start();
    }

}
