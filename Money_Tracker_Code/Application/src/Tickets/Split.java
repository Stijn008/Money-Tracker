package Tickets;

import java.util.stream.Collectors;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.ArrayList;
import Expense.Expense;
import java.util.List;

public class Split implements SplitBehaviour {
    public Split() {}
    public Dictionary<String, Float> getBalance(String payer, ArrayList<Expense> expenses) {
        List<String> personNames = expenses.stream()
                .map(Expense::getConsumer)
                .filter(p -> p != payer)
                .distinct()
                .collect(Collectors.toList());

        float totalCost = expenses.stream()
                .map (obj -> (Expense) obj)
                .map(Expense::getCost)
                .reduce(0F, Float::sum);

        Dictionary<String, Float> balances = new Hashtable<String, Float>();

        for (String name : personNames) {
            balances.put(name, totalCost / personNames.size());
        }

        return balances;
    }
}
