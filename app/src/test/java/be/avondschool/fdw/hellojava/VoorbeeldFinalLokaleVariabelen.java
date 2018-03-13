package be.avondschool.fdw.hellojava;

import org.junit.Test;

public class VoorbeeldFinalLokaleVariabelen {
    @Test public void main(){
        int x = 3;
        int y = 4;
        final int z = x * y;
        //z = 5; // compilefout
        System.out.println("z: " + z);
    }
}
