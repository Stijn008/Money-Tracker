package Expense;

public class Expense {
    private String name;
    private float price;
    private String consumer;

    public Expense(String name, float price, String consumer) {
        this.name = name;
        this.price = price;
        this.consumer = consumer;
    }

    public String getName() {
        return name;
    }

    public String getConsumer() {
        return consumer;
    }

    public float getCost() {
        return price;
    }

    public String toString() {
        String str = String.format("%-20s"+"%-10s"+"€%-10.2f",name,consumer,price);
        return str;
    }
}
