package models;

public class Account {
    private String name;
    private int amount;

    public Account(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String name() {
        return name;
    }

    public int amount() {
        return amount;
    }
}
