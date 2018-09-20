package be.avondschool.fdw.hellojava.innerclasses.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Versie 1: Met static nested class.
public class People1 implements Iterable<Person> {
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
