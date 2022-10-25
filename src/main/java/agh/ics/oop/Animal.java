package agh.ics.oop;

import java.util.EnumSet;
import java.util.Objects;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;
    Vector2d lowerLeft = new Vector2d(0,0);
    Vector2d upperRight = new Vector2d(4,4);


    public Animal(){
        orientation = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }


    public String toString() {
        return "Zwierze znajduje się w punkcie: " + this.position + ". Jest skierowany na " + this.orientation;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {

        if(this.position.precedes(upperRight) && this.position.follows(lowerLeft)){
           switch (direction) {
               case RIGHT -> this.orientation = this.orientation.next();
               case LEFT -> this.orientation = this.orientation.previous();
               case FORWARD -> this.position = this.position.add(this.orientation.toUnitVector());
               case BACKWARD -> this.position = this.position.subtract(this.orientation.toUnitVector());
           };
       }
    }
}

