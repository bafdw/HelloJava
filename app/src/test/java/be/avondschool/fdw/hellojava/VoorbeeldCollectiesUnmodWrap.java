package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Oracle - Java Documentation - The Java Tutorials - Wrapper Implementations:
//   https://docs.oracle.com/javase/tutorial/collections/implementations/wrapper.html
//
//public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> c);
//public static <T> Set<T> unmodifiableSet(Set<? extends T> s);
//public static <T> List<T> unmodifiableList(List<? extends T> list);
//public static <K,V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m);
//public static <T> SortedSet<T> unmodifiableSortedSet(SortedSet<? extends T> s);
//public static <K,V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> m);
public class VoorbeeldCollectiesUnmodWrap {
    @Test public void main(){
        Dag dag1 = new Dag();
        try {
            dag1.toevoegen(new Afspraak(14, "Kapper"));
            dag1.toevoegen(new Afspraak(15, "Boekhouder"));
            //dag1.toevoegen(new Afspraak(14, "Voetbal")); // ReedsEenAfpraakDanException
            System.out.println("Afspraken toegevoegd. -> #" + dag1.aantalAfspraken());
        } catch(ReedsEenAfpraakDanException e) {
            System.out.println("Reeds een afspraak dan.");
        }

        //Onderstaande 2 calls leveren bij (*) een exceptie op:
        dag1.getAfspraken().set(0, new Afspraak(14, "Barbier"));// UnsupportedOperationException
        //dag1.getAfspraken().add(new Afspraak(14, "Voetbal")); // UnsupportedOperationException

        //Bovenstaande 2 calls leveren dat bij (**) niet op:
        System.out.println("Toch afspraak toegevoegd :s -> #" + dag1.aantalAfspraken());
    }
}
class Afspraak {
    public Afspraak(int uur, String omschrijving) {
        this.uur = uur;
        this.omschrijving = omschrijving;
    }

    private final int uur;
    public int getUur() { return uur; }

    private String omschrijving;
    public String getOmschrijving() { return omschrijving; }
    public void setOmschrijving(String omschrijving) { this.omschrijving = omschrijving; }
}
class Dag {
    private List<Afspraak> afspraken = new ArrayList<Afspraak>();
    public int aantalAfspraken() { return afspraken.size(); }
    public void toevoegen(Afspraak afspraak) throws ReedsEenAfpraakDanException {
        if (!OverlaptMetAndere(afspraak))
            afspraken.add(afspraak);
        else
            throw new ReedsEenAfpraakDanException();
    }
    public List<Afspraak> getAfspraken() {
        //return afspraken; // (**)

        //externe manipulatie vermijden door unmod versie op te leveren:
        return Collections.unmodifiableList(afspraken); // (*)
    }
    public boolean OverlaptMetAndere(Afspraak andere){
        for(Afspraak a: afspraken)
            if (a.getUur() == andere.getUur()) return true;
        return false;
    }
}
class ReedsEenAfpraakDanException extends Exception {}