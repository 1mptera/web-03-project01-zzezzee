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

    @Test
    void totalAccountAmount() {
        User user = new User();

        user.addAccount(new Account("통장1", 1000));
        user.addAccount(new Account("통장2", 2000));
        user.addAccount(new Account("통장3", 2000));

        assertEquals(5000, user.totalAccountAmount());
    }

    @Test
    void receiveCash() {
        User user = new User();

        user.receiveCash(1000);

        assertEquals(1000, user.cash());
    }

    @Test
    void spendCash() {
        User user = new User();

        user.spendCash(1000);

        assertEquals(-1000, user.cash());
    }

    @Test
    void accountTransaction() {
        User user = new User();

        user.addAccount(new Account("이건통장이다", 10000));
        user.addAccount(new Account("재원통장", 20000));

        user.accountTransaction("수입", "이건통장이다", 1000);

        assertEquals(11000, user.account().get(0).amount());

        user.accountTransaction("지출", "재원통장", 1000);

        assertEquals(19000, user.account().get(1).amount());
    }

    @Test
    void cardTransaction() {
        User user = new User();

        user.addAccount(new Account("이건통장이다", 10000));
        user.addAccount(new Account("재원통장", 20000));

        user.addCard(new Card("카드1", "이건통장이다"));
        user.addCard(new Card("재원카드", "재원통장"));

        user.cardTransaction("지출", "카드1", 1000);
        user.cardTransaction("지출", "재원카드", 1000);


        assertEquals(9000, user.account().get(0).amount());
        assertEquals(19000, user.account().get(1).amount());
    }
}
