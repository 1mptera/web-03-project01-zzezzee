package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void create() {
        Account account = new Account("통장1", 1000);

        assertEquals("통장1", account.name());
        assertEquals(1000, account.amount());
    }
}
