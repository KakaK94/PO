package agh.ics.oop;

import java.util.HashSet;
import java.util.Set;

public class Animal implements IMapElement {

    private MapDirection orientation;
    private Vector2d position;
    final private AbstractWorldMap map;
    final private Set<IPositionChangeObserver> observers = new HashSet<>();

    Vector2d lowerLeft = new Vector2d(0, 0);
    Vector2d upperRight = new Vector2d(4, 4);

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;

    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public String toString() {
        return switch (orientation) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST -> "E";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void setPosition(Vector2d position) {
        if (position.follows(lowerLeft) && position.precedes(upperRight)) {
            this.position = position;
        }
    }

    public Vector2d getPosition() {              //needed for a test
        return position;
    }

    public MapDirection getOrientation() {       //needed for a test
        return orientation;
    }

    void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();

            default -> {
                Vector2d positionAfter = switch (direction) {
                    case FORWARD -> position.add(orientation.toUnitVector());
                    case BACKWARD -> position.subtract(orientation.toUnitVector());
                    default -> position;
                };

                if(map.canMoveTo(positionAfter)) {
                    positionChanged(position, positionAfter);
                    position = positionAfter;
                }
            }
        }
    }

    public boolean canMoveTo(Vector2d position) {

        IMapElement element = (IMapElement) this.map.objectAt(position);

        return this.map.isInBounds(position) && (!this.map.isOccupied(position) || (
                element != null && !element.collides()));
    }

    @Override
    public boolean collides() {
        return true;
    }
}
