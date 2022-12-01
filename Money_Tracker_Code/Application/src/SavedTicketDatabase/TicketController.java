package SavedTicketDatabase;

import Expense.Expense;
import Person.Person;
import Tickets.Ticket;

import java.util.ArrayList;

public class TicketController {
    private SavedTicketDatabase database;

    public TicketController(SavedTicketDatabase database) {
        this.database = database;
    }

    public void saveTicket(String name, Ticket ticket) {
        database.addTicketInfo(name, ticket.getExpenses());
    }

    public Ticket getTicket(String name, Person payer) throws Exception {
        Ticket ticket = new Ticket(name, payer);

        ticket.setExpenses(database.getTicketInfo(name));
        return ticket;
    }
}
