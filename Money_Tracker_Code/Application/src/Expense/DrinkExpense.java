package Expense;

import Person.Person;

public class DrinkExpense extends Victualexpense {
    public DrinkExpense(String name, float price, Person person) {
        super(name, price, person);
    }

    @Override
    public String toString() {
        String s = "Drink";
        String str = String.format("%-20s"+super.toString(),s);
        return str;
    }
}
