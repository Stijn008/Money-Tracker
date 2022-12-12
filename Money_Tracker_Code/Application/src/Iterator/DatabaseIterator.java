package Iterator;

import java.util.ArrayList;

public class DatabaseIterator<T> {
    private int index=0;
    private ArrayList<T> entries;

    public DatabaseIterator(ArrayList<T> entries) {
        this.entries = entries;
    }

    public void reset() {
        index = 0;
    }

    public boolean hasNext() {
        return (index < entries.size());
    }

    public T next(){
        return entries.get(index++);
    }
}