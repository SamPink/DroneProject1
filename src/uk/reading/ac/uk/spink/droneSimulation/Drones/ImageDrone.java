package uk.reading.ac.uk.spink.droneSimulation.Drones;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import uk.reading.ac.uk.spink.droneSimulation.DroneObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageDrone extends DroneObject {
    private Image image;
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;


    public ImageDrone(String s) {
        super(new Rectangle(20, 20), "ImageDrone");
        positionX = 0;
        positionY = 0;
        velocityX = 0;
        velocityY = 0;
        setImage(s);

    }

    public void setImage(Image i)
    {
        image = i;
        width = 30;
        height = 30;
    }

    public void setImage(String filename)
    {
        Image i = null;
        try {
            i = new Image(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Created image");
        setImage(i);
    }

    public void setPosition(double x, double y)
    {
        positionX = x;
        positionY = y;
    }

    public void setVelocity(double x, double y)
    {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y)
    {
        velocityX += x;
        velocityY += y;
    }

    public void update(double time)
    {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(image, 20,20,100,100);
    }

    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX,positionY,width,height);
    }

    public boolean intersects(ImageDrone s)
    {
        return s.getBoundary().intersects( this.getBoundary() );
    }

    public String toString()
    {
        return " Position: [" + positionX + "," + positionY + "]"
                + " Velocity: [" + velocityX + "," + velocityY + "]";
    }
}
