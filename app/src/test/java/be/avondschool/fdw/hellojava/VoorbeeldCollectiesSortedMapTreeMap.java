package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

//Inteface java.util.SortedMap<K,V>
//   https://docs.oracle.com/javase/8/docs/api/java/util/SortedMap.html
//Extends Map<K,V>
//
//A Map that further provides a total ordering on its keys. The map is
//ordered according to the natural ordering of its keys, or by a Comparator
//typically provided at sorted map creation time. This order is reflected
//when iterating over the sorted map's collection views (returned by the
//entrySet, keySet and values methods).
//All keys inserted into a sorted map must implement the Comparable
//interface (or be accepted by the specified comparator).

//Class java.util.TreeMap<K,V>
//   https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html
//Implements SortedMap<K,V>
//
//The map is sorted according to the natural ordering of its keys, or by
//a Comparator provided at map creation time, depending on which constructor
//is used.

public class VoorbeeldCollectiesSortedMapTreeMap {
    @Test public void main(){
        Person man1 = new Person();    man1.setName("John");
        Person woman1 = new Person();  woman1.setName("Jane");
        Person woman2 = new Person();  woman2.setName("Mia");

        Map<Person, String> phonebook = new HashMap<>();
        phonebook.put(man1, "09/123.45.67");
        phonebook.put(woman1, "09/234.56.78");
        phonebook.put(woman2, "09/345.67.89");
        System.out.println(phonebook.get(woman1));

        SortedMap<Person, String> phonebook2 = new TreeMap<>(phonebook);
        for(Person item: phonebook2.keySet())
            System.out.println(item + ": " + phonebook2.get(item));
    }
}