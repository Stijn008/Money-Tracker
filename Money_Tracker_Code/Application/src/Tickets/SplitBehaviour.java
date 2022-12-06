package Tickets;

import java.util.Dictionary;
import java.util.ArrayList;
import Expense.Expense;

public interface SplitBehaviour{
    Dictionary<String, Float> getBalance(String payer, ArrayList<Expense> expenses);
}
