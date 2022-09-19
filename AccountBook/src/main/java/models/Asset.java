package models;

import java.util.ArrayList;
import java.util.List;

public class Asset {
    private List<BankBook> bankBooks = new ArrayList<>();
    private int amount = 0;

    public void add(BankBook bankBook) {
        bankBooks.add(bankBook);

        this.amount += bankBook.amount();
    }

    public void add(Cash cash) {
        this.amount += cash.amount();
    }

    public List<BankBook> bankBook() {
        return bankBooks;
    }

    public int amount() {
        return amount;
    }
}
