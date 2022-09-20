package models;

import java.util.ArrayList;
import java.util.List;

public class BankBook {
    private String name;
    private int amount;
    private List<Card> cards = new ArrayList<>();

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

    public void add(Card card) {
        cards.add(card);
    }

    public List<Card> cards() {
        return cards;
    }
}
