package be.avondschool.fdw.hellojava.primitivewrappers.boxingencastvereisten;

import org.junit.Test;

public class Voorbeeld {

    @Test public void main() {
        long l = 123L;
        int  i= (int)l;
        boxing();
        geenCastsVereist();
    }

    static void boxing() {
        Integer i = 123;                    // (auto)boxing
        int j = i;                          // (auto)unboxing
        Integer k = Integer.valueOf(j);     // explicit boxing mag (maar is niet vereist)
        int l = k.intValue();               // explicit unboxing mag (maar is niet vereist)

        Integer m = Integer.valueOf("123"); // expliciete boxing vanuit string

        int n = Integer.parseInt("123"); // conversie vanuit string
        String o = String.valueOf(123);    // conversie naar string
    }

    private static void geenCastsVereist() {
        Integer x = 5;
        Integer y = x * 2; // geen cast vereist
        System.out.println("y: " + y);
    }
}
