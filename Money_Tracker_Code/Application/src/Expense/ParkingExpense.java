package Expense;

public class ParkingExpense extends Expense{
    private float valetCost;

    public ParkingExpense(String name, float price, String consumer, float valetCost) {
        super(name, price, consumer);
        this.valetCost = valetCost;
    }

    @Override
    public float getCost() {
        return super.getCost() + valetCost;
    }

    @Override
    public String toString() {
        String s = "Parking";
        String str = String.format("%-10s"+ super.toString() +"€%-10.2f",s, valetCost);
        return str;
    }
}
