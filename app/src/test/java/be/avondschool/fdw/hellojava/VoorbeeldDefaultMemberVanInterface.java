package be.avondschool.fdw.hellojava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VoorbeeldDefaultMemberVanInterface {
    @Test public void main() {
        List<String> items = new ArrayList<String>() {{add("item x"); add("item y"); add("item z");}};

        DataGateway gateway1 = new DataGateway();
        gateway1.save("item 1");
        gateway1.saveAll(items);

        System.out.println();

        SomeNewDataGateway gateway2 = new SomeNewDataGateway();
        gateway2.save("item 1");
        gateway2.saveAll(items);
    }
}
interface Persistable <T> {
    void save(T item);
    //void saveAll(List<T> items);
    default void saveAll(List<T> items){
        for (T item: items)
            save(item);
    }
}
class DataGateway implements Persistable<String> {
    @Override public void save(String item) {
        System.out.println("Saving item " + item + " to db...");
    }
}
class SomeNewDataGateway implements Persistable<String> {
    @Override public void save(String item) {
        System.out.println("Saving item " + item + " to db...");
    }
    @Override public void saveAll(List<String> items) {
        System.out.println("Optimized behaviour of saving...");
        for (String item: items)
            System.out.println("Item " + item + " to db...");
    }
}