package TicketFactory;

import SavedTicketDatabase.TicketController;
import Tickets.Ticket;

public abstract class TicketFactory {
    private TicketController controller;

    public TicketFactory(TicketController controller) {
        this.controller = controller;
    }

    public abstract Ticket getEmptyTicket(String name , String payer);
    public abstract Ticket getSavedTicket(String name , String payer) throws Exception;

    public TicketController getController() {
        return  controller;
    }
}
