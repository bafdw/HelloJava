package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//Interface java.util.Set<E>
//   https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
//Extends Collection<E>
//
//A collection that contains no duplicate elements. More formally, sets
//contain no pair of elements e1 and e2 such that e1.equals(e2), and at
//most one null element.

//Class java.util.HashSet<E>
//   https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html
//Implements Set<E>
//
//This class implements the Set interface, backed by a hash table. It makes
//no guarantees as to the iteration order of the set. This class permits the
//null element.
//This class offers constant time performance for the basic operations (add,
//remove, contains and size), assuming the hash function disperses the elements
//properly among the buckets.
public class VoorbeeldCollectiesSetHashSet {
    @Test public void main(){
        Something ding1 = new Something(10);
        Something ding2 = new Something(20);
        Something ding3 = new Something(10);

        Set<Something> uniekeDingen = new HashSet<>();
        System.out.println(uniekeDingen.add(ding1));
        System.out.println(uniekeDingen.add(ding2));
        System.out.println(uniekeDingen.add(ding3));

        System.out.println(uniekeDingen.size()); // 2
    }
}
class Something{
    private int value;
    public Something(int value) { this.value = value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Something something = (Something) o;
        return value == something.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}