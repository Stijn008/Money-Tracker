package SavedTicketDatabase;

public class SavedTicketObserver implements Observer {
    public SavedTicketObserver() {}

    @Override
    public void update(String name) {
        System.out.println("Ticket named '"+name+"' is saved." );
    }
}
