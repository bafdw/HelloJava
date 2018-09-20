package be.avondschool.fdw.hellojava.innerclasses.localandanonymousclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import be.avondschool.fdw.hellojava.innerclasses.iterator.Person;

//Versie 3: Met local class implementatie.
public class People3 implements Iterable<Person> {
    private List<Person> women = new ArrayList<Person>();
    private List<Person> men = new ArrayList<Person>();

    public void addWoman(Person woman) {
        women.add(woman);
    }

    public void addMan(Person man) {
        men.add(man);
    }

    @Override
    public Iterator<Person> iterator() {
        //Local class:
        class People3Iterator implements Iterator<Person> {
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
        return new People3Iterator();
    }
}
