package Database;

import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import Tickets.Ticket;

public class BalanceDatabase {
    private Dictionary<String, Dictionary<String, Float>> entries;
    private static BalanceDatabase uniqueInstance;

    public BalanceDatabase() {
        this.uniqueInstance = uniqueInstance;
        this.entries = new Hashtable<>();
    }

    public static BalanceDatabase getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new BalanceDatabase();
        }
        return uniqueInstance;
    }

    public void addPerson(String person) {
        entries.put(person, new Hashtable<>());
    }

    public Dictionary<String, Float> getPersonBalance(String person) {
        return entries.get(person);
    }

    public void updateBalance(Ticket ticket) {
        String payer = ticket.getPayer();
        Dictionary<String, Float> balance = entries.get(payer);
        Dictionary<String, Float> addedBalance = ticket.getBalance();

        for (String key : Collections.list(addedBalance.keys())) {
            if (Collections.list(balance.keys()).contains(key)) {
                balance.put(key, balance.get(key) + addedBalance.get(key));
            } else {
                balance.put(key, addedBalance.get(key));
            }
        }

        entries.put(payer, balance);
    }
}
