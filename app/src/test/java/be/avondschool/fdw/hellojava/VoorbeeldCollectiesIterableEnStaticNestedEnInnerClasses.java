package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Oracle - Java Documentation - The Java Tutorials - Nested Classes:
//   https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
//Oracle - Java Documentation - The Java Tutorials - Inner Classes:
//   https://docs.oracle.com/javase/tutorial/java/javaOO/innerclasses.html

public class VoorbeeldCollectiesIterableEnStaticNestedEnInnerClasses {
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

class Person implements Comparable<Person> {
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person)
            return this.getName().equals(((Person) obj).getName());
        return false;
    }

    @Override
    public int compareTo(Person person) {
        if (person != null)
            return this.getName().compareToIgnoreCase(person.getName());
        return 1;
    }
}

//Versie 1: Met static nested class.
class People1 implements Iterable<Person> {
    private List<Person> women = new ArrayList<Person>();
    private List<Person> men = new ArrayList<Person>();

    public void addWoman(Person woman) { women.add(woman); }
    public void addMan(Person man) { men.add(man); }

    @Override
    public Iterator<Person> iterator() {
        return new People1Iterator(women, men);
    }

    // Static nested class:
    static class People1Iterator implements Iterator<Person> {
        private List<Person> women = new ArrayList<Person>();
        private List<Person> men = new ArrayList<Person>();

        public People1Iterator(List<Person> women, List<Person> men) {
            this.women = women;
            this.men = men;
        }

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
}

//Versie 2: Met nested innerclass.
class People2 implements Iterable<Person> {
    private List<Person> women = new ArrayList<Person>();
    private List<Person> men = new ArrayList<Person>();

    public void addWoman(Person woman) { women.add(woman); }
    public void addMan(Person man) { men.add(man); }

    @Override
    public Iterator<Person> iterator() {
        // local innerclass:
        //class PeopleIterator implements ...

        // anonieme lokale innerclass
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