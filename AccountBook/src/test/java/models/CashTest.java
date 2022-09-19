package models;

import models.Cash;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashTest {
    @Test
    void create() {
        Cash cash = new Cash(10000);

        assertEquals(10000, cash.amount());
    }

    @Test
    void spend() {
        Cash cash = new Cash(10000);

        cash.spend(1000);

        assertEquals(9000, cash.amount());
    }

    @Test
    void income() {
        Cash cash = new Cash(10000);

        cash.income(1000);

        assertEquals(11000, cash.amount());
    }
}
