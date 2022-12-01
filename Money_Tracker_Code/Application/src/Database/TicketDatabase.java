package Database;

import Expense.Expense;
import SavedTicketDatabase.Observer;
import Tickets.Ticket;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class TicketDatabase<T> extends Database<T> {
    private static TicketDatabase uniqueInstance;
    private Observer observer;

    public TicketDatabase() {
        this.uniqueInstance = uniqueInstance;
    }

    public static TicketDatabase getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TicketDatabase();
        }
        return uniqueInstance;
    }

    @Override
    public void addEntry(T entry) {
        super.addEntry(entry);
        notifyObservers(entry);
    }

    public void notifyObservers(T t) {
        for (Observer observer:observers) {
            observer.update(T);
        }
    }
}


    private Dictionary<String, ArrayList<Expense>> savedTicketInfo;
    private ArrayList<Observer> observers;

    public SavedTicketDatabase() {
        this.savedTicketInfo = new Hashtable<>();
        this.observers = new ArrayList<>();
    }

    public ArrayList<Expense> getTicketInfo(String name) throws Exception {
        ArrayList<Expense> expenses = savedTicketInfo.get(name);
        if (expenses == null) {
            throw new Exception("Exception message");
        }
        return savedTicketInfo.get(name);
    }

    public void addTicketInfo(String name, ArrayList<Expense> expenses) {
        savedTicketInfo.put(name, expenses);
        notifyObservers(name, expenses);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String name, ArrayList<Expense> expenses) {
        for (Observer observer:observers) {
            observer.update(name);
        }
    }
