package models;

public class Transaction {
    private String date;
    private String type;
    private String payment;
    private int amount;
    private String comment;

    public Transaction(String date,
                       String type,
                       String payment,
                       int amount,
                       String comment) {

        this.date = date;
        this.type = type;
        this.payment = payment;
        this.amount = amount;
        this.comment = comment;
    }

    public String date() {
        return date;
    }

    public String type() {
        return type;
    }

    public String payment() {
        return payment;
    }

    public int amount() {
        return amount;
    }

    public String comment() {
        return comment;
    }

    public void editDate(String date) {
        this.date = date;
    }

    public void editType(String type) {
        this.type = type;
    }

    public void editPayment(String payment) {
        this.payment = payment;
    }

    public void editAmount(int amount) {
        this.amount = amount;
    }

    public void editComment(String comment) {
        this.comment = comment;
    }
}
