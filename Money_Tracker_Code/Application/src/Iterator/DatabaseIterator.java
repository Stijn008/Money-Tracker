package Iterator;

import java.util.ArrayList;

public class DatabaseIterator<T> implements Iterator {
    private int index=0;
    private ArrayList<T> entries;

    public DatabaseIterator(ArrayList<T> entries) {
        this.entries = entries;
    }

    @Override
    public void reset() {
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return (index < entries.size()-1);
    }

    public T next(){
        return entries.get(index++);
    }
}