package be.avondschool.fdw.hellojava.parameterarrays;

import org.junit.Test;

public class Voorbeeld {

    @Test public void main(){
        printSom(10,20,30);
        printSom(10,20,30,40);
    }

    public static void printSom(int... getallen) {
        System.out.print(getallen[0]);
        int som = 0;
        for(int i = 1; i < getallen.length; i++) {
            System.out.print("+" + getallen[i]);
            som+=getallen[i];
        }
        System.out.println("=" + som);
    }
}
