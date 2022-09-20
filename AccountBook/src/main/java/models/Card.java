package models;

import java.util.List;

public class Card {
    private String name;
    private String  bankBook;
    private List<BankBook> bankBookList;

    public Card(String name, String bankBook, List<BankBook> bankBookList) {
        this.name = name;
        this.bankBook = bankBook;
        this.bankBookList = bankBookList;
    }

    public void spend(int amount) {
//        for (BankBook b : bankBookList){
//            System.out.println(b.name());
//            if(b.name().equals(bankBook)){
//                b.spend(amount);
//            }
//        }
    }

    public String name() {
        return name;
    }
}
