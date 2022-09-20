package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void addCash(){
        User user = new User();

        user.addCash(1000);

        assertEquals(1000, user.cash());
    }

    @Test
    void addAccount() {
        User user = new User();

        user.addAccount(new Account("통장1", 1000));

        assertEquals("통장1", user.account().get(0).name());
    }

    @Test
    void addCard() {
        User user = new User();

        user.addAccount(new Account("통장1", 1000));

        user.addCard(new Card("카드1", "통장1"));

        assertEquals("카드1", user.card().get(0).name());
        assertEquals("통장1", user.card().get(0).linkedAccount());
    }
}
