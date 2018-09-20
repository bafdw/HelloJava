package be.avondschool.fdw.hellojava.constructoren;

import org.junit.Test;

public class Voorbeeld {
    @Test public void main(){
        Manager m = new Manager("Jan");
        System.out.println(m.getNaam());
    }
}
class Werknemer {
    public Werknemer(String naam){
        setNaam(naam);
        System.out.println("Werknemer.Ctor");
    }

    private String naam;
    public String getNaam() { return naam; }
    public void setNaam(String naam) { this.naam = naam; }
}
class Manager extends Werknemer {
    public Manager(String naam){
        super(naam);
        System.out.println("Manager.Ctor");
    }
}