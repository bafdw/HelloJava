package be.avondschool.fdw.hellojava.collecties.map;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Map<K,V>:
//An object that maps keys to values. A map cannot contain duplicate
//keys; each key can map to at most one value.

//HashMap<K,V>:
//Hash table based implementation of the Map interface. This implementation
//provides all of the optional map operations, and permits null values and
//the null key. This class makes no guarantees as to the order of the map.

public class VoorbeeldCollectiesMapHashMap {
    @Test public void main(){
        Employee w1 = new Employee(){{
            setName("Jan");}};
        Employee w2 = new Employee(){{
            setName("Pol");}};

        Map<Employee, String> telboek = new HashMap();
        telboek.put(w1, "09/256.12.34");
        telboek.put(w2, "02/123.45.67");

        System.out.println(telboek.get(w1)); // "09/256.12.34"
        Set<Map.Entry<Employee, String>> entries = telboek.entrySet();
        Set<Employee> werknemers = telboek.keySet();
        Collection<String> telnrs = telboek.values();
        telboek.remove(w1);
        System.out.println(telboek.size()); // 1
    }
}

class Employee{
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private String departement;
    public String getDepartement() { return departement; }
    public void setDepartement(String departement) { this.departement = departement; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        if (!name.equals(e.name)) return false;
        return departement != null ?
                  departement.equals(e.departement)
                : e.departement == null;
    }
    @Override
    public int hashCode() {
        int result = name.hashCode();
        if (departement != null)
            result = result ^ departement.hashCode();
        return result;
    }
}
