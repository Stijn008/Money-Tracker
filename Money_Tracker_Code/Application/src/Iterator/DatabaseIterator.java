package Iterator;

import java.util.List;

public class DatabaseIterator implements Iterator {
    private Integer index;
    private List<xxx> entries ;

    public DatabaseIterator(Integer index, Entry[xxx] entries) {
        this.index = index;

    }

    @Override
    public void reset() {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    public Entry next(){
        return null;
    }
}