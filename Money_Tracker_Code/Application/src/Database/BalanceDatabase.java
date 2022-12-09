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

    public Dictionary<String, Float> getPersonBalance(String person) {
        return entries.get(person);
    }

    //public float getAmount(String payer, String friend) {
    //    Dictionary<String, Float> balance = entries.get(payer);
    //    if (Collections.list(balance.keys()).contains(friend)) {
    //        return balance.get(friend);
    //    } else {
    //        return 0F;
    //    }
    //}

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
