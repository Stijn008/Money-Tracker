package Tickets;

import java.util.stream.Collectors;
import java.util.Dictionary;
import java.util.ArrayList;
import java.util.Hashtable;
import Expense.Expense;
import java.util.List;

public class NoSplit implements SplitBehaviour {
    public NoSplit() {}
    public Dictionary<String, Float> getBalance(String payer, ArrayList<Expense> expenses) {
        List<String> personNames = expenses.stream()
                .map(Expense::getConsumer)
                .filter(p -> p != payer)
                .distinct()
                .collect(Collectors.toList());

        Dictionary<String, Float> balances = new Hashtable<String, Float>();

        for (String name:personNames) {
            balances.put(name, 0F);
        }

        for (Expense expense : expenses) {
            String name = expense.getConsumer();
            balances.put(name, balances.get(name) + expense.getCost());
        }

        return balances;
    }
}
