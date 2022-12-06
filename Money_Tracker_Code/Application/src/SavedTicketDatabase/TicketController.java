package SavedTicketDatabase;

import Expense.Expense;
import Tickets.Ticket;

public class TicketController {
    private SavedTicketDatabase database;

    public TicketController(SavedTicketDatabase database) {
        this.database = database;
    }

    public void saveTicket(String name, Ticket ticket) {
        database.addTicketInfo(name, ticket.getExpenses());
    }

    public Ticket getTicket(String name, String payer) throws Exception {
        Ticket ticket = new Ticket(name, payer);

        for (Expense expense : database.getTicketInfo(name)) {
            ticket.addExpense(expense);
        }
        return ticket;
    }
}
