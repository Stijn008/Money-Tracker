package Expense;

public class FoodExpense extends VictualExpense {
    public FoodExpense(String name, float price, String consumer) {
        super(name, price, consumer);
    }

    @Override
    public String toString() {
        String s = "Food";
        String str = String.format("%-10s"+super.toString(),s);
        return str;
    }
}
