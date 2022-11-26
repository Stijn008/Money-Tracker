package Tickets;

import Person.Person;

public class NoSplitTicketFactory extends TicketFactory{

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
