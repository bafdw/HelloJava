package be.avondschool.fdw.hellojava.genericiteit.wildcards;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Voorbeeld {
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

        voegWagenToeAanCollectie(wagens); System.out.println("nieuw aantal: " + wagens.size());
        voegWagenToeAanCollectie(rijtuigen); System.out.println("nieuw aantal: " + rijtuigen.size());
        //voegWagenToeAanCollectie(fietsen); // kan niet
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
    static void voegWagenToeAanCollectie(List<? super Wagen> collectie)
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