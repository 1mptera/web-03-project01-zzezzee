import models.Transaction;
import models.TransactionManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;

public class TransactionPanel extends JPanel {
    private JPanel contentPanel;
    private TransactionManager transactionManager;
    private JPanel statusPanel;
    private JPanel updatePanel;

    public TransactionPanel(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;

        setBackground(SystemColor.activeCaption);
        setBounds(0, 0, 600, 420);
        setBackground(Color.gray);
        setLayout(null);

        initContentPanel();
        initUpdatePanel();
        initStatusPanel();

    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBounds(0, 0, 600, 280);

        contentPanel.setBackground(Color.PINK);

        JPanel transactionPanel = new JPanel();
        transactionPanel.setBackground(Color.PINK);
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
            transactionPanel.add(button1);

            JButton button2 = new JButton("X");
            button2.addActionListener( event -> {
                transactionManager.transactions().remove(transaction);

                updatePanel();
            });

            transactionPanel.add(button2);
        }

        contentPanel.add(transactionPanel, BorderLayout.PAGE_START);

        add(contentPanel, BorderLayout.PAGE_START);
    }

    private void initUpdatePanel() {
        updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(0, 7));
        updatePanel.setBounds(0, 280, 600, 50);

        updatePanel.setBackground(Color.orange);

        add(updatePanel);
    }

    private void initStatusPanel() {
        statusPanel = new JPanel();
        statusPanel.setLayout(new FlowLayout());
        statusPanel.setBounds(0, 330, 600, 40);

        JLabel label1 = new JLabel("지출 합계: ");
        statusPanel.add(label1);

        JTextField textField1 = new JTextField(10);
        textField1.setEditable(false);
        statusPanel.add(textField1);

        JLabel label2 = new JLabel(" 수입 합계: ");
        statusPanel.add(label2);

        JTextField textField2 = new JTextField(10);
        textField2.setEditable(false);
        statusPanel.add(textField2);

        JLabel label3 = new JLabel(" 자산 합계: ");
        statusPanel.add(label3);

        JTextField textField3 = new JTextField(10);
        textField3.setEditable(false);
        statusPanel.add(textField3);

        add(statusPanel);
    }

    private void updatePanel() {
        removeAll();
        initContentPanel();
        initStatusPanel();
        initUpdatePanel();

        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
        statusPanel.setVisible(false);
        statusPanel.setVisible(true);
        updatePanel.setVisible(false);
        updatePanel.setVisible(true);
    }
}
