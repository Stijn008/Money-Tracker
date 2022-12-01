package SavedTicketDatabase;

import Expense.Expense;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class SavedTicketDatabase {
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
}
