package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Oracle - Java Documentation - The Java Tutorials - Lesson: Aggregate Operations:
//   https://docs.oracle.com/javase/tutorial/collections/streams/index.html
//Oracle - Java SE8 Referential Documentation - Package java.util.stream:
//   https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html

public class VoorbeeldCollectiesAggregateOperations {
    @Test public void main() {
        List<Customer> customers = Arrays.asList(
                new Customer("John", 48, Customer.Sex.MALE),
                new Customer("Jane", 24, Customer.Sex.FEMALE),
                new Customer("Paul", 30, Customer.Sex.MALE));

        customers.stream()
              .filter(e -> e.getGender() == Customer.Sex.MALE)
              .forEach(e -> System.out.println(e.getName()));

        double average = customers
                .stream()
                .filter(p -> p.getGender() == Customer.Sex.MALE)
                .mapToInt(Customer::getAge)
                .average()
                .getAsDouble();
        System.out.println("average age males = " + average);

        //Pipeline:
        //- 1 source (collection
        //- 1+ intermediate operation (leveren nieuwe stream op, lazy evaluation)
        //  (filter, map, ...)
        //- 1+ terminal operations (doet iets of levert een resultaat op)
        //  (forEach, average, sum, ...)

        //Enkele belangrijke kenmerken van streams:
        //- is view (met lazy evaluation), hebben geen storage
        //- functional (produceren een resultaat, geen wijziging vd bron)

        // lazy evaluation
        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream().filter(s -> s.startsWith("t"));
        l.add("three");
        long c = sl.count();
        System.out.println("items starting with t, # = " + c);
    }
}
class Customer {
    public Customer(String name, int age, Sex gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    int age;
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    Sex gender;
    public Sex getGender() { return gender; }
    public void setGender(Sex gender) { this.gender = gender; }

    enum Sex {FEMALE, MALE}
}