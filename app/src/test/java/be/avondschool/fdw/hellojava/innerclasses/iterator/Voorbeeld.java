package be.avondschool.fdw.hellojava.innerclasses.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Voorbeeld {
    @Test public void main() {
        Person man1 = new Person();    man1.setName("John");
        Person woman1 = new Person();  woman1.setName("Jane");
        Person woman2 = new Person();  woman2.setName("Mia");

        People1 people1 = new People1();
        people1.addMan(man1);
        people1.addWoman(woman1);
        people1.addWoman(woman2);

        for (Person item : people1)
            System.out.print(item.getName() + " ");
        System.out.println();

        Print(people1);

        People2 people2 = new People2();
        people2.addMan(man1);
        people2.addWoman(woman1);
        people2.addWoman(woman2);

        Print(people2);
    }
    static void Print(Iterable<Person> people){
        Iterator<Person> items = people.iterator();
        while (items.hasNext()) {
            Person item = items.next();
            System.out.print(item.getName() + " ");
        }
        System.out.println();
    }
}

