package Expense;

import Person.Person;

public class EntranceExpense extends Expense {
    private Integer discount;

    public EntranceExpense(String name, float price, Person person, Integer discount) {
        super(name, price, person);
        this.discount = discount;
    }

    @Override
    public float getCost() {
        return getPrice() ;
    }

    @Override
    public String toString() {
        return null;
    }

}
