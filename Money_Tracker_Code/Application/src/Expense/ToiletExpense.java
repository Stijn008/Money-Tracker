package Expense;

public class ToiletExpense extends Expense {
    public ToiletExpense(String name, float price, String consumer) {
        super(name, price, consumer);
    }

    @Override
    public String toString() {
        String s = "Toilet";
        String str = String.format("%-10s"+super.toString(),s);
        return str;
    }
}
