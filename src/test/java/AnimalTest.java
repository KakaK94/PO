package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class AnimalTest {

    @Test
    void testOrientation() {
        Animal cat = new Animal();                      //orientation and position are hardcoded in the class Animal
        //   System.out.println(kot.toString());
        MoveDirection[] directions = new MoveDirection[]{
                MoveDirection.LEFT,
                MoveDirection.RIGHT,
                MoveDirection.RIGHT,
                MoveDirection.RIGHT};
        MapDirection[] directionsWorldSides = new MapDirection[]{
                MapDirection.WEST,
                MapDirection.NORTH,
                MapDirection.EAST,
                MapDirection.SOUTH};
        for (int i = 0; i < directions.length; i++) {
            cat.move(directions[i]);
            assertEquals(directionsWorldSides[i], cat.getOrientation());
        }
    }

    // testOrientation and testPosition could be merged in one, but I was wondering what is clearer, and more practical
    // when some part of the function changes, and decided to left separated
    @Test
    void testPosition(){
            Animal cat = new Animal();                      //orientation and position are hardcoded in the class Animal
            //   System.out.println(kot.toString());
            MoveDirection[] directions = new MoveDirection[]{
                    MoveDirection.FORWARD,
                    MoveDirection.BACKWARD,
                    MoveDirection.RIGHT,
                    MoveDirection.FORWARD,
                    MoveDirection.BACKWARD,
                    MoveDirection.RIGHT,
                    MoveDirection.FORWARD,
                    MoveDirection.BACKWARD,
                    MoveDirection.RIGHT,
                    MoveDirection.FORWARD,
                    MoveDirection.BACKWARD,
                    MoveDirection.RIGHT
                    };
            for (int i = 0; i < directions.length; i++) {
                cat.move(directions[i]);}
                assertEquals(true, cat.isAt(new Vector2d(2,2)));
                //assertEquals(MapDirection.NORTH, kot.getOrientation());
    }

    @Test
    void testIsInsideMap() {
        Animal catYtop = new Animal();
        Animal catYbottom = new Animal();
        Animal catXright = new Animal();
        Animal catXleft = new Animal();
        MoveDirection[] directionsYtop = new MoveDirection[]{
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD};
        MoveDirection[] directionsYbottom = new MoveDirection[]{
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD};

        for(int i=0; i<directionsYtop.length; i++){
            catYtop.move(directionsYtop[i]);
            catYbottom.move(directionsYbottom[i]);
        }

        assertEquals(new Vector2d(2,4),catYtop.getPosition());
        assertEquals(new Vector2d(2,0),catYbottom.getPosition());

        MoveDirection[] directionsXright = new MoveDirection[]{
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD};
        MoveDirection[] directionsXleft = new MoveDirection[]{
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD};

        for(int i=0; i<directionsXright.length; i++){
            catXright.move(directionsXright[i]);
            catXleft.move(directionsXleft[i]);
        }

        assertEquals(new Vector2d(4,2),catXright.getPosition());
        assertEquals(new Vector2d(0,2),catXleft.getPosition());
    }
}

