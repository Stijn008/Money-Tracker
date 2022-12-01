package Database;

import Iterator.DatabaseIterator;
import Iterator.Iterator;

import java.util.ArrayList;

public abstract class Database<T> {
    private ArrayList<T> entries;

    public Database() {
        this.entries = new ArrayList<T>();
    }

    public DatabaseIterator createIterator() {
        return new DatabaseIterator<T>(entries);
    }

    public void addEntry(T entry) {
        entries.add(entry);
    }
}
