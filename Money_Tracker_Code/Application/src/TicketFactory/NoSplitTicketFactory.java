package TicketFactory;

import SavedTicketDatabase.TicketController;
import Tickets.Ticket;

public class NoSplitTicketFactory extends TicketFactory {

    public NoSplitTicketFactory(TicketController controller) {
        super(controller);
    }

    @Override
    public Ticket getEmptyTicket(String name, String payer) {
        Ticket ticket = new Ticket(name, payer);
        ticket.setSplitBehaviour(false);
        return ticket;
    }

    @Override
    public Ticket getSavedTicket(String name, String payer) throws Exception {
        Ticket ticket = this.getController().getTicket(name, payer);
        ticket.setSplitBehaviour(false);
        return ticket;
    }
}
