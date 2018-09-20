package be.avondschool.fdw.hellojava.foreach;

import org.junit.*;

import java.util.ArrayList;

public class Voorbeeld {
    @Test
    public void main() {
        boolean voorwaarde = 5 > 4;

        Assert.assertTrue(voorwaarde);
        int[] getallen = { 10, 20, 30 };
        for (int getal: getallen)
            System.out.print(getal + " ");
    }
}