package Tickets;

import java.text.SimpleDateFormat;
import java.util.Dictionary;
import java.text.DateFormat;
import java.util.ArrayList;
import Expense.Expense;
import java.util.Date;

public class Ticket {
    private String name;
    private Date date;
    private String payer;
    private ArrayList<Expense> expenses;
    private SplitBehaviour splitBehaviour;
    private float totalCost = 0;

    public Ticket(String name, String payer) {
        this.name = name;
        this.date = new Date();
        this.payer = payer;
        this.expenses = new ArrayList<>();
        this.splitBehaviour = null;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        totalCost += expense.getCost();
    }

    public void setSplitBehaviour(Boolean split) {
        if (split) {
            this.splitBehaviour = new Split();
        } else {
            this.splitBehaviour = new NoSplit();
        }
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public Dictionary<String, Float> getBalance() {
        return this.splitBehaviour.getBalance(this.payer, this.expenses);
    }

    public String getPayer() {
        return payer;
    }

    public void display() {
        System.out.print(String.format("%0"+50+"d",0).replace("0", "-") + name +
                String.format("%0"+(65-name.length())+"d",0).replace("0", "-"));

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        boolean split = splitBehaviour instanceof Split;
        System.out.println("totalCost: " + totalCost +
                           "     Date: " + dateFormat.format(date) +
                           "     Payer: " + payer +
                           "     Split: " + (splitBehaviour instanceof Split));



        System.out.print(String.format("%0" + 115 + "d",0).replace("0", "-")+"\n");
    }
}
