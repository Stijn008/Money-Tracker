package SavedTicketDatabase;

import Tickets.Ticket;

public class SavedTicketObserver {
    public SavedTicketObserver() {}

    public void update(Ticket ticket) {
        ticket.display();
    }
}
