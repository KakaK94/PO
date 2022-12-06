package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private int width;
    private int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected boolean isInBounds(Vector2d position) {
        return position.x >= 0 && position.x < width && position.y >= 0 && position.y < height;
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            entities.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public Vector2d upperRight() {
        return new Vector2d(width, height);
    }

}
