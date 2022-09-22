package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionManagerTest {

    @Test
    void addTransaction() {
        TransactionManager transactionManager = new TransactionManager();

        transactionManager.addTransaction(new Transaction("", "", "", 0, ""));

        assertEquals(1, transactionManager.transactions().size());
    }

    @Test
    void transferTransaction() {
        User user = new User();
        TransactionManager transactionManager = new TransactionManager();
        Ledger ledgerManager = new Ledger(user, transactionManager);

        ledgerManager.transferTransaction(new Transaction("", "", "", 0, ""));

        assertEquals(1, transactionManager.transactions().size());
    }

    @Test
    void toptalReceive() {

        TransactionManager transactionManager = new TransactionManager();

        transactionManager.addTransaction(new Transaction("", "수입", "", 1000, ""));
        transactionManager.addTransaction(new Transaction("", "수입", "", 5000, ""));

        int totalReceive = transactionManager.totalReceive();

        assertEquals(6000, totalReceive);
    }

    @Test
    void totalSpend() {
        TransactionManager transactionManager = new TransactionManager();
        transactionManager.addTransaction(new Transaction("", "지출", "", 1000, ""));
        transactionManager.addTransaction(new Transaction("", "지출", "", 5000, ""));

        int totalSpend = transactionManager.totalSpend();

        assertEquals(-6000, totalSpend);
    }

    @Test
    void editTransaction() {
        TransactionManager transactionManager = new TransactionManager();

        Transaction transaction = new Transaction("09-22", "수입", "재원통장", 10000, "용돈");

        transactionManager.editTransaction(transaction, "09-23", "지출", "재원카드", 9000, "점심");

        assertEquals("09-23", transaction.date());
        assertEquals("지출", transaction.type());
        assertEquals("재원카드", transaction.payment());
        assertEquals(9000, transaction.amount());
        assertEquals("점심", transaction.comment());
    }
}
