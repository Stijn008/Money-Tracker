package Tickets;

import java.util.*;
import java.util.stream.Collectors;

import Expense.Expense;

public class Split implements SplitBehaviour {
    public Split() {}
    public Dictionary<String, Float> getBalance(String payer, ArrayList<Expense> expenses) {
        List<String> personNames = expenses.stream()
                .map(Expense::getConsumer)
                .filter(p -> !Objects.equals(p, payer))
                .distinct()
                .collect(Collectors.toList());

        float totalCost = expenses.stream()
                .map (obj -> (Expense) obj)
                .map(Expense::getCost)
                .reduce(0F, Float::sum);

        Dictionary<String, Float> balances = new Hashtable<String, Float>();

        for (String name : personNames) {
            balances.put(name, -totalCost / (personNames.size()+1));
        }

        return balances;
    }
}
