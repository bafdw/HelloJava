package be.avondschool.fdw.hellojava.comments;

//Enkelvoudige commentaarregel.

/*
    Meervoudige
    commentaar-
    regel.
*/

public class Voorbeeld {
    /**
     * Returns an Coordinate object that has offsetted X and Y values.
     * The offset arguments are {@link int} values.
     * <p>
     * The returned Coordinate object is not the same as the Coordinate argument.
     * @param  coord   a Coordinate object to base the copy upon
     * @param  xOffset offset used for the X position
     * @param  yOffset offset used for the Y position
     * @return         copy with the offsetted X and Y values
     * @see            Coordinate
     */
    public Coordinate offsetCopy(Coordinate coord, int xOffset, int yOffset) {
        Coordinate copy = new Coordinate();
        copy.setX(coord.getX() + xOffset);
        copy.setY(coord.getY() + yOffset);
        return copy;
    }
}

class Coordinate {
    private int x;
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    private int y;
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}