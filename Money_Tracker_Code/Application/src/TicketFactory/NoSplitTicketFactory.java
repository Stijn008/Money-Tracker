package TicketFactory;

import Person.Person;
import Tickets.Ticket;
import SavedTicketDatabase.TicketController;

public class NoSplitTicketFactory extends TicketFactory {

    public NoSplitTicketFactory(TicketController controller) {
        super(controller);
    }

    @Override
    public Ticket getEmptyTicket(String name, Person payer) {
        return null;
    }

    @Override
    public Ticket getSavedTicket(String name, Person payer) {
        return null;
    }

}
