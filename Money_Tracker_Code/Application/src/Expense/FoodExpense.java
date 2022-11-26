package Expense;

import Person.Person;

public class FoodExpense extends Victualexpense {
    public FoodExpense(String name, float price, Person person) {
        super(name, price, person);
    }

    @Override
    public String toString() {
        String s = "Food";
        String str = String.format("%-20s"+super.toString(),s);
        return str;
    }
}
