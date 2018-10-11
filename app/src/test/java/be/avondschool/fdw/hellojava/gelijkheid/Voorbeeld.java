package be.avondschool.fdw.hellojava.gelijkheid;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

public class Voorbeeld {

    @Test public void main(){
        Persoon p1 = new Persoon() {{setNaam("Jan");}};
        Persoon p2 = p1;
        Persoon p3 = new Persoon() {{setNaam("Jan");}};

        System.out.println(p1 == p2); // true
        System.out.println(p1 == p3); // false
        System.out.println(p1.equals(p3)); // true

        ArrayList<Persoon> collectionX = new ArrayList<Persoon>(); collectionX.add(p1);
        System.out.println(collectionX.contains(p1)); // true
    }
}
class Persoon {
    private String naam;
    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoon)) return false;
        Persoon persoon = (Persoon) o;
        return getNaam().equals(persoon.getNaam());
    }

    @Override
    public int hashCode() {
        return getNaam().hashCode();
    }
}
