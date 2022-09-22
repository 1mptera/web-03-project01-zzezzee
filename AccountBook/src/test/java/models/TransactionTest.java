package models;

import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeNode;

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

    @Test
    void editDate() {
        Transaction transaction = new Transaction("09-22", "수입", "재원통장", 10000, "용돈");

        transaction.editDate("09-20");

        assertEquals("09-20", transaction.date());
    }

    @Test
    void editType() {
        Transaction transaction = new Transaction("09-22", "수입", "재원통장", 10000, "용돈");

        transaction.editType("지출");

        assertEquals("지출", transaction.type());
    }

    @Test
    void editPayment() {
        Transaction transaction = new Transaction("09-22", "수입", "재원통장", 10000, "용돈");

        transaction.editPayment("석태통장");

        assertEquals("석태통장", transaction.payment());
    }

    @Test
    void editAmount() {
        Transaction transaction = new Transaction("09-22", "수입", "재원통장", 10000, "용돈");

        transaction.editAmount(5000);

        assertEquals(5000, transaction.amount());
    }

    @Test
    void editComment() {
        Transaction transaction = new Transaction("09-22", "수입", "재원통장", 10000, "용돈");

        transaction.editComment("점심");

        assertEquals("점심", transaction.comment());
    }
}
