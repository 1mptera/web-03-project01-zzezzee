package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void create() {
        BankBook bankBook = new BankBook("woori", 100000);
        Card card = new Card("WorriCard", bankBook);

        assertEquals("WorriCard", card.name());
    }

    @Test
    void spend() {
        BankBook bankBook = new BankBook("woori", 100000);
        Card card = new Card("WorriCard", bankBook);

        card.spend(10000);

        assertEquals(90000, bankBook.amount());
    }
}
