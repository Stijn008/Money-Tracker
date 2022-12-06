package Expense;

public abstract class Expense {
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
        String str = String.format("%-20s"+"%-20s"+"€%-20f",name,consumer,price);
        return str;
    }
}
