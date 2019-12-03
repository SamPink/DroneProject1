package uk.reading.ac.uk.spink.droneSimulation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import uk.reading.ac.uk.spink.droneSimulation.Drones.Drone;
import uk.reading.ac.uk.spink.droneSimulation.Drones.Enemy;

import java.util.Random;

/**
 * Creates simulation UI for drone arena
 */
public class DroneSimulation extends Application {
    Arena arena;
    BorderPane bp;
    Pane simulation;

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
        arena.update(simulation);
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

        arena.addGameObject(new Drone(), 300, 300);
        arena.addGameObject(new Drone(), 300, 200);
        arena.addGameObject(new Drone(), 300, 100);
        arena.addGameObject(new Enemy(), 100, 100);
        arena.moveDrones();

        stage.show();
    }

    private void startSimulation() {
        arena = new Arena();

        simulation = new Pane();

        bp.setCenter(simulation);

        timer.start();
    }

}
