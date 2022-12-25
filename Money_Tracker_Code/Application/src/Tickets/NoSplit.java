package Tickets;

import java.util.*;
import java.util.stream.Collectors;

import Expense.Expense;

public class NoSplit implements SplitBehaviour {
    public NoSplit() {}
    public Dictionary<String, Float> getBalance(String payer, ArrayList<Expense> expenses) {
        List<String> personNames = expenses.stream()
                .map(Expense::getConsumer)
                .filter(p -> !Objects.equals(p, payer))
                .distinct()
                .collect(Collectors.toList());

        Dictionary<String, Float> balances = new Hashtable<String, Float>();

        for (String name:personNames) {
            balances.put(name, 0F);
        }

        for (Expense expense : expenses) {
            String name = expense.getConsumer();
            if (balances.get(name) != null && !Objects.equals(name, payer)) {           // if name is not the same as the payer
                balances.put(name, balances.get(name) - expense.getCost());
            }
        }

        return balances;
    }
}
