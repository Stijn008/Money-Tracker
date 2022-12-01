package TicketFactory;

import Person.Person;
import SavedTicketDatabase.TicketController;
import Tickets.Ticket;

public abstract class TicketFactory {
    private TicketController controller;

    public TicketFactory(TicketController controller) {
        this.controller = controller;
    }
    public abstract Ticket getEmptyTicket(String name , Person payer);
    public abstract Ticket getSavedTicket(String name , Person payer) throws Exception;

    public TicketController getController() {
        return  controller;
    }
}
