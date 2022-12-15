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

    public void notifyObserver(String person, boolean IsAdded) throws Exception {
        observer.update(person, IsAdded);
    }

    public void addPerson(Person person) throws Exception {
        if (entries.get(person.getName()) == null) {
            entries.put(person.getName(), person);
            notifyObserver(person.getName(), true);
        } else {
            throw new Exception("Deze persoon bestaat al.");
        }
    }

    public void removePerson(String name) throws Exception {
        if (entries.get(name) == null) {
            throw new Exception("Deze persoon bestaat niet.");
        } else {
            entries.remove(name);
            notifyObserver(name, false);
        }
    }

    public Person getPerson(String name) {
        return entries.get(name);
    }
}
