package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {
    private int cash = 0;
    private List<Account> accounts = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();

    public int cash() {
        return cash;
    }

    public void addCash(int amount) {
        cash += amount;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> account() {
        return accounts;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> card() {
        return new ArrayList<>(cards);
    }

    public int totalAccountAmount() {
        int totalAccountAmount = 0;

        for (Account account : accounts) {
            totalAccountAmount += account.amount();
        }

        return totalAccountAmount;
    }

}
