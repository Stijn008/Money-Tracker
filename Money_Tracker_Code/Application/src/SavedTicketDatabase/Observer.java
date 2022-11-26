package SavedTicketDatabase;

import Tickets.Ticket;

public interface Observer {
    void update(String name , Ticket ticket );
}
