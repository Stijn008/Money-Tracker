package Expense;

public class TransportExpense extends Expense {
    public TransportExpense(String name, float price, String consumer) {
        super(name, price, consumer);
    }

    @Override
    public String toString() {
        String s = "Parking";
        String str = String.format("%-10s"+super.toString(),s);
        return str;
    }
}
