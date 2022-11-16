package agh.ics.oop;

import agh.ics.oop.OptionsParser;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class OptionsParserTest {

    @Test
    void testParse(){
        OptionsParser commands = new OptionsParser();
        String[] input = new String[]{"f","o","R","Ro","BACKward","LEFT"};
        ArrayList <MoveDirection> properlyParsed = new ArrayList<>();
        properlyParsed.add(MoveDirection.FORWARD);
        properlyParsed.add(MoveDirection.RIGHT);
        properlyParsed.add(MoveDirection.BACKWARD);
        properlyParsed.add(MoveDirection.LEFT);
        ArrayList <MoveDirection> output = commands.parse(input);

        if(properlyParsed.size()==output.size()){
        for(int i=0; i< properlyParsed.size(); i++){
            assertEquals(properlyParsed.get(i),output.get(i));}}
        else
        System.out.println("ArrayLists have different sizes");
    }
}

//przed wykonaniem ruchu, spawdzenie pozycji drugiego zwierzaka. Jeśli po wykonaniu ruchu zwierzak, który własnie
// ma się ruszyć, znalazłby się na tej samej pozycji, ruch nie zostanie wykonany.