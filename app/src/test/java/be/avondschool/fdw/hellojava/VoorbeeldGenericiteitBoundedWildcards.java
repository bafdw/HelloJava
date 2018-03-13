package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
What is the difference between a wildcard bound and a type parameter bound?

A wildcard can have only one bound, while a type parameter can have
several bounds. A wildcard
can have a lower or an upper bound, while there is no such thing as a
lower bound for a type parameter.

Wildcard bounds and type parameter bounds are often confused, because
they are both called bounds
and have in part similar syntax:

  type parameter bound     T extends Class & Interface1 & … & InterfaceN

  wildcard bound
      upper bound          ? extends SuperType
      lower bound          ? super   SubType

bron: [StackOverflow: Java: bounded wildcards or bounded type parameter?: https://stackoverflow.com/questions/3486689/java-bounded-wildcards-or-bounded-type-parameter]
 */

public class VoorbeeldGenericiteitBoundedWildcards {
    @Test public void main() {
        Wagen wagen1 = new Wagen() {{setBouwjaar(2004);}};
        Wagen wagen2 = new Wagen() {{setBouwjaar(2006);}};
        Fiets fiets1 = new Fiets() {{setBouwjaar(2016);}};
        Fiets fiets2 = new Fiets() {{setBouwjaar(2018);}};

        List<Rijtuig> rijtuigen =
                new ArrayList<Rijtuig>(Arrays.asList(wagen1, fiets1, wagen2, fiets2));
        List<Wagen> wagens = new ArrayList<Wagen>(Arrays.asList(wagen1, wagen2));
        List<Fiets> fietsen = new ArrayList<Fiets>(Arrays.asList(fiets1, fiets2));

        printGemiddeldBouwjaar(rijtuigen);
        printGemiddeldBouwjaar(wagens);
        printGemiddeldBouwjaar(fietsen);

        voegWagenToe(wagens); System.out.println("nieuw aantal: " + wagens.size());
        voegWagenToe(rijtuigen); System.out.println("nieuw aantal: " + rijtuigen.size());
        //voegWagenToe(fietsen); // kan niet
    }
    static void printGemiddeldBouwjaar(List<? extends Rijtuig> collectie)
    {
        int jaartotaal = 0;
        for (Rijtuig item : collectie){
            jaartotaal += item.getBouwjaar();
        }
        int jaargem = jaartotaal / collectie.size();
        System.out.println("Gemiddeld bouwjaar: " + jaargem);
    }
    static void voegWagenToe(List<? super Wagen> collectie)
    {
        collectie.add(new Wagen() {{setBouwjaar(LocalDate.now().getYear());}});
    }
}
class Rijtuig
{
    private int bouwjaar;
    public int getBouwjaar() {
        return bouwjaar;
    }
    public void setBouwjaar(int bouwjaar) {
        this.bouwjaar = bouwjaar;
    }
}
class Wagen extends Rijtuig {}
class Fiets extends Rijtuig {}