package Database;

import Iterator.DatabaseIterator;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import Person.Person;

public class PersonDatabase extends Database {
    private Dictionary<String, Person> entries;
    private static PersonDatabase uniqueInstance;

    public PersonDatabase() {
        this.entries = new Hashtable<>();
    }

    public static PersonDatabase getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PersonDatabase();
        }
        return uniqueInstance;
    }

    public DatabaseIterator<Person> createIterator() {
        return new DatabaseIterator<>(Collections.list(entries.elements()));
    }

    public void notifyObserver(String person) {
        observer.update(person);
    }

    public void addPerson(Person person) {
        entries.put(person.getName(), person);
        notifyObserver(person.getName());
    }
}
