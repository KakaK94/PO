package agh.ics.oop;

import java.util.Arrays;

public class SimulationEngine implements IEngine {
    private final IWorldMap map;
    private MoveDirection[] directions;
    public Animal[] entities;

    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map, Vector2d[] positions) {
        this.entities = Arrays.stream(positions)
                .map(p -> new Animal(map, p)).toArray(Animal[]::new);

        Arrays.stream(this.entities).forEach(map::place);

        this.map = map;
        this.directions = directions;
    }

    public void run() {
        System.out.println("Running simulation...");

        int i = 0;
        for(MoveDirection dir : directions)
            entities[i++ % entities.length].move(dir);
    }
}
