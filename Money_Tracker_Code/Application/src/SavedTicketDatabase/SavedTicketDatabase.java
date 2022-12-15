package SavedTicketDatabase;

import java.util.Dictionary;
import java.util.ArrayList;
import java.util.Hashtable;
import Expense.Expense;
import Tickets.Ticket;

public class SavedTicketDatabase {
    private Dictionary<String, ArrayList<Expense>> savedTicketInfo;
    private ArrayList<SavedTicketObserver> observers;

    public SavedTicketDatabase() {
        this.savedTicketInfo = new Hashtable<>();
        this.observers = new ArrayList<>();
    }

    public ArrayList<Expense> getTicketInfo(String name) throws Exception {
        ArrayList<Expense> expenses = savedTicketInfo.get(name);
        if (expenses == null) {
            throw new Exception("De ticket die u probeert op te halen bestaat niet.");
        }
        return savedTicketInfo.get(name);
    }

    public void addTicketInfo(String name, Ticket ticket) {
        savedTicketInfo.put(name, ticket.getExpenses());
        notifyObservers(ticket);
    }

    public void addObserver(SavedTicketObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Ticket ticket) {
        for (SavedTicketObserver observer:observers) {
            observer.update(ticket);
        }
    }
}
