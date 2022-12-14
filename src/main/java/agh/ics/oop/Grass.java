package agh.ics.oop;

public class Grass implements IMapElement {

    public final Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    public String toString() {
        return "*";
    }

    public Vector2d getPosition() {
        return position;
    }

    public boolean collides() {
        return false;
    }
}
