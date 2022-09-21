package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LedgerManagerTest {

//    @Test
//    void create() {
//        LedgerManager ledgerManager = new LedgerManager();
//
//        ledgerManager.addTransaction();
//
//
//    }

    @Test
    void classifyTransaction() {
        User user = new User();
        LedgerManager ledgerManager = new LedgerManager(user);

        Transaction transaction1 = new Transaction(
                "2022-09-19",
                "수입",
                "현금",
                10000,
                "용돈"
        );

        ledgerManager.transferTransaction(transaction1);

        assertEquals("수입", ledgerManager.type());
        assertEquals("현금", ledgerManager.payment());
        assertEquals(10000, ledgerManager.amount());
    }

    @Test
    void receiveCash() {
        User user = new User();
        LedgerManager ledgerManager = new LedgerManager(user);

        Transaction transaction1 = new Transaction(
                "2022-09-19",
                "수입",
                "현금",
                10000,
                "용돈"
        );

        ledgerManager.transferTransaction(transaction1);

        assertEquals(10000, user.cash());
    }

    @Test
    void spendCash() {
        User user = new User();
        LedgerManager ledgerManager = new LedgerManager(user);

        Transaction transaction1 = new Transaction(
                "2022-09-19",
                "지출",
                "현금",
                10000,
                "용돈"
        );

        ledgerManager.transferTransaction(transaction1);

        assertEquals(-10000, user.cash());
    }
}
