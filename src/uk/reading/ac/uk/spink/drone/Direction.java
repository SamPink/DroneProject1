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

    public Direction next(Direction direction) {
        if(direction == Direction.North){
            direction = Direction.East;
        }else  if(direction == Direction.East){
            direction = Direction.South;
        }else if(direction == Direction.South){
            direction = Direction.West;
        }else {
            direction = Direction.North;
        }

        return direction;
    }
}
