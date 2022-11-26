package Expense;

import Person.Person;

public class ToiletExpense extends Expense {
    public ToiletExpense(String name, float price, Person person) {
        super(name, price, person);
    }

    @Override
    public String toString() {
        String s = "Toilet";
        String str = String.format("%-20s"+super.toString(),s);
        return str;
    }

}
