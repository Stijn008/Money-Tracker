package Tickets;

import Person.Person;

import java.util.Date;

public class Ticket {
    private String name;
    private Date date;
    private Person payer;
    private xxx expenses;
    private SplitBehaviour splitBehaviour;
    private float totalCost;


    public Ticket(String name, Person payer, xxx expenses, SplitBehaviour splitBehaviour, float totalCost) {
        this.name = name;
        this.payer = payer;
        this.expenses = expenses;
        this.splitBehaviour = splitBehaviour;
        this.totalCost = totalCost;
    }
    public void addExpense(xxx expense){
        xxx
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
