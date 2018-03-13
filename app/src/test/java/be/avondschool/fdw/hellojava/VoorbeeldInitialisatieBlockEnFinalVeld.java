package be.avondschool.fdw.hellojava;

import org.junit.Test;

/**
 * Created by fdw on 27/09/2017.
 */

public class VoorbeeldInitialisatieBlockEnFinalVeld {
    @Test public void main(){
        KlasseA objectA = new KlasseA();
        System.out.println("veldX: " + objectA.getVeldX());
        System.out.println("veldY: " + objectA.getVeldY());

        //Bij eerste gebruik, als
        KlasseB.doeIets(); // of instantiëring: KlasseB test2 = new KlasseB();
        //wordt nog eerst het static initialisatie blok éénmalig uitgevoerd.
        KlasseB.doeIets();
    }
}
class KlasseA {
    private final int veldX = 1; // hier initialiseren
    private int veldY = 2;           // hier initialiseren

    { // dit is een initialisatie blok
        // - deze wordt uitgevoerd na veld-initialisaties
        // - en voor de constructor
        //veldX = 1; // xor hier initialiseren
        veldY = 3; //  or hier initialiseren
    }

    public KlasseA(){
        //veldX = 1; // xor hier initialiseren
        veldY = 4;   //  or hier initialiseren
    }

    public int getVeldX() { return veldX; }
    public int getVeldY() { return veldY; }
}
class KlasseB {
    static {
        System.out.println("voor iets");
    }
    static public void doeIets() { System.out.println("iets"); }
}
