package be.avondschool.fdw.hellojava.primitivewrappers;

import org.junit.Test;

class Opmeting
{
    private Adres adres;
    public Adres getAdres() {
        return adres;
    }
    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    private Double Temperatuur;
    public Double getTemperatuur() {
        return Temperatuur;
    }
    public void setTemperatuur(Double temperatuur) {
        Temperatuur = temperatuur;
    }
}
class Adres { }

public class Voorbeeld {
    @Test public void main() {
        Opmeting opmeting1 = new Opmeting();
        System.out.println(opmeting1.getTemperatuur() == null); // true
        Print(opmeting1.getTemperatuur());  // Geen temperatuur ingesteld.

        Opmeting opmeting2 = new Opmeting() {{ setTemperatuur(12.3); }};
        Print(opmeting2.getTemperatuur());  // 12.3
    }
    static void Print(Double t) {
        if (t != null)
            System.out.println(t);
        else
            System.out.println("Geen temperatuur ingesteld.");
    }
}