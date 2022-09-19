import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;

public class AssetPanel extends JPanel {
    private JPanel contentPanel;
    private JPanel statusPanel;
    private Asset asset;
    private Cash cash;

    public AssetPanel(Asset asset, Cash cash) {
        this.asset = asset;
        this.cash = cash;

        setBackground(SystemColor.activeCaption);
        setBounds(0, 0, 600, 420);
        setLayout(null);
        setBackground(Color.WHITE);

        initContentPanel();

        totalPanel();

        initButtons();
    }

    private void totalPanel() {
        initStatusPanel();
        initCashPanel();
        initBankBookPanel();
        initCardPanel();
        initListPanel1();
        initListPanel2();
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.PINK);
        contentPanel.setBounds(0, 50, 600, 420);
        contentPanel.setLayout(null);

        add(contentPanel);
    }

    private void initListPanel1() {
        JPanel listPanel1 = new JPanel();
        listPanel1.setBounds(200, 150, 200, 130);
        listPanel1.setBackground(Color.ORANGE);
        listPanel1.setLayout(new GridLayout(0, 1));


        contentPanel.add(listPanel1);
    }

    private void initListPanel2() {
        JPanel listPanel2 = new JPanel();
        listPanel2.setBounds(400, 150, 200, 130);
        listPanel2.setBackground(Color.ORANGE);
        listPanel2.setLayout(new GridLayout(0, 1));


        contentPanel.add(listPanel2);
    }

    private void initStatusPanel() {
        statusPanel = new JPanel();
        statusPanel.setBounds(0, 280, 600, 40);
        statusPanel.setLayout(new FlowLayout());

        statusPanel.add(new JLabel("총 자산: "));
        JTextField totalAsset = new JTextField(10);
        totalAsset.setText(Integer.toString(asset.amount()));
        totalAsset.setEditable(false);
        statusPanel.add(totalAsset);

        statusPanel.add(new JLabel("통장: "));
        JTextField bankBookAsset = new JTextField(10);

        totalAsset.setEditable(false);

        statusPanel.add(bankBookAsset);

        statusPanel.add(new JLabel("현금: "));
        JTextField cashAsset = new JTextField(10);
        cashAsset.setText(Integer.toString(cash.amount()));
        totalAsset.setEditable(false);
        statusPanel.add(cashAsset);

        contentPanel.add(statusPanel);
    }

    private void initCashPanel() {
        JPanel assetInputPanel = new JPanel();
        assetInputPanel.setBounds(0, 0, 200, 150);
        assetInputPanel.setBackground(Color.ORANGE);
        assetInputPanel.setLayout(new GridLayout(0, 1));

        JLabel label = new JLabel("현금 입력");
        assetInputPanel.add(label);

        JTextField textField = new JTextField();
        assetInputPanel.add(textField);

        JButton saveButton = new JButton("저장");
        saveButton.addActionListener(event ->{
            int amount = Integer.parseInt(textField.getText());
            cash.income(amount);
            asset.add(cash);
            updateContentPanel();
        });
        assetInputPanel.add(saveButton);

        contentPanel.add(assetInputPanel);
    }

    private void initBankBookPanel() {
        JPanel assetInputPanel = new JPanel();
        assetInputPanel.setBounds(200, 0, 200, 150);
        assetInputPanel.setBackground(Color.ORANGE);
        assetInputPanel.setLayout(new GridLayout(0, 1));

        JLabel label = new JLabel("통장 입력");
        assetInputPanel.add(label);

        JTextField name = new JTextField();
        name.setText("통장 이름");
        assetInputPanel.add(name);

        JTextField amount = new JTextField();
        amount.setText("통장 잔액");
        assetInputPanel.add(amount);

        JButton saveButton = new JButton("저장");
        assetInputPanel.add(saveButton);

        contentPanel.add(assetInputPanel);
    }

    private void initCardPanel() {
        JPanel assetInputPanel = new JPanel();
        assetInputPanel.setBounds(400, 0, 200, 150);
        assetInputPanel.setBackground(Color.ORANGE);
        assetInputPanel.setLayout(new GridLayout(0, 1));

        JLabel label = new JLabel("카드 입력");
        assetInputPanel.add(label);

        JTextField textField = new JTextField();
        assetInputPanel.add(textField);

        JButton saveButton = new JButton("저장");
        assetInputPanel.add(saveButton);

        contentPanel.add(assetInputPanel);
    }

    private void initButtons() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBounds(0, 0, 600, 50);
        buttonsPanel.setBackground(Color.ORANGE);
        buttonsPanel.setLayout(new GridLayout(1, 0));

        buttonsPanel.add(createCashButton());
        buttonsPanel.add(createBankBookButton());
        buttonsPanel.add(createCardButton());

        add(buttonsPanel);
    }

    private JButton createCashButton() {
        JButton button = new JButton("현금");
        button.addActionListener(event -> {



        });
        return button;
    }

    private JButton createBankBookButton() {
        JButton button = new JButton("통장");
        button.addActionListener(event -> {

        });
        return button;
    }

    private JButton createCardButton() {
        JButton button = new JButton("카드");
        button.addActionListener(event -> {

        });
        return button;
    }

    private void updateContentPanel() {
        contentPanel.removeAll();
        totalPanel();
        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
    }
}
