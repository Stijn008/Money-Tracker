package Database;

import Iterator.DatabaseIterator;

public abstract class  Database<T> {
    private T[xxx] entries;

    public Database() {}

    public DatabaseIterator createlIterator(){
        return null;
    }
    public void addEntry(T entry){}

}
