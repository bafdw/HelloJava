package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Oracle - Java Documentation - The Java Tutorials - Convenience Implementations:
//   https://docs.oracle.com/javase/tutorial/collections/implementations/convenience.html

public class VoorbeeldCollectiesCreateFill {
    @Test public void main(){
        creatieMetReeksGekendeWaardes();
        creatieMetReeksZelfdeWaardes();
        creatieMet1Element();
        creatieZonderInhoud();
    }

    static void creatieMetReeksGekendeWaardes(){
        // Short, but the resulting list is fixed size.
        List<String> lijst1 = Arrays.asList("s1", "s2", "s3");
        //Geen "asSet" of "asMap" varianten.
        //mutable en fixed-size
        lijst1.set(0, "wereld"); //kan
        //lijst1.add("iets");    // kan niet UnsupportedException
        printColl(lijst1);

        // Similar to above, but the resulting list can grow.
        List<String> lijst2 =
                new ArrayList<>(Arrays.asList("s1", "s2", "s3"));
        //mutable en variable-size
        lijst2.set(0, "wereld"); //kan
        lijst2.add("iets");      // kan
        printColl(lijst2);

        // Using initialization block. Useful if you need to "compute" the strings.
        List<String> lijst3 =
                new ArrayList<String>() {{add("s1"); add("s2"); add("s3");}};
        //mutable en variable-size
        lijst3.set(0, "wereld"); //kan
        lijst3.add("iets");      // kan
        printColl(lijst3);

        // Java 9+:
        // List<String> lijst4 = List.of("s1", "s2", "s3");
    }
    static void creatieMetReeksZelfdeWaardes() {
        List<String> lijst1 = Collections.nCopies(5, "hallo");
        //immutable en fixed-size
        //lijst1.set(0, "wereld"); //kan niet
        //lijst1.add("iets");      //kan niet
        printColl(lijst1);
    }
    static void creatieMet1Element() {
        List<String> lijst1 = Collections.singletonList("hello");
        //immutable en fixed-size
        //lijst1.set(0, "wereld"); //kan niet
        //lijst1.add("iets");      //kan niet
        printColl(lijst1);

        //Voor creatie van Set -> Set<E> Collections.singleton(E o)
        //Voor creatie van Map -> Map<K, V> Collections.singletonMap(K key, V Value);
    }
    static void creatieZonderInhoud() {
        List<String> lijst1 = Collections.emptyList();
        //fixed-size
        //lijst1.add("iets");      //kan niet
    }

    static <E> void printColl(Iterable<E> coll){
        for(E element: coll)
            System.out.print(element.toString() + " ");
        System.out.println();
    }
}
