package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionManager {
    public List<Transaction> transactions = new ArrayList<>();

    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> transaction() {
        return transactions;
    }
}