package Tickets;

import Person.Person;

public class SplitTicketFactory extends TicketFactory{

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
