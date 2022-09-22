package models;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

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
        LedgerManager ledgerManager = new LedgerManager(user, transactionManager);

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

}
