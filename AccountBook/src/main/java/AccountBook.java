import models.Asset;
import models.Cash;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

public class AccountBook {
    JFrame frame;
    private JPanel contentPanel;
    private Asset asset;
    private Cash cash;

    public static void main(String[] args) {
        AccountBook application = new AccountBook();
        application.run();
    }

    private void run() {
        initObject();

        initFrame();
    }

    private void initObject() {
        asset = new Asset();
        cash = new Cash(0);
    }

    private void initFrame() {
        frame = new JFrame("AccountBook");
        frame.setBackground(SystemColor.activeCaption);
        frame.setBounds(100, 100, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        initConcentPanel();
        initButtonsPanel();

        frame.setVisible(true);
    }

    private void initConcentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBounds(0, 0, 600, 370);
        contentPanel.setLayout(new GridLayout(1, 0));
        contentPanel.setBackground(Color.BLUE);

        frame.add(contentPanel);
    }

    private void initButtonsPanel() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 370, 600, 100);
        panel.setLayout(new GridLayout(1, 0));

        panel.add(createInputButton());
        panel.add(createTransactionButton());
        panel.add(createAssetButton());
        panel.add(createMemoButton());

        frame.add(panel);
    }

    private JButton createInputButton() {
        JButton inputButton = new JButton("입력");
        inputButton.addActionListener(event -> {
            InputPanel inputPanel = new InputPanel();
            updateContentPanel(inputPanel);
        });
        inputButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

        return inputButton;
    }

    private JButton createTransactionButton() {
        JButton transactionButton = new JButton("내역");
        transactionButton.addActionListener(event -> {
            TransactionPanel transactionPanel = new TransactionPanel();
            updateContentPanel(transactionPanel);
        });
        transactionButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

        return transactionButton;
    }

    private JButton createAssetButton() {
        JButton AssetButton = new JButton("자산");
        AssetButton.addActionListener(event -> {
            AssetPanel assetPanel = new AssetPanel(asset, cash);
            updateContentPanel(assetPanel);
        });
        AssetButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

        return AssetButton;
    }

    private JButton createMemoButton() {
        JButton memoButton = new JButton("메모");
        memoButton.addActionListener(event -> {
            MenuPanel menuPanel = new MenuPanel();
            updateContentPanel(menuPanel);
        });

        memoButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

        return memoButton;
    }
    private void updateContentPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel);

        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
    }

}

