package models;

public class Card {
    private String name;
    private BankBook bankBook;

    public Card(String name, BankBook bankBook) {
        this.name = name;
        this.bankBook = bankBook;
    }

    public void spend(int amount) {
        bankBook.spend(amount);
    }

    public String name() {
        return name;
    }
}
