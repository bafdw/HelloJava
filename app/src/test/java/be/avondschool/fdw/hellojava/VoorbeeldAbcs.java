package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VoorbeeldAbcs {
    @Test public void main(){
        // - AbstractCollection
        //   https://docs.oracle.com/javase/8/docs/api/java/util/AbstractCollection.html
        TestAbstractCollectionImpl();
        // - AbstractSet
        //   https://docs.oracle.com/javase/8/docs/api/java/util/AbstractSet.html
        TestAbstractSetImpl();
        // - AbstractList
        //   https://docs.oracle.com/javase/8/docs/api/java/util/AbstractList.html
        TestAbstractListImpl();

        //overige AbstractCollection afgeleiden zijn:
        //- AbstractSequentialList: basis voor performante invoeg en verwijder List implementaties
        //  https://docs.oracle.com/javase/8/docs/api/java/util/AbstractSequentialList.html
        //- AbstractQueue: basis voor eigen Queue implementaties(.offer, .peek ,.poll)
        //  https://docs.oracle.com/javase/8/docs/api/java/util/AbstractQueue.html
        //- AbstractMap: basis voor eigen Map implementaties
        //  https://docs.oracle.com/javase/8/docs/api/java/util/AbstractMap.html
    }
    static void TestAbstractCollectionImpl(){
        Collection<String> cc = new CustomColl();
        //Itereren of uitlezen (.size, .contains, .containsAll) kan:
        PrintIterable(cc);
        System.out.println(cc.contains("Informatica")); //kan
        //Editeren (.add, .remove, .clear, ...) kan niet:
        //cc.add("Bloemschikken"); //UnsupportedOperationException

        CustomModColl cmc = new CustomModColl();
        cmc.add("Bloemschikken");
        PrintIterable(cmc);
    }
    static void TestAbstractSetImpl(){
        Set<String> cms = new CustomModSet();
        //Editeren (.add, .remove, .clear, ...) kan by default niet
        //(UnsupportedOperationException), tenzij overschreven:
        cms.add("Informatica");   // kan maar voegt niet toe
        cms.add("Chemie"); // kan en voegt toe
        //Itereren of uitlezen (.size, .contains, .containsAll) kan:
        PrintIterable(cms);
    }
    static void TestAbstractListImpl(){
        List<String> cl = new CustomList();
        //Itereren of uitlezen (.size, .contains, .containsAll) kan:
        PrintIterable(cl);
        System.out.println(cl.indexOf("Informatica")); // type list members
        System.out.println(cl.get(0));                 // type list members
        //Editeren (.set, .add, .remove, .clear, ...) kan niet
        //(UnsupportedOperationException):
        //cl.add("Bloemschikken");
        //cl.set(0, "Nieuwe waarde");

        //Tenzij overschreven:
        CustomModList cml = new CustomModList();
        cml.add("Bloemschikken");
        cml.set(0, "Chemie");
        PrintIterable(cml);
    }
    static void PrintIterable(Iterable<String> coll){
        Iterator<String> items = coll.iterator();
        while (items.hasNext()) {
            String item = items.next();
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
class CustomColl extends AbstractCollection<String> {
    //java.util.AbstractCollection<E> implemented Iterable<E>, Collection<E>
    //supertype of: AbstractList<E>, AbstractQueue<E>, AbstractSet<E>, ArrayDeque<E>
    //Neither a Set nor a List.

    //At a minimum, you must provide the iterator and size.
    @Override public Iterator<String> iterator() { return items.iterator(); }
    @Override public int size() { return items.size(); }

    protected List<String> items =
            Arrays.asList(new String[] {"Informatica", "Boekhouden", "Topografie"});
    // hier voor List<String> backed data store gekozen omdat deze iterable is

    //The programmer should generally provide a void (no argument) and
    //collection constructor, as per the recommendation in the Collection
    //interface specification.
}
class CustomModColl extends CustomColl {
    {
        //Maak van de ArrayList een modifyable versie:
        items = new ArrayList<>(items);
    }

    //Overschrijf bijkomend members als .add, .remove, .clear, ... om ze modifyable te maken.
    @Override
    public boolean add(String s) {
        return items.add(s);
    }
}
class CustomModSet extends AbstractSet<String> {
    //java.util.AbstractSet<E> extends AbstractCollection<E>
    //                         implements Iterable<E>, Collection<E>, Set<E>
    //The process of implementing a set by extending this class is identical
    //to extending AbstractCollection, except that methods and ctors in
    // subclasses must obey the additional Set interface constraints:
    //- .add must not permit addition of multiple instances of an object (based on .equals)
    //- ctor must create a set that contains no duplicate elements
    //At a minimum, you must provide the iterator and size.
    @Override public Iterator<String> iterator() { return items.iterator(); }
    @Override public int size() { return items.size(); }

    protected List<String> items =
            new ArrayList<String>(){{add("Informatica"); add("Boekhouden"); add("Topografie");}};

    @Override
    public boolean add(String s) {
        if (!contains(s))
            return items.add(s);
        return false;
    }
}
class CustomList extends AbstractList<String> {
    //java.util.AbstractList<E> extends AbstractCollection<E>
    //                          implements Iterable<E>, Collection<E>, List<E>
    //This class provides a skeletal implementation of the List interface to
    //minimize the effort required to implement this interface backed by
    //a "random access" data store (such as an array).
    //At a minimum (for a unmodifiable list) implement get and size:
    @Override public String get(int index) { return items[index]; }
    @Override public int size() { return items.length; }

    protected String[] items = {"Informatica", "Boekhouden", "Topografie"};

    //Unlike the other abstract collection implementations, the programmer does
    //not have to provide an iterator implementation; the iterator are implemented
    //by this class, on top of the "random access" methods (.get, .size).
}
class CustomModList extends AbstractList<String> {
    @Override public String get(int index) { return items.get(index); }
    @Override public int size() { return items.size(); }

    protected List<String> items =
            new ArrayList<String>(){{add("Informatica"); add("Boekhouden"); add("Topografie");}};

    //Voor een modifiable versie overschrijf .set:
    @Override public String set(int index, String element) {
        return items.set(index, element);
    }

    //Voor een variable-size versie op zijn minst ook .add en .remove:
    @Override public boolean add(String s) { return items.add(s); }
    @Override public String remove(int index) { return items.remove(index); }
}

