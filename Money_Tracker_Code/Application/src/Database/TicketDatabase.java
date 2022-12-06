package Database;

import Iterator.DatabaseIterator;
import Tickets.Ticket;

import java.util.ArrayList;

public class TicketDatabase extends Database {
    private ArrayList<Ticket> entries;
    private static TicketDatabase uniqueInstance;

    public TicketDatabase() {
        this.uniqueInstance = uniqueInstance;
        this.entries = new ArrayList<Ticket>();
    }
    public static TicketDatabase getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TicketDatabase();
        }
        return uniqueInstance;
    }

    public DatabaseIterator<Ticket> createIterator() {
        return new DatabaseIterator<>(entries);
    }

    public void notifyObserver(Ticket t) {
        observer.update(t);
    }

    public void addTicket(Ticket entry) {
        entries.add(entry);
        notifyObserver(entry);
    }
}