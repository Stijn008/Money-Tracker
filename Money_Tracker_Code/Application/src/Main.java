import Database.TicketDatabase;

import Iterator.DatabaseIterator;
import Tickets.Ticket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        TicketDatabase db = new TicketDatabase();
        DatabaseIterator<Ticket> iter = db.createIterator();
        Ticket t = iter.next();
    }
}