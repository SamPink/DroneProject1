package uk.reading.ac.uk.spink.drone;

import java.util.Random;

public enum Direction {
    North,
    South,
    East,
    West;

    public static Direction getRandom(){
        Random r = new Random();
        return values()[r.nextInt(values().length)];
    }
}
