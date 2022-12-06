package Database;

import Tickets.Ticket;

public class BalanceDBController {
    private BalanceDatabase database;

    public BalanceDBController(BalanceDatabase db) {
        this.database = db;
    }

    public void update(Ticket ticket) {
        database.updateBalance(ticket);

    }
    public void update(String person) {
        database.addPerson(person);
    }
}
