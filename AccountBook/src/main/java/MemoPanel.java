import models.Memo;
import models.MemoManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;

public class MemoPanel extends JPanel {
    private JPanel contentPanel;
    private MemoManager memoManager;

    public MemoPanel(MemoManager memoManager) {
        this.memoManager = memoManager;

        setBackground(SystemColor.activeCaption);
        setBounds(0, 0, 600, 420);
        setBackground(Color.orange);
        setLayout(null);

        initContentPanel();
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBounds(0, 0, 600, 420);

        contentPanel.setBackground(Color.PINK);

        JPanel memoPanel = new JPanel();
        memoPanel.setBackground(Color.PINK);
        memoPanel.setLayout(new GridLayout(0, 3));

        JTextField textField1 = new JTextField();
        memoPanel.add(textField1);

        JButton button = new JButton("저장");
        button.addActionListener(event -> {
            String memo = textField1.getText();

            memoManager.add(new Memo(memo));

            updatePanel();
        });
        memoPanel.add(button);

        JLabel label = new JLabel("");
        memoPanel.add(label);

        for (Memo memo : memoManager.getMemos()) {
            JTextField textField2 = new JTextField();
            textField2.setText(memo.memo());
            memoPanel.add(textField2);

            JButton button1 = new JButton("수정");
            button1.addActionListener(event -> {
                String content = textField2.getText();

                memoManager.editMemo(memo, content);

                updatePanel();
            });
            memoPanel.add(button1);

            JButton button2 = new JButton("X");
            button2.addActionListener(event -> {
                memoManager.getMemos().remove(memo);

                updatePanel();
            });
            memoPanel.add(button2);
        }


        contentPanel.add(memoPanel, BorderLayout.PAGE_START);

        add(contentPanel, BorderLayout.PAGE_START);
    }

    private void updatePanel() {
        removeAll();
        initContentPanel();
        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
    }
}
