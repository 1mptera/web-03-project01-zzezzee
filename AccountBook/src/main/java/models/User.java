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

    public void reflectTransaction(String type, String payment, int amount) {
        for (Card card : cards) {
            if (card.name().equals(payment)) {
                reflectTransaction(type, card.linkedAccount(), amount);
                return;
            }
        }
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

    public void removeTransaction(Transaction transaction) {
        String type = transaction.type();
        String payment = transaction.payment();
        int amount = transaction.amount();

        if(type.equals("수입") && payment.equals("현금")){
            spendCash(amount);
        }

        if(type.equals("지출") && payment.equals("현금")){
            receiveCash(amount);
        }

        if (!payment.equals("현금")) {
            reflectRemoveTransaction(type, payment, amount);
        }
    }

    private void reflectRemoveTransaction(String type, String payment, int amount) {
        for (Card card : cards) {
            if (card.name().equals(payment)) {
                reflectTransaction(type, card.linkedAccount(), -amount);
                return;
            }
        }
        for (Account account : accounts) {
            if (account.name().equals(payment)) {
                if (type.equals("수입")) {
                    account.spend(amount);
                }
                if (type.equals("지출")) {
                    account.receive(amount);
                }
            }
        }
    }
}
