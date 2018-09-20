package be.avondschool.fdw.hellojava.enumerations;

import org.junit.Test;

//In plaats van een eenvoudige enum declaratie als:
//enum Direction { NORTH, EAST, SOUTH, WEST }

//Kunnen we ook state en behaviour toevoegen:
enum Direction {
    //calls naar de private constructor
    NORTH(false), EAST(true), SOUTH(false), WEST(true);

    //een extra finale horizontalDirection status wordt aan een Direction instantie toegevoegd
    private final boolean horizontalDirection;
    private Direction(boolean horizontal){
        horizontalDirection = horizontal;
    }

    public boolean IsHorizontal() { return horizontalDirection; }
}

public class Voorbeeld {
    private Direction someDirection;
    @Test public void main() {
        System.out.println(someDirection == null); // true
        someDirection = Direction.NORTH;

        System.out.println(someDirection.IsHorizontal()); // false

        for (Direction d: Direction.values()) // NORTH EAST SOUTH WEST
            System.out.print(d + " ");
        System.out.println();

        Direction d2 = Direction.valueOf("SOUTH");
        System.out.print(d2); // SOUTH
    }
}
