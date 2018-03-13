package be.avondschool.fdw.hellojava;

import org.junit.Test;

public class VoorbeeldPrimitiveWrappers {

    @Test public void main() {
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
        String o = String.valueOf(123);     // conversie naar string
    }

    private static void geenCastsVereist() {
        Integer x = 123;
        Integer y = x * 2; // geen cast vereist
        System.out.println("y: " + y);

        //In C# wel vereist:
        //  Object box = 123;
        //  //Console.WriteLine(box * 2);    // compilefout
        //  Console.WriteLine((int)box * 2); // met cast
    }
}
