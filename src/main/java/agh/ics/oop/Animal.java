package agh.ics.oop;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;

    Vector2d lowerLeft = new Vector2d(0, 0);
    Vector2d upperRight = new Vector2d(4, 4);


    public Animal() {
        orientation = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }
    public String toString() {
        return "Zwierze znajduje się w punkcie: " + this.position + ". Jest skierowany na " + this.orientation;
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void setPosition(Vector2d position){
        if (position.follows(lowerLeft) && position.precedes(upperRight)) {
             this.position=position;
        }
    }

    public Vector2d getPosition(){              //needed for a test
        return position;
    }

    public MapDirection getOrientation(){       //needed for a test
        return orientation;
    }
    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> setPosition(position.add(this.orientation.toUnitVector()));
            case BACKWARD -> setPosition(position.subtract(this.orientation.toUnitVector()));
            }
        }

    }
