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

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    public String toString() {
        String str = String.format("%-20s"+"%-20s"+"€%-20f",name,person.getName(),price);
        return str;
    }


}
