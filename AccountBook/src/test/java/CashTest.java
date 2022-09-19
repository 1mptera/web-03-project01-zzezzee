import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashTest {
    @Test
    void create() {
        Cash cash = new Cash(10000);


        assertEquals(10000, cash.amount());
    }

}
