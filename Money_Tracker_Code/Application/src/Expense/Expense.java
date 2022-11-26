package Expense;

import Person.Person;

public abstract class Expense {
    private String name;
    private float price;
    private Person person;

    public Expense(String name, float price, Person person) {
        this.name = name;
        this.price = price;
        this.person = person;
    }

    public float getCost() {
        return price;
    }

    public abstract String toString() {

    }

}
