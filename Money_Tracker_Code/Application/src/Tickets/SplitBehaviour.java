package Tickets;

import Expense.Expense;

import java.util.ArrayList;
import java.util.Dictionary;

public interface SplitBehaviour {
    public Dictionary<String, Float> getBalance(ArrayList<Expense> expenses);
}
