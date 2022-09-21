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

    @Test
    void receive() {
        Account account = new Account("재원통장", 1000);

        account.receive(1000);

        assertEquals(2000, account.amount());
    }

    @Test
    void spend() {
        Account account = new Account("재원통장", 1000);

        account.spend(1000);

        assertEquals(0, account.amount());
    }

}
