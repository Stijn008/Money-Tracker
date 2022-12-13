package Expense;

public class EntranceExpense extends Expense {
    private Integer discount;

    public EntranceExpense(String name, float price, String consumer, Integer discount) {
        super(name, price, consumer);
        this.discount = discount;
    }

    @Override
    public float getCost() {
        return super.getCost() * (100 - discount);
    }

    @Override
    public String toString() {
        String s = "Entrance";
        String str = String.format("%-10s"+super.toString(),s) + "-" + discount + "%";
        return str;
    }
}
