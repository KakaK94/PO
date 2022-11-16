package agh.ics.oop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Vector2dTest {

    @Test
    void testEquals(){
        assertTrue(new Vector2d(1,2).equals(new Vector2d(1,2)));
        assertFalse(new Vector2d(1,2).equals(new Vector2d(1,2)));
    }

    @Test
    void testToString(){
        assertEquals("(1,2)", new Vector2d(1,2).toString());
        assertNotEquals("(2,1)", new Vector2d(1,2).toString());
    }

    @Test
    void testPrecedes(){
        assertTrue(new Vector2d(1,2).precedes(new Vector2d(3,4)));
        assertFalse(new Vector2d(3,4).precedes(new Vector2d(1,2)));
        assertFalse(new Vector2d(1,5).precedes(new Vector2d(2,3)));
        assertFalse(new Vector2d(5,1).precedes(new Vector2d(4,3)));
    }

    @Test
    void testFollows(){
        assertTrue(new Vector2d(3,4).follows(new Vector2d(1,2)));
        assertFalse(new Vector2d(3,2).follows(new Vector2d(1,4)));
        assertFalse(new Vector2d(1,5).follows(new Vector2d(2,3)));
        assertFalse(new Vector2d(1,2).follows(new Vector2d(4,3)));
    }

    @Test
    void testUpperRight(){
        assertEquals(new Vector2d(1,2), new Vector2d(1,2).upperRight(new Vector2d(1,1)));
        assertEquals(new Vector2d(2,2), new Vector2d(2,2).upperRight(new Vector2d(1,1)));
        assertEquals(new Vector2d(2,2), new Vector2d(1,1).upperRight(new Vector2d(2,2)));
        assertNotEquals(new Vector2d(1,2), new Vector2d(2,1).upperRight(new Vector2d(1,1)));
    }

    @Test
    void testLowerLeft(){
        assertEquals(new Vector2d(1,1), new Vector2d(1,2).lowerLeft(new Vector2d(1,1)));
        assertNotEquals(new Vector2d(2,2), new Vector2d(2,2).lowerLeft(new Vector2d(1,1)));
        assertNotEquals(new Vector2d(2,2), new Vector2d(1,1).lowerLeft(new Vector2d(2,2)));
        assertEquals(new Vector2d(3,2), new Vector2d(3,4).lowerLeft(new Vector2d(4,2)));
    }

    @Test
    void testAdd(){
        assertEquals(new Vector2d(1,2), new Vector2d(1,1).add(new Vector2d(0,1)));
        assertNotEquals(new Vector2d(1,1), new Vector2d(1,1).add(new Vector2d(0,1)));
        assertNotEquals(new Vector2d(0,1), new Vector2d(1,1).add(new Vector2d(0,1)));
        assertEquals(new Vector2d(2,6), new Vector2d(3,4).add(new Vector2d(-1,2)));
    }

    @Test
    void testSubtract(){
        assertEquals(new Vector2d(1,0), new Vector2d(1,1).subtract(new Vector2d(0,1)));
        assertNotEquals(new Vector2d(1,1), new Vector2d(1,1).subtract(new Vector2d(0,1)));
        assertNotEquals(new Vector2d(0,1), new Vector2d(1,1).subtract(new Vector2d(0,1)));
        assertEquals(new Vector2d(4,2), new Vector2d(3,4).subtract(new Vector2d(-1,2)));
    }

    @Test
    void testOpposite(){
        assertEquals(new Vector2d(-1,-1), new Vector2d(1,1).opposite());
        assertNotEquals(new Vector2d(1,-1), new Vector2d(1,1).opposite());
        assertNotEquals(new Vector2d(1,1), new Vector2d(1,1).opposite());
        assertEquals(new Vector2d(3,4), new Vector2d(-3,-4).opposite());
    }
}
