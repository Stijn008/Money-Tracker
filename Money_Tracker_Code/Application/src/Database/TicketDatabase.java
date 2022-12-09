package Database;

import Iterator.DatabaseIterator;
import java.util.ArrayList;
import Tickets.Ticket;

public class TicketDatabase extends Database {
    private ArrayList<Ticket> entries;
    private static TicketDatabase uniqueInstance;

    public TicketDatabase() {
        this.entries = new ArrayList<>();
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

    public void notifyObserver(Ticket ticket) {
        observer.update(ticket);
    }

    public void addTicket(Ticket entry) {
        entries.add(entry);
        notifyObserver(entry);
    }
}