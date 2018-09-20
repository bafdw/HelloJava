package be.avondschool.fdw.hellojava.switchfallthrough;

import org.junit.Test;
import java.util.ArrayList;

public class Voorbeeld {
    @Test
    public void main() {
        ArrayList<String> maandNamen = maandNamen();
        maandNamen.forEach(e -> System.out.print(e + " ")); // oktober november december
    }

    static ArrayList<String> maandNamen() { return maandNamen(1); }
    static ArrayList<String> maandNamen(int startMaand) {
        ArrayList<String> maandNamen = new ArrayList<String>(12 - startMaand + 1);
        switch (startMaand)
        {
            case 1: maandNamen.add("januari");
            case 2: maandNamen.add("februari");
            case 3: maandNamen.add("maart");
            case 4: maandNamen.add("april");
            case 5: maandNamen.add("mei");
            case 6: maandNamen.add("juni");
            case 7: maandNamen.add("juli");
            case 8: maandNamen.add("augustus");
            case 9: maandNamen.add("september");
            case 10: maandNamen.add("oktober");
            case 11: maandNamen.add("november");
            case 12: maandNamen.add("december"); break;
            default: throw new IllegalArgumentException("Voor de startMaand parameter wordt een waarde van 1 tot en met 12 verwacht.");
        }
        return maandNamen;
    }
}