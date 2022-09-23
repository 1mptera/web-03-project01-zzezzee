import files.AccountFile;
import files.CashFile;
import files.TransactionFile;
import models.Transaction;
import models.TransactionManager;
import models.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.io.File;
import java.io.IOException;

public class TransactionPanel extends JPanel {
    private JPanel contentPanel;
    private User user;
    private TransactionManager transactionManager;
    private TransactionFile transactionFile;
    private CashFile cashFile;
    private AccountFile accountFile;
    private JPanel statusPanel;

    public TransactionPanel(User user, TransactionManager transactionManager, TransactionFile transactionFile, CashFile cashFile, AccountFile accountFile) {
        this.user = user;
        this.transactionManager = transactionManager;
        this.transactionFile = transactionFile;
        this.cashFile = cashFile;
        this.accountFile = accountFile;

        setBackground(SystemColor.activeCaption);
        setBounds(0, 0, 600, 420);
        setBackground(Color.gray);
        setLayout(null);

        initContentPanel();
        initStatusPanel();
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBounds(0, 0, 600, 330);

        contentPanel.setBackground(new Color(245, 255, 250));

        JPanel transactionPanel = new JPanel();
        transactionPanel.setLayout(new GridLayout(0, 7));

        JLabel label1 = new JLabel("날짜");
        label1.setHorizontalAlignment(JLabel.CENTER);
        transactionPanel.add(label1);

        JLabel label2 = new JLabel("거래타입");
        label2.setHorizontalAlignment(JLabel.CENTER);
        transactionPanel.add(label2);

        JLabel label3 = new JLabel("결제수단");
        label3.setHorizontalAlignment(JLabel.CENTER);
        transactionPanel.add(label3);

        JLabel label4 = new JLabel("금액");
        label4.setHorizontalAlignment(JLabel.CENTER);
        transactionPanel.add(label4);

        JLabel label5 = new JLabel("메모");
        label5.setHorizontalAlignment(JLabel.CENTER);
        transactionPanel.add(label5);

        JLabel label6 = new JLabel("수정");
        label6.setHorizontalAlignment(JLabel.CENTER);
        transactionPanel.add(label6);

        JLabel label7 = new JLabel("삭제");
        label7.setHorizontalAlignment(JLabel.CENTER);
        transactionPanel.add(label7);


        for (Transaction transaction : transactionManager.transactions()) {
            JTextField textField1 = new JTextField(10);
            textField1.setText(transaction.date());
            transactionPanel.add(textField1);

            JTextField textField2 = new JTextField(7);
            textField2.setText(transaction.type());
            transactionPanel.add(textField2);

            JTextField textField3 = new JTextField(7);
            textField3.setText(transaction.payment());
            transactionPanel.add(textField3);

            JTextField textField4 = new JTextField(7);
            textField4.setText(Integer.toString(transaction.amount()));
            transactionPanel.add(textField4);

            JTextField textField5 = new JTextField(7);
            textField5.setText(transaction.comment());
            transactionPanel.add(textField5);

            JButton button1 = new JButton("수정");
            button1.addActionListener(event -> {
                String date = textField1.getText();
                String type = textField2.getText();
                String payment = textField3.getText();
                int amount = Integer.parseInt(textField4.getText());
                String comment = textField5.getText();

                transactionManager.editTransaction(transaction, date, type, payment, amount, comment);

                updatePanel();

                try {
                    transactionFile.updateFile(new File("Transaction.csv"));
                    cashFile.updateFile(new File("Cash.csv"));
                    accountFile.updateFile(new File("AccountFile.csv"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
            transactionPanel.add(button1);

            JButton button2 = new JButton("X");
            button2.addActionListener( event -> {
                user.removeTransaction(transaction);
                transactionManager.transactions().remove(transaction);

                updatePanel();

                try {
                    transactionFile.updateFile(new File("Transaction.csv"));
                    cashFile.updateFile(new File("Cash.csv"));
                    accountFile.updateFile(new File("AccountFile.csv"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            transactionPanel.add(button2);
        }

        contentPanel.add(transactionPanel, BorderLayout.PAGE_START);

        add(contentPanel, BorderLayout.PAGE_START);
    }

    private void initStatusPanel() {
        statusPanel = new JPanel();
        statusPanel.setLayout(new FlowLayout());
        statusPanel.setBounds(0, 330, 600, 40);

        JLabel label1 = new JLabel("지출 합계: ");
        statusPanel.add(label1);

        JTextField textField1 = new JTextField(10);
        textField1.setEditable(false);
        textField1.setText(Integer.toString(transactionManager.totalSpend()));
        statusPanel.add(textField1);

        JLabel label2 = new JLabel(" 수입 합계: ");
        statusPanel.add(label2);

        JTextField textField2 = new JTextField(10);
        textField2.setEditable(false);
        textField2.setText(Integer.toString(transactionManager.totalReceive()));
        statusPanel.add(textField2);

        JLabel label3 = new JLabel(" 금액 합계: ");
        statusPanel.add(label3);

        JTextField textField3 = new JTextField(10);
        textField3.setEditable(false);
        textField3.setText(Integer.toString(transactionManager.totalSpend() + transactionManager.totalReceive()));
        statusPanel.add(textField3);

        add(statusPanel);
    }

    private void updatePanel() {
        removeAll();
        initContentPanel();
        initStatusPanel();

        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
        statusPanel.setVisible(false);
        statusPanel.setVisible(true);
    }
}
