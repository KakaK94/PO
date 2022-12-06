package agh.ics.oop;

enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;


    public String toString() {
        return switch (MapDirection.this) {
            case NORTH -> "PÓLNOC";
            case SOUTH -> "POLUDNIE";
            case EAST -> "WSCHÓD";
            case WEST -> "ZACHÓD";
        };
    }

    public MapDirection next() {
        return switch (MapDirection.this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case WEST -> NORTH;
        };
    }

    public MapDirection previous() {
        return switch (MapDirection.this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
        };
    }

    public Vector2d toUnitVector() {
        return switch (MapDirection.this) {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case EAST -> new Vector2d(1, 0);
            case WEST -> new Vector2d(-1, 0);
        };
    }
}

