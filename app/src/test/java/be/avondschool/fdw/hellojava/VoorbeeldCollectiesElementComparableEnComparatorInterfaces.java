package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class VoorbeeldCollectiesElementComparableEnComparatorInterfaces {
    @Test public void main(){
        Person man1 = new Person();    man1.setName("John");
        Person woman1 = new Person();  woman1.setName("Jane");
        Person woman2 = new Person();  woman2.setName("Mia");

        Person[] people = new Person[] {man1, woman1, woman2};

        Arrays.sort(people);
        for(Person p: people)
            System.out.print(p.getName() + " ");
        System.out.println();

        Arrays.sort(people, new OpTweedeKarakterVanDeNaamSorteerder());
        for(Person p: people)
            System.out.print(p.getName() + " ");
        System.out.println();
    }
}
class OpTweedeKarakterVanDeNaamSorteerder implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getName().substring(1).compareToIgnoreCase(person2.getName().substring(1));
    }
}
