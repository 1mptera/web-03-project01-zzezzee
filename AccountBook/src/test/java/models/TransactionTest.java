package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void create() {
        Transaction transaction = new Transaction(
                "2022-09-19",
                "수입",
                "현금",
                10000,
                "용돈"
        );

        assertEquals("2022-09-19", transaction.date());
        assertEquals("수입", transaction.type());
        assertEquals("현금", transaction.payment());
        assertEquals(10000, transaction.amount());
        assertEquals("용돈", transaction.comment());
    }


}
