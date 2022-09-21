package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int cash = 0;
    private List<Account> accounts = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();

    public int cash() {
        return cash;
    }

    public List<Account> account() {
        return accounts;
    }

    public List<Card> card() {
        return cards;
    }

    public void addCash(int amount) {
        cash += amount;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int totalAccountAmount() {
        int totalAccountAmount = 0;

        for (Account account : accounts) {
            totalAccountAmount += account.amount();
        }

        return totalAccountAmount;
    }

    public void receiveCash(int amount) {
        cash += amount;
    }

    public void spendCash(int amount) {
        cash -= amount;
    }

    public void accountTransaction(String type, String payment, int amount) {
        for (Account account : accounts) {
            if (account.name().equals(payment)) {
                if (type.equals("수입")) {
                    account.receive(amount);
                }
                if (type.equals("지출")) {
                    account.spend(amount);
                }
            }
        }
    }

    public void cardTransaction(String type, String payment, int amount) {
        for (Card card : cards) {
            if (card.name().equals(payment)) {
                accountTransaction(type, card.linkedAccount(), amount);
            }
        }
    }
}
