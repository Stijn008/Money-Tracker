package Database;

public class TicketDatabase<T> extends Database{
    private TicketDatabase<T> uniqueInstance;

    public TicketDatabase(TicketDatabase<T> uniqueInstance) {
        this.uniqueInstance = uniqueInstance;
    }
    public TicketDatabase<T> getInstance(){
        return null;
    }

}
