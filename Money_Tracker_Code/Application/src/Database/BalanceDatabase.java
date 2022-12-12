package Database;

import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import Tickets.Ticket;

public class BalanceDatabase {
    private Dictionary<String, Dictionary<String, Float>> entries;
    private static BalanceDatabase uniqueInstance;

    public BalanceDatabase() {
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

    public void removePerson(String person) {
        if (entries.get(person) == null) {
            System.out.println("Error: Person not found in balance database!");
        } else {
            entries.remove(person);
            for (String key : Collections.list(entries.keys())) {
                if (entries.get(key).get(person) != null) {
                    Dictionary<String, Float> balances = entries.get(key);
                    balances.remove(person);
                    entries.put(key, balances);
                }
            }
        }
    }

    public Dictionary<String, Float> getPersonBalance(String person) {
        return entries.get(person);
    }

    public void addAmount(String payer, String friend, float amount) {
        Dictionary<String, Float> balance = entries.get(payer);
        if (Collections.list(balance.keys()).contains(friend)) {
            balance.put(friend, balance.get(friend) + amount);
        } else {
            balance.put(friend, amount);
        }
        entries.put(payer, balance);
    }

    public void updateBalance(Ticket ticket) {
        String payer = ticket.getPayer();
        Dictionary<String, Float> addedBalance = ticket.getBalance();

        for (String key : Collections.list(addedBalance.keys())) {
            float amount = addedBalance.get(key);
            addAmount(payer, key, amount);
            addAmount(key, payer, -amount);
        }
    }
}
