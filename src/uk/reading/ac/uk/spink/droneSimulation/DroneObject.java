package uk.reading.ac.uk.spink.droneSimulation;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public abstract class DroneObject {
    boolean alive;
    private Node view;
    private Point2D velocity;
    int posX,posY,velX,velY;
    private String name;
    private boolean isColliding = false;
    private DroneObject collidingWith;
    private Image image;

    public DroneObject(String name) {
        this.posX = posX;
        this.posY = posY;
        this.velX = 1;
        this.velY = 0;

        this.view = new Rectangle(posX, posY);
        this.velocity = new Point2D(velX, velY);
        this.name = name;
        this.alive = true;
        setImage("c:\\imageDrone.png");
    }

    public DroneObject() {
        this.view = new Rectangle(40, 20, Color.GREEN);
        this.velocity = new Point2D(0, 1);
        this.name = "Drone";
        this.alive = true;
        setImage("c:\\imageDrone.png");
    }

    public void setImage(Image i) {
        image = i;
    }

    public void setImage(String filename) {
        Image i = null;
        try {
            i = new Image(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Created image");
        setImage(i);
    }

    public Node getView() {
        return view;
    }

    public double getRotate() {
        return view.getRotate();
    }

    public void setPos(int x, int y) {
        getView().setTranslateX(x);
        getView().setTranslateY(y);
    }


    public Point2D getVelocity() {
        return velocity;
    }

    public void setVelocity(Point2D velocity) {
        System.out.println("Setting " + this.name + " velocity to " + velocity.toString());

        this.velocity = velocity;
    }

    public boolean getColliding() {
        return isColliding;
    }

    public void setColliding(boolean colliding) {
        if(isColliding){
            System.out.println(this.getName() + " has crashed");
        }
        isColliding = colliding;
    }

    public DroneObject getCollidingWith() {
        return collidingWith;
    }

    public void setCollidingWith(DroneObject collidingWith) {
        this.collidingWith = collidingWith;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the view position to be velocity x,y
     */
    public void update() {
        view.setTranslateX(view.getTranslateX() + velocity.getX());
        view.setTranslateY(view.getTranslateY() + velocity.getY());


    }

    public void rotateAngle(int i) {
        System.out.println("Rotating" + i);
        view.setRotate(i);
        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
    }

    public void rotateRandom() {
        Random r = new Random();

        rotateAngle(r.nextInt(360));
    }

    public boolean isColliding(Arena arena) {
        Bounds boundsInScene = getView().localToScene(getView().getBoundsInLocal());
        double x = boundsInScene.getMaxX();
        double y = boundsInScene.getMaxY();

        setColliding(false);
        setCollidingWith(null);

        if(x > arena.getSizeX() || x < 0 || y > arena.getSizeY() || y < 0){
           setColliding(true);
        }

        for (DroneObject d: arena.getDrones()) {
            if(!this.equals(d)){
                //not the current drone
                if(getView().getBoundsInParent().intersects(d.getView().getBoundsInParent())){
                    //a drone in the arena intersects with current drone
                    setColliding(true);
                    setCollidingWith(d);
                }
            }
        }

       return getColliding();
    }

    public void onCollision() {
       setVelocity(new Point2D(getVelocity().getY(), getVelocity().getX()));

        if(getCollidingWith() != null){
            Point2D velocity = getCollidingWith().getVelocity();
            setVelocity(velocity);
        }
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, getView().getTranslateX(),getView().getTranslateY(),100,100);
    }

    @Override
    public String toString() {

        String s = "DroneObject{" +
                "view=" + view +
                ", velocity=" + velocity +
                ", name='" + name + '\'' +
                ", position " + velocity.getX() +
                "," + velocity.getY()+
                '}';
        return s;
    }
}
