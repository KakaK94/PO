package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void run(String[] direction){
        System.out.println("Zwierzak idzie do przodu");
        for(int i=0; i<direction.length; i++) {
            String message = switch (direction[i]) {
                case "FORWARD" -> "Zwierzak idzie do przodu";
                case "BACKWARD" -> "Zwierzak idzie do tyłu";
                case "RIGHT" -> "Zwierzak skręca w prawo";
                case "LEFT" -> "Zwierzak skręca W lewo";
                default -> "Nieznana komenda. Zwierzak stoi w miejscu";
            };
            out.println(message);
        }
    }

    public static String[] change(String[] input_directions) {
        String[] output_directions = new String[input_directions.length];
        for (int i = 0; i < input_directions.length; i++) {
            switch(input_directions[i]){
                case "f"-> output_directions[i]= String.valueOf(Directions.FORWARD);
                case "b" -> output_directions[i]= String.valueOf(Directions.BACKWARD);
                case "l" ->  output_directions[i]= String.valueOf(Directions.LEFT);
                case "r" ->  output_directions[i]= String.valueOf(Directions.RIGHT);
                default ->output_directions[i]= output_directions[i-1];
            };

        }
        return output_directions;
    }

    public static void main(String[] args){
        String[] input = new String[]{"f","b","r","l","o"} ;  //{'r', 's', 't', 'u', 'v'};
        out.println("System wystartował");
        String[] like_enum = change(input);
        run(like_enum);
        out.println("System zakończył działanie");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println(MapDirection.NORTH.toString());
        System.out.println(MapDirection.SOUTH.toString());
        System.out.println(MapDirection.WEST.toString());
        System.out.println(MapDirection.EAST.toString());
        System.out.println(MapDirection.NORTH.next());
        System.out.println(MapDirection.SOUTH.next());
        System.out.println(MapDirection.WEST.next());
        System.out.println(MapDirection.EAST.next());
        System.out.println(MapDirection.NORTH.previous());
        System.out.println(MapDirection.SOUTH.previous());
        System.out.println(MapDirection.WEST.previous());
        System.out.println(MapDirection.EAST.previous());
        System.out.println(MapDirection.NORTH.toUnitVector());
        System.out.println(MapDirection.SOUTH.toUnitVector());
        System.out.println(MapDirection.WEST.toUnitVector());
        System.out.println(MapDirection.EAST.toUnitVector());
    }
}
