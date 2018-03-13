package be.avondschool.fdw.hellojava;

import org.junit.Test;

class VoorbeeldConstructoren {
    @Test public void main(){
        Manager s = new Manager("Jan");
        System.out.println(s.getNaam());
    }
}
class Werknemer {
    public Werknemer(String naam){ setNaam(naam); }
    private String naam;
    public String getNaam() { return naam; }
    public void setNaam(String naam) { this.naam = naam; }
}
class Manager extends Werknemer {
    public Manager(String naam){
        super(naam);
        System.out.println("ldskfjl");
    }
}
//Ipv C# constructie:
//  class Werknemer
//  {
//      public Werknemer(string naam) { Naam = naam; }
//      public string Naam { get; set; }
//  }
//  class Manager : Werknemer
//  {
//      public Manager(string naam) : base(naam) { }
//  }
