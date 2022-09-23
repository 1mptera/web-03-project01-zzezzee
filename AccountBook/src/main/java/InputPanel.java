import files.AccountFile;
import files.CashFile;
import files.TransactionFile;
import models.Account;
import models.Card;
import models.Ledger;
import models.Transaction;
import models.TransactionManager;
import models.User;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputPanel extends JPanel {
    private User user;
    private Ledger ledgerManager;
    private TransactionManager transactionManager;
    private TransactionFile transactionFile;
    private CashFile cashFile;
    private AccountFile accountFile;

    private JPanel contentPanel;

    public InputPanel(User user, TransactionManager transactionManager, TransactionFile transactionFile, CashFile cashFile, AccountFile accountFile) {
        this.user = user;
        this.transactionManager = transactionManager;
        this.transactionFile = transactionFile;
        this.cashFile = cashFile;
        this.accountFile = accountFile;
        ledgerManager = new Ledger(user, transactionManager);


        setBounds(0, 0, 600, 420);
        setBackground(new Color(255, 240, 250));
        setLayout(null);



        initContentPanel();
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0,2));
        contentPanel.setBounds(200, 0, 400, 370);

        contentPanel.setBackground(new Color(245, 255, 250));

        initButtons();

        add(contentPanel);
    }

    private void initButtons() {
        JLabel label1 = new JLabel("날짜 : ");
        label1.setHorizontalAlignment(JLabel.RIGHT);
        label1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        JTextField textField1 = new JTextField(10);

        JLabel label2 = new JLabel("수입 or 지출 : ");
        label2.setHorizontalAlignment(JLabel.RIGHT);
        label2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        JComboBox comboBox = new JComboBox(new String[]{"수입", "지출"});

        JLabel label3 = new JLabel("결제수단 : ");
        label3.setHorizontalAlignment(JLabel.RIGHT);
        label3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

        List<String> paymentList = new ArrayList<>();
        paymentList.add("현금");
        for (Account account : user.account()) {
            paymentList.add(account.name());
        }
        for (Card card : user.card()) {
            paymentList.add(card.name());
        }

        String[] payments = new String[paymentList.size()];

        for (int i = 0; i < paymentList.size(); i += 1) {
            payments[i] = paymentList.get(i);
        }
        JComboBox comboBox1 = new JComboBox(payments);

//        JTextField textField3 = new JTextField(10);

        JLabel label4 = new JLabel("금액 : ");
        label4.setHorizontalAlignment(JLabel.RIGHT);
        label4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("메모 : ");
        label5.setHorizontalAlignment(JLabel.RIGHT);
        label5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("");
        JButton button = new JButton("추가");
        button.addActionListener( event -> {
            String date = textField1.getText();
            String type = (String) comboBox.getSelectedItem();
            String payment = (String) comboBox1.getSelectedItem();
            int amount = Integer.parseInt(textField4.getText());
            String comment = textField5.getText();

            ledgerManager.transferTransaction(new Transaction(
                    date,
                    type,
                    payment,
                    amount,
                    comment
            ));

            textField1.setText("");
//            textField3.setText("");
            textField4.setText("");
            textField5.setText("");

            try {
                transactionFile.updateFile(new File("Transaction.csv"));
                cashFile.updateFile(new File("Cash.csv"));
                accountFile.updateFile(new File("Account.csv"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        contentPanel.add(label1);
        contentPanel.add(textField1);
        contentPanel.add(label2);
        contentPanel.add(comboBox);
        contentPanel.add(label3);
        contentPanel.add(comboBox1);
        contentPanel.add(label4);
        contentPanel.add(textField4);
        contentPanel.add(label5);
        contentPanel.add(textField5);
        contentPanel.add(label6);
        contentPanel.add(button);
    }
}
