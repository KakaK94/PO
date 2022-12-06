package agh.ics.oop;

public class GrassField extends AbstractWorldMap {
    int n;

    public GrassField(int n) {
        super();
        this.n = n;
        for (int i = 0; i < n; i++) {
            growAGrass();
        }
    }

    public void growAGrass() {
        double limit = Math.sqrt(n  * 10);

        while (true) {
            Vector2d position = new Vector2d((int) (Math.random() * limit) , (int) (Math.random() * limit));
            if (!isOccupied(position)) {
                entities.put(position, new Grass(position));
                break;
            }
        }
    }

    public Vector2d lowerLeft() {
        return entities.values().stream().map(IMapElement::getPosition)
                .reduce((a, b) -> a.lowerLeft(b))
                .orElse(new Vector2d(0, 0));
    }

    public Vector2d upperRight() {
        return entities.values().stream().map(IMapElement::getPosition)
                .reduce((a, b) -> a.upperRight(b))
                .orElse(new Vector2d(0, 0));
    }

    public void walkOver(IMapElement element) {
        if (element instanceof Grass) {
            entities.remove(element.getPosition());
            growAGrass();
        }
    }
}
