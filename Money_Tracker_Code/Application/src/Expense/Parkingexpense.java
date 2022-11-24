package Expense;

public class Parkingexpense extends Expense{
    private float hourlyCost;

    public Parkingexpense(String name, float price, Person person, float hourlyCost) {
        super(name, price, person);
        this.hourlyCost = hourlyCost;
    }

    @Override
    public String toString() {
        return null;
    }



}
