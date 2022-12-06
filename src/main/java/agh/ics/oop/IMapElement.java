package agh.ics.oop;

public interface IMapElement {
    abstract String toString();
    abstract Vector2d getPosition();

     default boolean isAt(Vector2d position) {
        return this.getPosition().equals(position);
    }

    abstract  boolean collides();
}
