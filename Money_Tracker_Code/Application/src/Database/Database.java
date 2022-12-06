package Database;

import Iterator.DatabaseIterator;

public abstract class Database {
    protected BalanceDBController observer;

    public Database() {}

    public abstract DatabaseIterator createIterator();

    public void setObserver(BalanceDBController observer) {
        this.observer = observer;
    }
}
