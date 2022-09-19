import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class AccountBook {
    JFrame frame;
    private JPanel memoPanel;
    private JPanel menuPanel;
    private JPanel assetPanel;
    private JPanel inputPanel;
    private JPanel transactionPanel;
    private JLayeredPane layeredPane;
    private JPanel cashPanel;
    private JPanel bankBookPanel;
    private JPanel cardPanel;


    public static void main(String[] args) {
        AccountBook application = new AccountBook();
        application.run();
    }

    private void run() {
        initFrame();

        //메뉴 패널
        initAssetPanel();
        initAssetMenuButtons();
        initAssetLayeredPanel();

        initInputPanel();
        initTransactionPanel();
        initMemoPanel();

        initMenuPanel();
        initMenusButton();


        frame.setVisible(true);
    }

    private void initMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, 800, 480);
        frame.getContentPane().add(menuPanel);
        menuPanel.setLayout(null);
    }

    private void initMemoPanel() {
        memoPanel = new JPanel();
        memoPanel.setBackground(new Color(255, 255, 255));
        memoPanel.setBounds(0, 0, 800, 420);
        frame.getContentPane().add(memoPanel);
        memoPanel.setLayout(null);

        JButton btnNewButton_1 = new JButton("MemoPanel");
        btnNewButton_1.setBounds(341, 5, 314, 223);
        memoPanel.add(btnNewButton_1);
        memoPanel.setVisible(false);
    }

    private void initTransactionPanel() {
        transactionPanel = new JPanel();
        transactionPanel.setBackground(new Color(255, 255, 255));
        transactionPanel.setBounds(0, 0, 800, 420);
        frame.getContentPane().add(transactionPanel);
        transactionPanel.setLayout(null);

        JButton sdf = new JButton("New button");
        sdf.setBounds(0, 0, 117, 29);
        transactionPanel.add(sdf);
        transactionPanel.setVisible(true);

    }

    private void initInputPanel() {
        inputPanel = new JPanel();
        inputPanel.setBackground(SystemColor.activeCaption);
        inputPanel.setBounds(0, 0, 800, 420);
        frame.getContentPane().add(inputPanel);

        JButton btnNewButton_4 = new JButton("InputPanel");
        inputPanel.add(btnNewButton_4);
        inputPanel.setVisible(false);
    }

    private void initMenusButton() {
        JButton inputButton = new JButton("입력");
        inputButton.addActionListener(event -> {
            inputPanel.setVisible(true);
            transactionPanel.setVisible(false);
            assetPanel.setVisible(false);
            memoPanel.setVisible(false);
        });
        inputButton.setBounds(0, 423, 200, 50);
        inputButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        menuPanel.add(inputButton);

        JButton transactionsButton = new JButton("내역");
        transactionsButton.addActionListener(event -> {
            inputPanel.setVisible(false);
            transactionPanel.setVisible(true);
            assetPanel.setVisible(false);
            memoPanel.setVisible(false);
        });
        transactionsButton.setBounds(200, 423, 200, 50);
        transactionsButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        menuPanel.add(transactionsButton);

        JButton assetButton = new JButton("자산");
        assetButton.setBounds(400, 423, 200, 50);
        assetButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        assetButton.addActionListener(event -> {
            inputPanel.setVisible(false);
            transactionPanel.setVisible(false);
            assetPanel.setVisible(true);
            memoPanel.setVisible(false);
        });
        menuPanel.add(assetButton);

        JButton memoButton = new JButton("메모");
        memoButton.addActionListener(event -> {
            inputPanel.setVisible(false);
            transactionPanel.setVisible(false);
            assetPanel.setVisible(false);
            memoPanel.setVisible(true);
        });

        memoButton.setBounds(600, 423, 200, 50);
        memoButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        menuPanel.add(memoButton);
    }


    private void initAssetLayeredPanel() {
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(134, 0, 213, 420);
        assetPanel.add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        cashPanel = new JPanel();
        layeredPane.add(cashPanel, "name_289564040343291");
        cashPanel.setLayout(null);

        JLabel label1 = new JLabel("현금");
        label1.setBounds(24, 20, 148, 60);
        cashPanel.add(label1);

        cardPanel = new JPanel();
        layeredPane.add(cardPanel, "name_289868445394958");
        cardPanel.setLayout(null);

        JLabel label3 = new JLabel("카드");
        label3.setBounds(66, 54, 61, 16);
        cardPanel.add(label3);

        bankBookPanel = new JPanel();
        layeredPane.add(bankBookPanel, "name_290962919771208");
        bankBookPanel.setLayout(null);

        JLabel label2 = new JLabel("통장");
        label2.setBounds(59, 41, 61, 16);
        bankBookPanel.add(label2);
        assetPanel.setVisible(false);
    }

    private void initAssetMenuButtons() {
        JButton cashPanelButton = new JButton("현금");
        cashPanelButton.addActionListener( event ->{
                layeredPane.removeAll();
                layeredPane.add(cashPanel);
                layeredPane.repaint();
                layeredPane.revalidate();
        });
        cashPanelButton.setBounds(6, 6, 117, 125);
        assetPanel.add(cashPanelButton);

        JButton bankBookPanelButton = new JButton("통장");
        bankBookPanelButton.addActionListener( event ->{
                layeredPane.removeAll();
                layeredPane.add(bankBookPanel);
                layeredPane.repaint();
                layeredPane.revalidate();

        });
        bankBookPanelButton.setBounds(6, 135, 117, 125);
        assetPanel.add(bankBookPanelButton);

        JButton cardPanelButton = new JButton("카드");
        cardPanelButton.addActionListener( event ->{
                layeredPane.removeAll();
                layeredPane.add(cardPanel);
                layeredPane.repaint();
                layeredPane.revalidate();
        });

        cardPanelButton.setBounds(0, 295, 135, 125);
        assetPanel.add(cardPanelButton);
    }

    private void initAssetPanel() {
        assetPanel = new JPanel();
        assetPanel.setBackground(SystemColor.activeCaption);
        assetPanel.setBounds(0, 0, 800, 420);
        frame.getContentPane().add(assetPanel);
        assetPanel.setLayout(null);
    }

    private void initFrame() {
        frame = new JFrame();
        frame.setBackground(SystemColor.activeCaption);
        frame.setBounds(100, 100, 800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
    }
}
