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
}
