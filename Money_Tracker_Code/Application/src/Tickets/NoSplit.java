package Tickets;

import Expense.Expense;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.stream.Collectors;

public class NoSplit implements SplitBehaviour {
    public NoSplit() {}
    public Dictionary<String, Float> getBalance(ArrayList<Expense> expenses) {
        ArrayList<String> personNames = expenses.stream()
                .map(obj -> (Expense) obj)
                .map(Expense::getPerson)
                .distinct()
                .collect(Collectors.toList());

        Dictionary<String, Float> balances = new Hashtable<String, Float>();

        for (String name:personNames) {
            balances.put(name, 0F);
        }

        for (Expense expense:expenses) {
            String name = expense.getPerson().getName();
            balances.put(name, balances.get(name) + expense.getCost());
        }

        return balances;
    }
}
