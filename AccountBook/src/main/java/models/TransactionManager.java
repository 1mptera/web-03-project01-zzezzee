package models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> transactions() {
        return transactions;
    }

    public int totalReceive() {
        int totalReceive = 0;

        for (Transaction transaction : transactions) {
            if (transaction.type().equals("수입")) {
                totalReceive += transaction.amount();
            }
        }

        return totalReceive;
    }

    public int totalSpend() {
        int totalSpend = 0;

        for (Transaction transaction : transactions) {
            if (transaction.type().equals("지출")) {
                totalSpend -= transaction.amount();
            }
        }

        return totalSpend;
    }

    public void editTransaction(Transaction transaction, String date, String type, String payment, int amount, String comment) {
        transaction.editDate(date);
        transaction.editType(type);
        transaction.editPayment(payment);
        transaction.editAmount(amount);
        transaction.editComment(comment);
    }


}
