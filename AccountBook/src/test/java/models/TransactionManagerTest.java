package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionManagerTest {

    @Test
    void addTransaction() {
        Transaction transaction = new Transaction(
                "2022-09-19",
                "수입",
                "현금",
                10000,
                "삼촌에게 용돈 받음"
        );

        TransactionManager transactionManager = new TransactionManager();

        transactionManager.add(transaction);

        assertEquals("2022-09-19", transactionManager.transaction().get(0).date());
        assertEquals("수입", transactionManager.transaction().get(0).type());
        assertEquals("현금", transactionManager.transaction().get(0).payment());
        assertEquals(10000, transactionManager.transaction().get(0).amount());
        assertEquals("삼촌에게 용돈 받음", transactionManager.transaction().get(0).comment());
    }


}
