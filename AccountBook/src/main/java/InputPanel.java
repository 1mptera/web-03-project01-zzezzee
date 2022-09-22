import models.Ledger;
import models.Transaction;
import models.TransactionManager;
import models.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;

public class InputPanel extends JPanel {
    private User user;
    private Ledger ledgerManager;
    private TransactionManager transactionManager;

    private JPanel contentPanel;

    public InputPanel(User user, TransactionManager transactionManager) {
        this.user = user;
        this.transactionManager = transactionManager;
        ledgerManager = new Ledger(user, transactionManager);

        setBackground(SystemColor.activeCaption);
        setBounds(0, 0, 600, 420);
        setBackground(Color.ORANGE);
        setLayout(null);


        initContentPanel();
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0,2));
        contentPanel.setBounds(0, 0, 600, 300);

        contentPanel.setBackground(Color.PINK);

        initButtons();

        add(contentPanel);
    }

    private void initButtons() {
        JLabel label1 = new JLabel("Date : ");
        JTextField textField1 = new JTextField(10);

        JLabel label2 = new JLabel("Type : ");
        JTextField textField2 = new JTextField(10);

        JLabel label3 = new JLabel("payment : ");
        JTextField textField3 = new JTextField(10);

        JLabel label4 = new JLabel("amount : ");
        JTextField textField4 = new JTextField(10);

        JLabel label5 = new JLabel("comment");
        JTextField textField5 = new JTextField(10);

        JLabel label6 = new JLabel("");
        JButton button = new JButton("추가");
        button.addActionListener( event -> {
            String date = textField1.getText();
            String type = textField2.getText();
            String payment = textField3.getText();
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
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
        });

        contentPanel.add(label1);
        contentPanel.add(textField1);
        contentPanel.add(label2);
        contentPanel.add(textField2);
        contentPanel.add(label3);
        contentPanel.add(textField3);
        contentPanel.add(label4);
        contentPanel.add(textField4);
        contentPanel.add(label5);
        contentPanel.add(textField5);
        contentPanel.add(label6);
        contentPanel.add(button);
    }
}
