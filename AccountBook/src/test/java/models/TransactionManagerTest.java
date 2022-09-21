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
}
