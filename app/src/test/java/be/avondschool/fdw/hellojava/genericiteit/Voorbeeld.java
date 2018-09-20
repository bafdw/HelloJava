package be.avondschool.fdw.hellojava.genericiteit;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Voorbeeld {
    @Test public void main(){
        //ArrayList<E> implements List<E>:
        //"Type parameter" (formeel generisch parametertype) E en
        //onderstaand "type argument" (actueel generisch parametertype) String:
        List<String> lijst1 = new ArrayList<String>();

        //Java naming conventions voor type parameters:
        //- E (elementtype van collectie)
        //- K (key) en V (value) in Map (dictionary) context
        //- N (Number) (basistype primitive wrappers)
        //- T (Type) voor andere contexten
        //- S, U, V, ... (naburige karakters) voor extra type parameters

        //Type arguments kunnen geen primitieve types zijn:
        //List<int> lijst2 = new ArrayList<int>(); // kan niet (compilefout)
        List<Integer> lijst2 = new ArrayList<Integer>(); // kan dan weer wel

        //Diamond syntax (<> zonder type parameter)
        //=> type wordt afgeleid (type inference):
        List<String> lijst3 = new ArrayList<>();

        //Onderstaande Verhoogbaar<T> als voorbeeld van generiek datatype
        Produkt p1 = new Produkt() {{setPrijs(100.0);}};
        Factuurregel fr1 = new Factuurregel() {{setProdukt(p1); setAantal(2);}};
        Factuurregel fr2 = new Factuurregel() {{setProdukt(p1); setAantal(3);}};
        fr1.verhoogMet(fr2);
        System.out.println("aantal fr1 = " + fr1.getAantal()); // 5
        System.out.println("totaalPrijs fr1 = " + fr1.totaalPrijs()); // 500
        Temperatuur t1 = new Temperatuur(){{setGraden(10);}};
        Temperatuur t2 = new Temperatuur(){{setGraden(20);}};
        t1.verhoogMet(t2);
        System.out.println("graden t1 = " + t1.getGraden()); // 30

        //Ook generieke methods kan men definiëren.
        Temperatuur t3 = new Temperatuur(){{setGraden(5);}};
        Temperatuur kleinste = Eerste(t1, t2, t3);
        System.out.println("eerste = " + kleinste.getGraden()); // 5
        System.out.println("eerste = " + Eerste("b;a;c".split(";")));
        //Eerste(new Boek(), new Boek());
        //
        //List<Integer> li = Arrays.asList(1, 2, 3);
        List<Integer> li = new ArrayList<>(); li.add(1); li.add(2); li.add(3);
        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        //
        printLijstV1(li); // kan
        //printLijstV0(li); // kan niet, List<Integer> is geen afgeleide van List<Object>
        //
        System.out.println("sum = " + sumOfList(li));
        System.out.println("sum = " + sumOfList(ld));
    }

    //Met een (upper-bounded) type parameter (T extends ...):
    //extends kan hier zowel wijzen op "erft over van" als "implementeert":
    static <T extends Comparable<T>> T Eerste(T... reeks){
        if (reeks.length > 0) {
            T eerste = reeks[0];
            for (int index = 1; index < reeks.length; index++)
            {
                T ander = reeks[index];
                if (eerste.compareTo(ander) > 0)
                    eerste = ander;
            }
            return eerste;
        }
        return null;
    }


    static void printLijstV0(List<Object> lijst){
        for (Object elem : lijst)
            System.out.println(elem + " ");
        System.out.println();
    }
    //Unbounded wildcard:
    static void printLijstV1(List<?> lijst) {
        for (Object elem: lijst)
            System.out.print(elem + " ");
        System.out.println();
    }
    // kan ook als: static <T> void printLijstV1(List<T> lijst) {
    //                  for (T elem: lijst) ...

    //Met een (upper-bounded) wildcard (?):
    static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
    //kan ook als: static <T extends Number> double sumOfList(List<T> list) {...
}

interface Verhoogbaar<T> {
    void verhoogMet(T value);
}

class Boek /* implements Comparable<Boek> */ {
//    @Override
//    public int compareTo(@NonNull Boek boek) {
//        return 0;
//    }
}

class Temperatuur implements Verhoogbaar<Temperatuur>, Comparable<Temperatuur> {
    private double graden;
    public double getGraden() { return graden; }
    public void setGraden(double graden) { this.graden = graden; }

    @Override
    public void verhoogMet(Temperatuur t) {
        this.setGraden(this.getGraden() + t.getGraden());
    }

    @Override
    public int compareTo(Temperatuur temperatuur) {
        return Double.valueOf(getGraden()).compareTo(temperatuur.getGraden());
    }
}

class Produkt {
    private String naam;
    public String getNaam() { return naam; }
    public void setNaam(String naam) { this.naam = naam; }

    private double prijs;
    public double getPrijs() { return prijs; }
    public void setPrijs(double prijs) { this.prijs = prijs; }
}
class Factuurregel implements Verhoogbaar<Factuurregel> {
    private Produkt produkt;
    public Produkt getProdukt() { return produkt; }
    public void setProdukt(Produkt produkt) { this.produkt = produkt; }

    private int aantal;
    public int getAantal() { return aantal; }
    public void setAantal(int aantal) { this.aantal = aantal; }

    public double totaalPrijs(){ return getProdukt().getPrijs() * aantal; }

    @Override
    public void verhoogMet(Factuurregel regel) {
        this.setAantal(this.getAantal() + regel.getAantal());
    }
}