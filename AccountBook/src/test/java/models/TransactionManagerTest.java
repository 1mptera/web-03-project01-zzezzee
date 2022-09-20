package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionManagerTest {

    @Test
    void addTransaction() {
        TransactionManager transactionManager = new TransactionManager();

        transactionManager.add(new Transaction(
                "2022-09-20",
                "수입",
                "현금",
                10000,
                "용돈"
        ));

        assertEquals(1, transactionManager.transactions.size());
    }
}
