package TicketFactory;

import Person.Person;
import Tickets.Ticket;
import SavedTicketDatabase.TicketController;

public class SplitTicketFactory extends TicketFactory {

    public SplitTicketFactory(TicketController controller) {
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
