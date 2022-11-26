package Tickets;

import Expense.Expense;
import Person.Person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;

public class Ticket {
    private String name;
    private Date date;
    private Person payer;
    private ArrayList<Expense> expenses;
    private SplitBehaviour splitBehaviour;
    private float totalCost = 0;


    public Ticket(String name, Person payer) {
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

    public Dictionary<String, Float> getBalance () {
        return this.splitBehaviour.getBalance(this.expenses);
    }

    public void display() {
        System.out.print(String.format("%0"+50+"d",0).replace("0", "-") + name +
                String.format("%0"+(65-name.length())+"d",0).replace("0", "-"));

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        boolean split = splitBehaviour instanceof Split;
        System.out.println("totalCost: " + totalCost +
                           "     Date: " + dateFormat.format(date) +
                           "     Payer: " + payer.getName() +
                           "     Split: " + (splitBehaviour instanceof Split));



        System.out.print(String.format("%0" + 115 + "d",0).replace("0", "-")+"\n");
    }
}
