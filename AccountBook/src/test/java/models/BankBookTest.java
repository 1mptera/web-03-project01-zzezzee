package models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankBookTest {

    @Test
    void create() {
        BankBook bankBook = new BankBook("woori", 100000);

        assertEquals("woori", bankBook.name());
        assertEquals(100000, bankBook.amount());
    }

    @Test
    void spend() {
        BankBook bankBook = new BankBook("woori", 100000);

        bankBook.spend(1000);

        assertEquals(99000, bankBook.amount());
    }

    @Test
    void income() {
        BankBook bankBook = new BankBook("woori", 100000);


        bankBook.income(1000);

        assertEquals(101000, bankBook.amount());
    }

    @Test
    void addCard() {
        BankBook bankBook = new BankBook("통장1" , 100);

        bankBook.add(new Card("testCard", "통장1", List.of(new BankBook("", 1))));

        assertEquals("testCard", bankBook.cards().get(0).name());
    }
}
