package Expense;

import Person.Person;

public class Parkingexpense extends Expense{
    private float valetCost;

    public Parkingexpense(String name, float price, Person person, float valetCost) {
        super(name, price, person);
        this.valetCost = valetCost;
    }

    @Override
    public float getCost() {
        return super.getCost() + valetCost;
    }

    @Override
    public String toString() {
        String s = "Parking";
        String str = String.format("%-20s"+ super.toString() +"%-20d",s, valetCost);
        return str;
    }



}
