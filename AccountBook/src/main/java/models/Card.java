package models;

public class Card {
    private String name;
    private String linkedAccount;

    public Card(String name, String linkedAccount) {
        this.name = name;
        this.linkedAccount = linkedAccount;
    }

    public String name() {
        return name;
    }

    public String linkedAccount() {
        return linkedAccount;
    }
}
