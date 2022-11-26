package Tickets;

import Expense.Expense;
import Person.Person;

import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    private String name;
    private Date date;
    private Person payer;
    private ArrayList<Expense> expenses;
    private SplitBehaviour splitBehaviour;
    private float totalCost;


    public Ticket(String name, Person payer, ArrayList<Expense> expenses, SplitBehaviour splitBehaviour, float totalCost) {
        this.name = name;
        this.payer = payer;
        this.date = new Date();
        this.expenses = expenses;
        this.splitBehaviour = splitBehaviour;
        this.totalCost = totalCost;
    }

    public void addExpense(Expense expense){
        this.totalCost += expense.getCost();

    }

    public void setSplitBehaviour(Boolean split){
        xxx
    }

    public float getBalance (xxx){
        xxx
    }

    public void display(){
        xxx
    }

}
