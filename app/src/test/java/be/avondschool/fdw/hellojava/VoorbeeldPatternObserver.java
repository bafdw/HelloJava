package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//DZone - Java Zone - The Observer Pattern Using Java 8:
//   https://dzone.com/articles/the-observer-pattern-using-modern-java

public class VoorbeeldPatternObserver {
    @Test public void main(){
        //VoorbeeldZonderObserverPattern.main();
        //Voorbeeld1MetObserverPattern.main();
        //Voorbeeld2MetObserverPattern.main();
        Voorbeeld3MetObserverPattern.main();
    }

    static class VoorbeeldZonderObserverPattern{
        static Component1 component1;
        static Component2 component2;
        static void main(){
            Artikel a = new Artikel();
            component1 = new Component1(a);
            component2 = new Component2();

            a.setNaam("Appel");
            component1.update();
            component2.update();

            a.setNaam("Peer");
            component1.update();
            component2.update();
        }

        static class Artikel {
            private String naam;
            public String getNaam() { return naam; }
            public void setNaam(String naam) { this.naam = naam; }
        }
        static class Component1 {
            private Artikel artikel;
            public Component1(Artikel artikel) {
                this.artikel = artikel; }
            public void update() {
                System.out.println("Component1: nieuwe naam " +
                        artikel.getNaam());
            }
        }
        static class Component2 {
            private int teller;
            public void update() {
                teller++;
                System.out.println("Component2: " +
                        teller + (teller < 2 ? "e" : "de") + " naam");
            }
        }
    }

    static class Voorbeeld1MetObserverPattern {
        static Component1 component1;
        static Component2 component2;
        static void main(){
            Artikel a = new Artikel();
            component1 = new Component1(a);
            component2 = new Component2();
            a.attach(component1);
            a.attach(component2);

            a.setNaam("Appel");
//            component1.update();
//            component2.update();

            a.setNaam("Peer");
//            component1.update();
//            component2.update();
        }

        interface Observer {
            void update();
        }
        static abstract class Subject {
            private List<Observer> observers = new ArrayList<>();
            public void attach(Observer o){
                observers.add(o);
            }
            public void detach(Observer o){
                observers.remove(o);
            }
            public void notifyObservers(){

                for(Observer o: observers) o.update();
            }
        }
        static class Artikel extends Subject {
            private String naam;
            public String getNaam() { return naam; }
            public void setNaam(String naam) {
                this.naam = naam;
                notifyObservers();
            }
        }
        static class Component1 implements Observer {
            private Artikel artikel;
            public Component1(Artikel artikel) { this.artikel = artikel; }
            @Override public void update() {
                System.out.println("Component1: nieuwe naam " + artikel.getNaam());
            }
        }
        static class Component2 implements Observer {
            private int teller;
            @Override public void update() {
                teller++;
                System.out.println("Component2: " + teller + (teller < 2 ? "e" : "de") + " naam");
            }
        }
    }

    static class Voorbeeld2MetObserverPattern {
        static Component1 component1;
        static Component2 component2;
        static void main(){
            Artikel a = new Artikel();
            component1 = new Component1(); //new Component1(a);
            component2 = new Component2();
            a.attach(component1);
            a.attach(component2);

            a.setNaam("Appel");
            a.setNaam("Peer");
        }

        interface Observer {
            public void update(Subject subject);
        }
        static abstract class Subject {
            private List<Observer> observers = new ArrayList<>();
            public void attach(Observer o){
                observers.add(o);
            }
            public void detach(Observer o){
                observers.remove(o);
            }
            public void notifyObservers(Subject subject){
                for(Observer o: observers) o.update(subject);
            }
        }
        static class Artikel extends Subject {
            private String naam;
            public String getNaam() { return naam; }
            public void setNaam(String naam) {
                this.naam = naam;
                notifyObservers(this); // source nu meegegeven
            }
        }
        static class Component1 implements Observer {
            //private Artikel artikel;
            //public Component1(Artikel artikel) { this.artikel = artikel; }
            @Override public void update(Subject artikel) {
                System.out.println("Component1: nieuwe naam " +
                        ((Artikel)artikel).getNaam());
            }
        }
        static class Component2 implements Observer {
            private int teller;
            @Override public void update(Subject artikel) {
                teller++;
                System.out.println("Component2: " +
                        teller + (teller < 2 ? "e" : "de") + " naam");
            }
        }
    }

    static class Voorbeeld3MetObserverPattern {
        static void main(){
            Artikel a = new Artikel();
            a.attach(new Observer() {
                @Override
                public void update(Subject artikel) {
                    System.out.println("Component1: nieuwe naam " +
                            ((Artikel)artikel).getNaam());
                }
            });
            a.attach(new Observer() {
                private int teller;
                @Override
                public void update(Subject artikel) {
                    teller++;
                    System.out.println("Component2: " +
                            teller + (teller < 2 ? "e" : "de") + " naam");
                }
            });
            //of voor de eerste attach call nog eenvoudiger:
            a.attach(artikel -> System.out.println("Component1: nieuwe naam " + ((Artikel)artikel).getNaam()));

            a.setNaam("Appel");
            a.setNaam("Peer");
        }

        interface Observer {
            public void update(Subject subject);
        }
        static abstract class Subject {
            private List<Observer> observers = new ArrayList<>();
            public void attach(Observer o){
                observers.add(o);
            }
            public void detach(Observer o){
                observers.remove(o);
            }
            public void notifyObservers(Subject subject){
                for(Observer o: observers) o.update(subject);
            }
        }
        static class Artikel extends Subject {
            private String naam;
            public String getNaam() { return naam; }
            public void setNaam(String naam) {
                this.naam = naam;
                notifyObservers(this); // source nu meegegeven
            }
        }
    }
}
