package TicketFactory;

import Person.Person;
import SavedTicketDatabase.TicketController;
import Tickets.Ticket;

public class NoSplitTicketFactory extends TicketFactory {

    public NoSplitTicketFactory(TicketController controller) {
        super(controller);
    }

    @Override
    public Ticket getEmptyTicket(String name, Person payer) {
        Ticket ticket = new Ticket(name, payer);
        ticket.setSplitBehaviour(false);
        return ticket;
    }

    @Override
    public Ticket getSavedTicket(String name, Person payer) throws Exception {
        Ticket ticket = this.getController().getTicket(name, payer);
        ticket.setSplitBehaviour(false);
        return ticket;
    }
}
