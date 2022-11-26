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
        String s = "Entrance";
        String str = String.format("%-20s"+super.toString()+"%-20d",s, discount);
        return str;
    }

}
