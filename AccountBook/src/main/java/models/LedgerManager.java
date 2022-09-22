package models;

public class LedgerManager {
    private User user;
    private TransactionManager transactionManager;
    private String type = "";
    private String payment = "";
    private int amount = 0;

    public LedgerManager(User user, TransactionManager transactionManager) {
        this.user = user;
        this.transactionManager = transactionManager;
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

    public void transferTransaction(Transaction transaction) {
        type = transaction.type();
        payment = transaction.payment();
        amount = transaction.amount();

        transactionManager.addTransaction(transaction);

        if(type.equals("수입") && payment.equals("현금")){
            receiveCash();
        }

        if(type.equals("지출") && payment.equals("현금")){
            spendCash();
        }

        if (!payment.equals("현금")) {
            user.reflectTransaction(type, payment, amount);
        }
    }

    public void receiveCash() {
        user.receiveCash(amount);
    }

    public void spendCash() {
        user.spendCash(amount);
    }

}
