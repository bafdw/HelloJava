package be.avondschool.fdw.hellojava.innerclasses.lamdasandfunctionalinterfaces;

import org.junit.Test;

import java.util.function.Consumer;

import be.avondschool.fdw.hellojava.innerclasses.iterator.People1;
import be.avondschool.fdw.hellojava.innerclasses.iterator.Person;

//Oracle - Java Documentation - The Java Tutorials - Lambda Expressions:
//   https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

public class Voorbeeld {
    @Test public void main(){
        Person man1 = new Person();    man1.setName("John");
        Person woman1 = new Person();  woman1.setName("Jane");
        Person woman2 = new Person();  woman2.setName("Mia");

        People1 people1 = new People1();
        people1.addMan(man1);
        people1.addWoman(woman1);
        people1.addWoman(woman2);

        //De klassieke foreach iteratie kennen we:
        for (Person item : people1)
            System.out.print(item.getName() + " ");
        System.out.println();

        //In de java.util.function package bestaat er een Consumer<T> interface:
        //interface Consumer<T> {
        //    void accept(T t);
        //}

        //Die we bijvoorbeeld bij wijze van lokale anonieme klasse kunnen implementeren:
        Consumer<Person> action = new Consumer<Person>() {
            @Override public void accept(Person p) {
                System.out.print(p.getName().charAt(0) + ". ");
            }
        };

        //Deze "consumer" kunnen we meegeven aan een forEach method die
        //aan te roepen is op Iterable<T> implementerende datatypes.
        people1.forEach(action);
        System.out.println();

        //De action variabele kan natuurlijk ook achterwege gelaten worden:
        people1.forEach(new Consumer<Person>() {
            @Override public void accept(Person p) {
                System.out.print(p.getName().charAt(0) + "-");
            }
        });
        System.out.println();

        //Omdat het hier gaat om de implementatie van een interface met één method (wat
        //een "functional interface" wordt genoemd) mag je ook gebruik maken van de lambda
        //notatie, een verkorte taalconstructie van bovenstaande:
        people1.forEach(p -> System.out.print(p.getName().charAt(0) + "/"));
        System.out.println();

        //Type inference op bovenstaande parameter was van toepassing, kan ook zonder:
        people1.forEach((Person p) -> System.out.print(p.getName().charAt(0) + "|"));
        System.out.println();

        //Multi-line-lambdas ook mogelijk:
        people1.forEach(p -> {System.out.print(p.getName().charAt(0));
                              System.out.print(" ");});
    }
}
