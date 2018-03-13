package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

//Oracle - Java Documentation - The Java Tutorials - Method References:
//   https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

//Oracle - Java Documentation - The Java Tutorials - Default and static Method interface Methods:
//   https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html

public class VoorbeeldMethodReferences {
    @Test public void main(){
        Person man1 = new Person();    man1.setName("John");
        Person woman1 = new Person();  woman1.setName("Jane");
        Person woman2 = new Person();  woman2.setName("Mia");

        List<Person> people = new ArrayList<>();
        people.add(man1);
        people.add(woman1);
        people.add(woman2);

        //In plaats van via een anonieme klasse...
        people.forEach(new Consumer<Person>() {
            @Override public void accept(Person p) {
                System.out.print(p.getName() + " ");
            }
        });
        System.out.println();

        //Of lambda implemenatie te werken...
        people.forEach(p -> System.out.print(p.getName() + " "));
        System.out.println();

        //Kan je, door middel van een "method reference", ook wijzen naar een
        //bestaande (benoemde) method:
        Consumer<Person> action = VoorbeeldMethodReferences::printPerson;
        //Voor de :: staat de klasse-naam, van de klasse waarin de
        //static method is gedefinieerd die wordt vermeld na de ::.
        people.forEach(action);
        System.out.println();

        people.forEach(VoorbeeldMethodReferences::printPerson);

        //Net zo goed kan je verwijzen naar een instance method van een bepaalde
        //instantie, in dat geval in de vorm 'instance-name::instance-method-name'.
    }

    public static void printPerson(Person p) {
        System.out.print(p.getName() + " ");
    }
}