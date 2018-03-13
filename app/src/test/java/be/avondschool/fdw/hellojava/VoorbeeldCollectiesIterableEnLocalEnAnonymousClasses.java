package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Oracle - Java Documentation - The Java Tutorials - Inner Classes:
//   https://docs.oracle.com/javase/tutorial/java/javaOO/innerclasses.html
//Oracle - Java Documentation - The Java Tutorials - Anonymous Classes:
//   https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
//Oracle - Java Documentation - The Java Tutorials - Local Classes:
//   https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html

public class VoorbeeldCollectiesIterableEnLocalEnAnonymousClasses {
    @Test
    public void main() {
        Person man1 = new Person();
        man1.setName("John");
        Person woman1 = new Person();
        woman1.setName("Jane");
        Person woman2 = new Person();
        woman2.setName("Mia");

        People3 people3 = new People3();
        people3.addMan(man1);
        people3.addWoman(woman1);
        people3.addWoman(woman2);

        for (Person item : people3)
            System.out.print(item.getName() + " ");
        System.out.println();

        People4 people4 = new People4();
        people4.addMan(man1);
        people4.addWoman(woman1);
        people4.addWoman(woman2);

        for (Person item : people4)
            System.out.print(item.getName() + " ");
        System.out.println();

        //class SpeciaalSoortVanPerson extends

        //Ander voorbeeld van anonieme innerclass:
        Person man2 = new Person() {
            //deze keer een afgeleide van type Person
            //je kan hierin members overschrijven...
            @Override
            public String toString() {
                return "Gespecialiseerde persoon...";
            }
            //members toevoegen kan ook
            //members aan de publieke interface toevoegen is echter
            //weinig zinvol, ze zijn immers niet bereikbaar via het
            //statisch basistype van de backing variabele (bv man2)
        };
        System.out.println("man2: " + man2.toString());
    }


}



//Versie 3: Met local class implementatie.
class People3 implements Iterable<Person> {
    private List<Person> women = new ArrayList<Person>();
    private List<Person> men = new ArrayList<Person>();

    public void addWoman(Person woman) {
        women.add(woman);
    }

    public void addMan(Person man) {
        men.add(man);
    }

    @Override
    public Iterator<Person> iterator() {
        //Local class:
        class People3Iterator implements Iterator<Person> {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < (women.size() + men.size());
            }

            @Override
            public Person next() {
                Person p;
                if (index < women.size())
                    p = women.get(index);
                else
                    p = men.get(index - women.size());
                index++;
                return p;
            }
        }
        return new People3Iterator();
    }
}

//Versie 4: Met anonieme klasse implementatie.
class People4 implements Iterable<Person> {
    private List<Person> women = new ArrayList<Person>();
    private List<Person> men = new ArrayList<Person>();

    public void addWoman(Person woman) {
        women.add(woman);
    }

    public void addMan(Person man) {
        men.add(man);
    }

    @Override
    public Iterator<Person> iterator() {
        return new Iterator<Person>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < (women.size() + men.size());
            }

            @Override
            public Person next() {
                Person p;
                if (index < women.size())
                    p = women.get(index);
                else
                    p = men.get(index - women.size());
                index++;
                return p;
            }
        };
    }
}