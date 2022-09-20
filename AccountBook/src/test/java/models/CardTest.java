package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void create() {
        BankBook bankBook = new BankBook("woori", 100000);
        Card card = new Card("WorriCard", "woori", List.of(new BankBook("", 0)));

        assertEquals("WorriCard", card.name());
    }

    @Test
    void spend() {
//        BankBook bankBook = new BankBook("woori", 100000);
//        Card card = new Card("WorriCard", "woori", List.of(new BankBook("", 0)));
//
//        card.spend(10000);
//
//        assertEquals(90000, bankBook.amount());
    }
}
