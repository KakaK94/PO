package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    //    protected List<IMapElement> entities = new ArrayList<>();
    public Map<Vector2d, IMapElement> entities = new HashMap<>();

    protected boolean isInBounds(Vector2d position) {
        return true;
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    public boolean canMoveTo(Vector2d position) {

        IMapElement element = (IMapElement) objectAt(position);

        return isInBounds(position) && (!isOccupied(position) || (
                element != null && !element.collides()));
    }

    public Vector2d lowerLeft() {
        return new Vector2d(0, 0);
    }

    abstract public Vector2d upperRight();

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(lowerLeft(), upperRight());
    }

    public Object objectAt(Vector2d position) {
        return entities.get(position);
    }

    public boolean place(Animal animal) throws IllegalArgumentException {
        IMapElement below = this.entities.get(animal.getPosition());

        if (canMoveTo(animal.getPosition())) {
            if (below != null)
                this.walkOver((IMapElement) below);

            animal.addObserver(this);
            this.entities.put(animal.getPosition(), animal);
            return true;
        }
        throw new IllegalArgumentException("Cannot place animal on top of another animal");
    }

    public void walkOver(IMapElement element){};

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = this.entities.get(oldPosition);
        this.entities.remove(oldPosition);
        this.entities.put(newPosition, element);
    }
}
