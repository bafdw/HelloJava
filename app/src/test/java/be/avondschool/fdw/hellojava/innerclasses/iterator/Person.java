package be.avondschool.fdw.hellojava.innerclasses.iterator;

public class Person implements Comparable<Person> {
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
