package models;

public class Cash {
    private int amount;

    public Cash(int amount) {
        this.amount = amount;
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
