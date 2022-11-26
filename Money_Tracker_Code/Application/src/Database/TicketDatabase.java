package Database;

public class TicketDatabase<T> extends Database {

    private TicketDatabase<T> uniqueInstance =null;
    public TicketDatabase() {}
    public TicketDatabase<T> getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new TicketDatabase<T>();
        return uniqueInstance;
    }

}
