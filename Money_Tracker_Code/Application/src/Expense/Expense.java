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
    public abstract float getCost();
    public abstract String toString();

    public float getPrice() {
        return price;
    }
}
