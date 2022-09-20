package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssetTest {

    @Test
    void bankBook() {
        BankBook bankBook1 = new BankBook("wooriBankBook", 100000);
        BankBook bankBook2 = new BankBook("hanaBankBook", 200000);

        Asset asset = new Asset();

        asset.add(bankBook1);
        asset.add(bankBook2);

        assertEquals("wooriBankBook", asset.bankBook().get(0).name());
        assertEquals("hanaBankBook", asset.bankBook().get(1).name());

        assertEquals("wooriBankBook", asset.bankBook().get(0).name());
        assertEquals("hanaBankBook", asset.bankBook().get(1).name());
    }

    @Test
    void amount() {
        Cash cash = new Cash(10000);

        BankBook bankBook1 = new BankBook("wooriBankBook", 100000);
        BankBook bankBook2 = new BankBook("hanaBankBook", 200000);

        Asset asset = new Asset();

        asset.add(cash);
        asset.add(bankBook1);
        asset.add(bankBook2);

        assertEquals(310000, asset.amount());
    }

    @Test
    void sumOfBankBookAmount() {
        Asset asset = new Asset();
        asset.add(new BankBook("통장1", 10000));
        asset.add(new BankBook("통장2", 20000));

        int totalAmount = asset.totalBankBookAmount();

        assertEquals(30000, totalAmount);
    }
}
