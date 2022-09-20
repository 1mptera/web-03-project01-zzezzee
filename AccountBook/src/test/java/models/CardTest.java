package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void create() {
        Card card = new Card("카드1", "통장1");

        assertEquals("카드1", card.name());
        assertEquals("통장1", card.linkedAccount());
    }

}
