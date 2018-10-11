package be.avondschool.fdw.hellojava.collecties.abcs;

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

public class Voorbeeld {
    @Test public void main(){
        // - AbstractCollection
        AbstracteCollectieVoorbeeld();

        // AbstractCollection afgeleiden:
        // - AbstractSet
        AbstracteSetVoorbeeld();
        // - AbstractList
        AbstracteListVoorbeeld();

        //enkele overige AbstractCollection afgeleiden zijn:
        //- AbstractQueue: basis voor eigen Queue implementaties(.offer, .peek ,.poll)
        //- AbstractMap: basis voor eigen Map implementaties
    }
    static void AbstracteCollectieVoorbeeld(){
        Collection<String> opleidingen1 = new OpleidingenCollectie();

        //Itereren of uitlezen (.size, .contains, .containsAll) kan:
        PrintIterable(opleidingen1);
        System.out.println(opleidingen1.contains("Informatica")); //kan

        //Editeren (.add, .remove, .clear, ...) kan niet:
        //opleidingen1.add("Bloemschikken"); //UnsupportedOperationException

        AanpasbareOpleidingenCollectie opleidingen2 = new AanpasbareOpleidingenCollectie();
        opleidingen2.add("Bloemschikken");
        PrintIterable(opleidingen2);
    }
    static void AbstracteSetVoorbeeld(){
        Set<String> opleidingen1 = new AanpasbareOpleidingenSet();
        //Editeren (.add, .remove, .clear, ...) kan by default niet
        //(UnsupportedOperationException), tenzij overschreven:
        opleidingen1.add("Informatica");   // kan maar voegt niet toe
        opleidingen1.add("Chemie"); // kan en voegt toe
        //Itereren of uitlezen (.size, .contains, .containsAll) kan:
        PrintIterable(opleidingen1);
    }
    static void AbstracteListVoorbeeld(){
        List<String> opleidingen1 = new OpleidingenList();

        //Itereren of uitlezen (.size, .contains, .containsAll) kan:
        PrintIterable(opleidingen1);
        System.out.println(opleidingen1.indexOf("Informatica")); // typische list members
        System.out.println(opleidingen1.get(0));                 // typische list members

        //Editeren (.set, .add, .remove, .clear, ...) kan niet
        //(UnsupportedOperationException):
        //opleidingen1.add("Bloemschikken");
        //opleidingen1.set(0, "Nieuwe waarde");

        //Tenzij overschreven:
        AanpasbareOpleidingenList opleidingen2 = new AanpasbareOpleidingenList();
        opleidingen2.add("Bloemschikken");
        opleidingen2.set(0, "Chemie");
        PrintIterable(opleidingen2);
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

class OpleidingenCollectie extends AbstractCollection<String> {
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
class AanpasbareOpleidingenCollectie extends OpleidingenCollectie {
    {
        //Maak van de ArrayList een modifyable versie...
        items = new ArrayList<>(items);
        //...zodat onderstaande add kan werken (geen exception oplevert).
    }

    //Overschrijf bijkomend members als .add, .remove, .clear, ... om ze modifyable te maken.
    @Override
    public boolean add(String s) {
        return items.add(s);
    }
}

class AanpasbareOpleidingenSet extends AbstractSet<String> {
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

class OpleidingenList extends AbstractList<String> {
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
class AanpasbareOpleidingenList extends AbstractList<String> {
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

