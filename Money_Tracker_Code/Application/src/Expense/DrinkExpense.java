package Expense;

public class DrinkExpense extends VictualExpense {
    public DrinkExpense(String name, float price, String consumer) {
        super(name, price, consumer);
    }

    @Override
    public String toString() {
        String s = "Drink";
        String str = String.format("%-20s"+super.toString(),s);
        return str;
    }
}
