package be.avondschool.fdw.hellojava.collecties.set;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import be.avondschool.fdw.hellojava.innerclasses.iterator.Person;

//SortedSet<E>:
//A Set that further provides a total ordering on its elements. The elements
//are ordered using their natural ordering, or by a Comparator typically
//provided at sorted set creation time. The set's iterator will traverse
//the set in ascending element order.

//TreeSet<E>:
//The elements are ordered using their natural ordering, or by a Comparator
//provided at set creation time, depending on which constructor is used.
//This implementation provides guaranteed log(n) time cost for the basic
//operations (add, remove and contains).

public class VoorbeeldCollectiesSortedSetTreeSet {
    @Test public void main(){
        Person man1 = new Person();    man1.setName("John");
        Person woman1 = new Person();  woman1.setName("Jane");
        Person woman2 = new Person();  woman2.setName("Mia");

        Person[] people1 = {man1, woman1, woman2};
        //of voluit: Person[] people1 = new Person[]{man1, woman1, woman2};
        List<Person> people2 = Arrays.asList(people1);
        SortedSet<Person> sortedPeople = new TreeSet<>(people2);
        for(Person p: sortedPeople)
            System.out.print(p.getName() + " ");
        System.out.println();

        //unieke elementen:
        sortedPeople.add(man1);
        System.out.println("Aantal blijft: " + sortedPeople.size());

        System.out.println("First: " + sortedPeople.first().getName());
        System.out.println("Last: " + sortedPeople.last().getName());

        //head- of tailset opvragen:
        SortedSet<Person> head = sortedPeople.headSet(woman2);
        for(Person p: head)
            System.out.print(p.getName() + " ");
        System.out.println();

        //subset opvragen
        SortedSet<Person> sub = sortedPeople.subSet(woman1, woman2);
        for(Person p: sub)
            System.out.print(p.getName() + " ");
        System.out.println();

        SortedSet<Invoice> sortedInvoices = new TreeSet<>();
        try {
            sortedInvoices.add(new Invoice());
            System.out.println("succes");
        } catch (ClassCastException e) {
            System.out.println("Itemtype moet castable zijn naar Comparable.");
        }
    }
}
class Invoice implements Comparable<Invoice> {
    @Override
    public int compareTo(@NonNull Invoice o) {
        return 0;
    }
    //...
}