package models;

public class BankBook {
    private String name;
    private int amount;

    public BankBook(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String name() {
        return name;
    }

    public int amount() {
        return amount;
    }

    public void spend(int amount) {
        this.amount -= amount;
    }

    public void income(int amount) {
        this.amount += amount;
    }
}
