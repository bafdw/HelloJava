package be.avondschool.fdw.hellojava.innerclasses.localandanonymousclasses;

import org.junit.Test;
import be.avondschool.fdw.hellojava.innerclasses.iterator.Person;

public class Voorbeeld {
    @Test
    public void main() {
        Person man1 = new Person();         man1.setName("John");
        Person woman1 = new Person();       woman1.setName("Jane");
        Person woman2 = new Person();       woman2.setName("Mia");

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

