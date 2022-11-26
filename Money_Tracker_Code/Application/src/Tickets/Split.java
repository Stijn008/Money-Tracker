package Tickets;

import Expense.Expense;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.stream.Collectors;

public class Split implements SplitBehaviour {
    public Split() {}
    public Dictionary<String, Float> getBalance(ArrayList<Expense> expenses) {
        ArrayList<String> personNames = expenses.stream()
                .map (obj -> (Expense) obj)
                .map(Expense::getPerson)
                .distinct()
                .collect(Collectors.toList());

        float totalCost = expenses.stream()
                .map (obj -> (Expense) obj)
                .map(Expense::getCost)
                .reduce(0F, Float::sum);

        Dictionary<String, Float> balances = new Hashtable<String, Float>();

        for (String name:personNames) {
            balances.put(name, totalCost / personNames.size());
        }

        return balances;
    }
}
