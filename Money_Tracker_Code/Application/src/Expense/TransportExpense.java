package Expense;

import Person.Person;

public class TransportExpense extends Expense{
    public TransportExpense(String name, float price, Person person) {
        super(name, price, person);
    }

    @Override
    public String toString() {
        return null;
    }

}
