package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    @Test
    void create() {
        Transaction transaction = new Transaction(
                "2022-09-19",
                "수입",
                "용돈",
                10000,
                "삼촌에게 용돈 받음"
        );

//        assertEquals("2022-09-19", transaction.date());
//        assertEquals("수입", transaction.type());
//        assertEquals("용돈", transaction.classifiacation());
//        assertEquals(10000, transaction.amount());
//        assertEquals("삼촌에게 용돈 받음", transaction.comment());
    }
}
