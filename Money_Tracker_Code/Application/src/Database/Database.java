package Database;

import Iterator.DatabaseIterator;

import java.util.ArrayList;
import java.util.List;

public abstract class  Database<T> {
    private List<T> entries = new ArrayList<>();
    public Database() {}
    public DatabaseIterator createlIterator(){
        return null;
    }
    public void addEntry(T entry) {}

}
