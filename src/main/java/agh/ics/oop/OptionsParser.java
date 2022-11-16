package agh.ics.oop;

import java.util.InputMismatchException;
import java.util.ArrayList;
public class OptionsParser {
    public static ArrayList<MoveDirection> parse(String[] input_directions) {
        ArrayList<MoveDirection> output_directions = new ArrayList<MoveDirection>();
        for (int i = 0; i < input_directions.length; i++) {
            try {
                //disregard case-sensitive
                if(input_directions[i].length()>1){
                    input_directions[i]=input_directions[i].toUpperCase(); }
                if(input_directions[i].length()==1){
                        input_directions[i]=input_directions[i].toLowerCase();
                }
            switch (input_directions[i]) {
                case "f", "FORWARD" -> output_directions.add(MoveDirection.FORWARD);
                case "b", "BACKWARD" -> output_directions.add(MoveDirection.BACKWARD);
                case "l", "LEFT" -> output_directions.add(MoveDirection.LEFT);
                case "r", "RIGHT" -> output_directions.add(MoveDirection.RIGHT);
            };
            }
            catch(InputMismatchException e){
            }
        }
        return output_directions;
    }
}
