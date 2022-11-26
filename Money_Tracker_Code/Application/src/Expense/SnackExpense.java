package Expense;

import Person.Person;

public class SnackExpense extends Victualexpense {
    public SnackExpense(String name, float price, Person person) {
        super(name, price, person);
    }

    @Override
    public String toString() {
        String s = "Snack";
        String str = String.format("%-20s"+super.toString(),s);
        return str;
    }
}
