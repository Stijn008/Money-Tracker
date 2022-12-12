package Facade;

import Database.*;
import Expense.*;
import Iterator.*;
import Person.*;
import SavedTicketDatabase.*;
import TicketFactory.*;
import Tickets.*;

import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;

public class Facade {
    private PersonDatabase personDB;
    private TicketDatabase ticketDB;
    private BalanceDatabase balanceDB;
    private BalanceDBController balanceDBcontroller;

    private NoSplitTicketFactory noSplitFact;
    private SplitTicketFactory splitFact;
    private TicketController ticketController;
    private SavedTicketDatabase savedTicketDB;
    private SavedTicketObserver savedTicketObs;

    private Ticket ticket;

    public Facade() {
        // Person, Ticket & Balance database part (databases & controller/observer)
        balanceDB = new BalanceDatabase();
        balanceDBcontroller = new BalanceDBController(balanceDB);
        personDB = new PersonDatabase();
        ticketDB = new TicketDatabase();

        // Ticket creation part (factory, controller, observer, ...)
        savedTicketObs = new SavedTicketObserver();
        savedTicketDB = new SavedTicketDatabase();
        ticketController = new TicketController(savedTicketDB);
        noSplitFact = new NoSplitTicketFactory(ticketController);
        splitFact = new SplitTicketFactory(ticketController);

        // INITIALISE OBSERVERS

        // Set the balance database controller as the observer of both databases.
        // This way the controller can change the balance database when the other databases are changed.
        personDB.setObserver(balanceDBcontroller);
        ticketDB.setObserver(balanceDBcontroller);

        // Add observer to the saved ticket database (gives notification of a ticket is saved)
        savedTicketDB.addObserver(savedTicketObs);
    }

    public void addFriend(String name) {
        Person person = new Person(name);
        personDB.addPerson(person);
    }

    public void createTicket(String name, String payer, boolean IsSplit) {
        if (IsSplit) {
            ticket = splitFact.getEmptyTicket(name, payer);
        } else {
            ticket = noSplitFact.getEmptyTicket(name, payer);
        }
    }

    public void loadTicket(String name, String payer, boolean IsSplit) throws Exception {
        if (IsSplit) {
            ticket = splitFact.getSavedTicket(name, payer);
        } else {
            ticket = noSplitFact.getSavedTicket(name, payer);
        }
    }

    public void addExpense(String name, float price, String consumer, String type, float extra) {
        // Expense should ideally be created using a factory with "type" as one of it's inputs
        Expense expense = null;
        switch(type) {
            case "entrance":
                expense = new EntranceExpense(name, price, consumer, (int) extra);
                break;
            case "parking":
                expense = new ParkingExpense(name, price, consumer, extra);
                break;
            case "transport":
                expense = new TransportExpense(name, price, consumer);
                break;
            case "toilet":
                expense = new ToiletExpense(name, price, consumer);
                break;
            case "food":
                expense = new FoodExpense(name, price, consumer);
                break;
            case "snack":
                expense = new SnackExpense(name, price, consumer);
                break;
            case "drink":
                expense = new DrinkExpense(name, price, consumer);
                break;
            default:
                expense = new Expense(name, price, consumer);
        }
        ticket.addExpense(expense);
    }

    public void addTicket() {
        ticketDB.addTicket(ticket);
    }

    public void rememberTicket() {
        this.addTicket();
        ticketController.saveTicket(ticket.getName(), ticket);
    }

    // Get the balance of the user (from the balance database)
    public Dictionary<String, Float> getGlobalBill(String user) {
        Dictionary<String, Float> balance = balanceDB.getPersonBalance(user);
        return balance;
    }

    // Get the balance of the user (calculated from going through all tickets)
    public Dictionary<String, Float> calculateGlobalBill(String user) {
        Dictionary<String, Float> balances = new Hashtable<>();

        for (DatabaseIterator<Ticket> iter = ticketDB.createIterator(); iter.hasNext();) {
            Ticket ticket = iter.next();

            String payer = ticket.getPayer();
            Dictionary<String, Float> addedBalance = ticket.getBalance();

            for (String key : Collections.list(addedBalance.keys())) {
                float amount = addedBalance.get(key);

                // If the user is the payed the ticket he should receive the positive amount, else the amount should be
                // subtracted from his balance.
                if (Objects.equals(user, payer)) {
                    if (Collections.list(balances.keys()).contains(key)) {
                        balances.put(key, balances.get(key) + amount);
                    } else {
                        balances.put(key, amount);
                    }
                } else if (Objects.equals(user, key)) {
                    if (Collections.list(balances.keys()).contains(payer)) {
                        balances.put(payer, balances.get(payer) - amount);
                    } else {
                        balances.put(payer, -amount);
                    }
                }
            }
        }
        return balances;
    }
}
