package Expense;

public class SnackExpense extends VictualExpense {
    public SnackExpense(String name, float price, String consumer) {
        super(name, price, consumer);
    }

    @Override
    public String toString() {
        String s = "Snack";
        String str = String.format("%-20s"+super.toString(),s);
        return str;
    }
}
